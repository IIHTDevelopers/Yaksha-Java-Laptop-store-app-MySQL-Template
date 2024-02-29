package com.laptopstore.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptopstore.dto.LaptopDTO;
import com.laptopstore.service.LaptopService;

@Service
public class LaptopServiceImpl implements LaptopService {

	@Override
	public Page<LaptopDTO> getAllLaptops(Pageable pageable) {
		// write your logic here
		return null;
	}

	@Override
	public LaptopDTO getLaptopById(Long id) {
		// write your logic here
		return null;
	}

	@Override
	public LaptopDTO createLaptop(LaptopDTO laptopDTO) {
		// write your logic here
		return null;
	}

	@Override
	public LaptopDTO updateLaptop(Long id, LaptopDTO laptopDTO) {
		// write your logic here
		return null;
	}

	@Override
	public boolean deleteLaptop(Long id) {
		// write your logic here
		return false;
	}

	@Override
	public List<LaptopDTO> searchLaptopsByName(String name) {
		// write your logic here
		return null;
	}

	@Override
	public List<LaptopDTO> searchLaptopsByPrice(Double price) {
		// write your logic here
		return null;
	}

	@Override
	public List<LaptopDTO> searchLaptopsByBrand(String brand) {
		// write your logic here
		return null;
	}

	@Override
	public List<LaptopDTO> searchLaptops(String name, Double price, String brand) {
		// write your logic here
		return null;
	}
}
