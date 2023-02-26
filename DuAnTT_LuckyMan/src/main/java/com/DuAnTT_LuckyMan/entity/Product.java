package com.DuAnTT_LuckyMan.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Products")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	Float price;
	String image;
	@Temporal(TemporalType.DATE)
	@Column(name = "Createdate")
	Date createDate = new Date();
	Boolean available;
	Boolean status;
	String company;
	
	@ManyToOne
	@JoinColumn(name = "Categoryid")
	CateSmall Catesmall;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<Promotion> Promotions;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<ProductDetail> ProductDetails;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<Image> Images;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<Description> Descriptions;
	
}
