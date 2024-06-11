package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.beans.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
