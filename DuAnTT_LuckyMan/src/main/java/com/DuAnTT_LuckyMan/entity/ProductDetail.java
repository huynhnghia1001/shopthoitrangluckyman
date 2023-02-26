package com.DuAnTT_LuckyMan.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Productdetails")
public class ProductDetail implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String height;
	String weight;
	String color;
	String size;
	
	@ManyToOne
	@JoinColumn(name = "Productid")
	Product product;
	
	@JsonIgnore
	@OneToMany(mappedBy = "productdetail")
	List<Image> Images;
}
