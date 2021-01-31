package com.promineotech.pokemonApi.entity;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trainer")
public class Trainer {


	private Long id;
	private String name;
	private Set<Pokemon> pokemon;
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
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "pokemon",
//			joinColumns = @JoinColumn(name = "trainerId", referencedColumnName = "id"),
//			inverseJoinColumns = @JoinColumn(name = "pokemonId", referencedColumnName = "id"))
//	public Set<Pokemon> getPokemon() {
//		return pokemon;
//	}
//	
//	public void setPokemon(Set<Pokemon> pokemon) {
//		this.pokemon = pokemon;
//	}
	
	public Boolean getIsMaster() {
		return isMaster;
	}
	
	public void setIsMaster(Boolean isMaster) {
		this.isMaster = isMaster;
	}
	
}
