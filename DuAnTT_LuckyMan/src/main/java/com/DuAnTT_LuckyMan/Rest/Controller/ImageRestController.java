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

import com.DuAnTT_LuckyMan.entity.Image;
import com.DuAnTT_LuckyMan.service.ImageService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/images")
public class ImageRestController {
 
	@Autowired
	ImageService imageService;

	@GetMapping()
	public List<Image> getAll() {
		return imageService.findAll();
	}
	
	@GetMapping("{id}")
	public Image getOne(@PathVariable("id") Integer id) {
		return imageService.findById(id);
	}
	@PostMapping
	public Image create(@RequestBody Image product) {
		return imageService.create(product);
	}
	@PutMapping("{id}")
	public Image update(@PathVariable("id") Integer id,@RequestBody Image product) {
		return imageService.update(product);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		imageService.delete(id);
	}
	
	@GetMapping("/product/{id}")
	public List<Image> getName(@PathVariable("id")Integer id) {
		return imageService.findId(id);
	}
	
	@GetMapping("/detail/{id}")
	public List<Image> getdetailid(@PathVariable("id")Integer id) {
		return imageService.findByProductDetail(id);
	}
}
