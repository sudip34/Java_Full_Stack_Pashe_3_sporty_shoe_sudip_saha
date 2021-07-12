package com.phase3.sportyshoes.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Products {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String date;
	
	
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY )
	@JoinColumn(name="uid")
	private Users users;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pid")
	private Shoes shoes;

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Shoes getShoes() {
		return shoes;
	}

	public void setShoes(Shoes shoes) {
		this.shoes = shoes;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", date=" + date +  ", shoes=" + shoes + "]";
	}




	
	
}
