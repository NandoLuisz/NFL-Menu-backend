package com.luis.foodsapp.repository;

import com.luis.foodsapp.domain.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
