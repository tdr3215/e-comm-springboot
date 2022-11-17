package com.tts.EcommProject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tts.EcommProject.model.Product;
import com.tts.EcommProject.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products/{id}")
	public String show(@PathVariable long id, Model model) {
		Product product = productService.findById(id);
		model.addAttribute(product);
		return "product";
	}
	
//	@RequestMapping(value="/product",method= {RequestMethod.POST,RequestMethod.PUT})
//	public String createOrUpdate(@Valid Product product) {
//		productService.save(product);
//		return "redirect:/product/" +	product.getId();
//		
//	}

}
