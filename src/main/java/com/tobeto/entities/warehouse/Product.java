package com.tobeto.entities.warehouse;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	private double price;
	private int quantity; // O ürünün toplam adeti 500 geldi
	private int unitInStock; // Ürünün o anki stok miktarı 480
	private int minimumCount; // Uyarı verecek miktarı
	private String description;

	@OneToMany(mappedBy = "product")
	private List<ShelfProduct> shelfProducts;

}