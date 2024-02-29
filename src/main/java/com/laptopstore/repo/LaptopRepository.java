package com.laptopstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptopstore.dto.LaptopDTO;

public interface LaptopRepository extends JpaRepository<LaptopDTO, Long> {

	// write your logic here to find all laptops by name

	// write your logic here to find all laptops by price

	// write your logic here to find all laptops by brand

	// write your logic here to search all laptops by name, price and brand
}
