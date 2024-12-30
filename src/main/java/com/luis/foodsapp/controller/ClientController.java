package com.luis.foodsapp.controller;


import com.luis.foodsapp.domain.client.Client;
import com.luis.foodsapp.domain.client.ClientRequestDTO;
import com.luis.foodsapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    public ResponseEntity<String> saveOrder(@RequestBody ClientRequestDTO data){
        Client clientData = new Client(data);
        clientRepository.save(clientData);
        return ResponseEntity.ok("Sucesso no cadastro do novo pedido!");
    }
}
