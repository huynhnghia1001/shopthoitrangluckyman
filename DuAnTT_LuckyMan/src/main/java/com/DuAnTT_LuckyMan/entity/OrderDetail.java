package com.DuAnTT_LuckyMan.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Orderdetails")
public class OrderDetail implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	Float price;
	Integer quantity;
	String name;
	String height;
	String weight;
	String size;
	String image;
	String color;
	
	@ManyToOne
	@JoinColumn(name = "Orderid")
	Order order;
	
}
