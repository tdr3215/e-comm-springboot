package com.tts.EcommProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;


@Data
@Entity
@Table(name="product_tbl")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long id;
	
	@Column(name="product_name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="image")
	private String image;
	
	@Column(name="price")
	private int price;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="category")
	private String category;
	
	@Column(name="quantity")
	private int quantity;

	

	
	

	

	

}
