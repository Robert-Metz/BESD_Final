package com.promineotech.pokemonApi.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "trainer")
public class Trainer {


	private Long id;
	private String name;
	private Boolean isMaster;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getIsMaster() {
		return isMaster;
	}
	
	public void setIsMaster(Boolean isMaster) {
		this.isMaster = isMaster;
	}

}
