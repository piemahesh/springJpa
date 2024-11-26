package com.springLearn.entity;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.*;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
	private String name;
	private Integer model;

	public String getName() {
		return name;
	}

	@Value("honda-activa")
	public void setName(String name) {
		this.name = name;
	}

	public Integer getModel() {
		return model;
	}


	public void setModel(Integer model) {
		this.model = model;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [Id=" + id + ", name=" + name + ", model=" + model + "]";
	}

}
