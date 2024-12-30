package com.luis.foodsapp.controller;

import com.luis.foodsapp.domain.food.Food;
import com.luis.foodsapp.domain.food.FoodRequestDTO;
import com.luis.foodsapp.domain.food.FoodResponseDTO;
import com.luis.foodsapp.exceptions.FoodRegisterException;
import com.luis.foodsapp.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @PostMapping
    public ResponseEntity<String> saveFood(@RequestBody FoodRequestDTO data){
        boolean foodExists = foodRepository.existsByTitle(data.title());
        if(foodExists){
            throw new FoodRegisterException("There is already a food with that title.");
        }
        Food foodData = new Food(data);
        foodRepository.save(foodData);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sucesso no cadastro da nova comida!");
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<FoodResponseDTO> foodList = foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(foodList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id){
        Optional<Food> foodByIdOptional = foodRepository.findById(id);
        return foodByIdOptional.<ResponseEntity<Object>>map(food ->
                ResponseEntity.status(HttpStatus.OK).body(food)).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food with id " + id + " not found"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> putById(@PathVariable(value = "id") Long id,
                                          @RequestBody FoodRequestDTO data){
        Optional<Food> foodByIdOptional = foodRepository.findById(id);
        if(foodByIdOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comida não encontrada.");
        }
        var foodPuted = foodByIdOptional.get();
        foodPuted.setTitle(data.title());
        foodPuted.setImage(data.image());
        foodPuted.setType(data.type());
        foodPuted.setDescription(data.description());
        foodPuted.setPrice(data.price());
        return ResponseEntity.status(HttpStatus.OK).body(foodRepository.save(foodPuted));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id){
        Optional<Food> foodByIdOptional = foodRepository.findById(id);
        if(foodByIdOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comida não encontrada.");
        }
        foodRepository.delete(foodByIdOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Comida deletada com sucesso.");
    }

}
