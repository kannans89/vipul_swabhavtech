package com.shopping.cart.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)", name = "id", unique = true)
	private UUID id;
	@Column(unique = true)
	private String name;
	private String password;
	
	@OneToMany(mappedBy = "cust", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Order> orders;
	
	public String getDetails() {
		String str = "";
		for (Order o : orders) {
			str += o.toString();
		}
		return str;
	}
	
	public Customer(){
		orders = new HashSet<Order>();
	}
	
	public void addOrder(Order order){
		orders.add(order);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UUID getId() {
		return id;
	}
}
