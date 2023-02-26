package com.DuAnTT_LuckyMan.Rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DuAnTT_LuckyMan.entity.Product;
import com.DuAnTT_LuckyMan.entity.ProductDetail;
import com.DuAnTT_LuckyMan.service.ProductDetailService;




@CrossOrigin("*")
@RestController
@RequestMapping("/rest/productDetails")
public class ProductDetailRestController {
	@Autowired
	ProductDetailService productService;
	
	@GetMapping()
	public List<ProductDetail> getAll() {
		return productService.findAll();
	}
	
	@GetMapping("{id}")
	public ProductDetail getOne(@PathVariable("id") Integer id) {
		return productService.findById(id);
	}
	@PostMapping
	public ProductDetail create(@RequestBody ProductDetail Product) {
		return productService.create(Product);
	}
	@PutMapping("{id}")
	public ProductDetail update(@PathVariable("id") Integer id,@RequestBody ProductDetail product) {
		return productService.update(product);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		productService.delete(id);
	}
	@GetMapping("/findid/{id}")
	public List<ProductDetail> getid(@PathVariable("id")Integer id) {
		return productService.findid(id);
	}
	@GetMapping("/findsize/{size}")
	public List<ProductDetail> getsize(@PathVariable("size")String size) {
		return productService.findsize(size);
	}
	
}
