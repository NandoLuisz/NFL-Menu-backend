package com.luis.foodsapp.domain.client;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "clients")
@Entity(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String order_details;

    private Float total_price;

    private String address;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    public Client(ClientRequestDTO data){
        this.email = data.email();
        this.address = data.address();
        this.total_price = data.total_price();
        this.order_details = data.order_details();
    }

    @PrePersist
    protected void onCreate() {
        this.orderDate = LocalDateTime.now();
    }

}
