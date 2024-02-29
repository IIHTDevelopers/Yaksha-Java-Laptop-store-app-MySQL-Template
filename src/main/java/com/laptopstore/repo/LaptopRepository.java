package com.laptopstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptopstore.dto.LaptopDTO;

public interface LaptopRepository extends JpaRepository<LaptopDTO, Long> {

	// write dynamic method for find by name

	// write dynamic method for find by price

	// write custom query to search by brand

	// write custom query to search by name, price and brand
}
