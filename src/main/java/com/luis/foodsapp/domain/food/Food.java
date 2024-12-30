package com.luis.foodsapp.domain.food;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "foods")
@Entity(name = "foods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String image;

    private String type;

    private String description;

    private Float price;

    public Food(FoodRequestDTO data){
        this.title = data.title();
        this.image = data.image();
        this.type = data.type();
        this.description = data.description();
        this.price = data.price();
    }
}
