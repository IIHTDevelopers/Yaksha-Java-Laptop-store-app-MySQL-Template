package com.laptopstore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.laptopstore.dto.LaptopDTO;

public interface LaptopService {

	Page<LaptopDTO> getAllLaptops(Pageable pageable);

	LaptopDTO getLaptopById(Long id);

	LaptopDTO createLaptop(LaptopDTO laptopDTO);

	LaptopDTO updateLaptop(Long id, LaptopDTO laptopDTO);

	boolean deleteLaptop(Long id);

	List<LaptopDTO> searchLaptopsByName(String name);

	List<LaptopDTO> searchLaptopsByPrice(Double price);

	List<LaptopDTO> searchLaptopsByBrand(String brand);

	List<LaptopDTO> searchLaptops(String name, Double price, String brand);
}
