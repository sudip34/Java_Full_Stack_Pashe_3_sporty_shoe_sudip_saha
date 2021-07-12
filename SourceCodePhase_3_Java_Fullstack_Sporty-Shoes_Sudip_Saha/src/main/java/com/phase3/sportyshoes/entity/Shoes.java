package com.phase3.sportyshoes.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Shoes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int pid;
	
	private String category;
	
	private int size;
	
	private int price;
	
	@OneToMany(mappedBy="shoes",cascade=CascadeType.ALL)
	private List<Products> products;

	@Override
	public String toString() {
		return "Shoes [pid=" + pid + ", category=" + category + ", size=" + size + ", price=" + price + ", products="
				+ products + "]";
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}
	
	
	


}
