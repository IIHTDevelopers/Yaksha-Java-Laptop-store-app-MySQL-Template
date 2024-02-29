package com.laptopstore.entity;

public class Laptop {

	private Long id;

	private String name;

	private Double price;

	private String brand;

	private String storage;

	private String ram;

	private String processor;

	public Laptop() {
		super();
	}

	public Laptop(Long id, String name, Double price, String brand, String storage, String ram, String processor) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.storage = storage;
		this.ram = ram;
		this.processor = processor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", price=" + price + ", brand=" + brand + ", storage=" + storage
				+ ", ram=" + ram + ", processor=" + processor + "]";
	}
}
