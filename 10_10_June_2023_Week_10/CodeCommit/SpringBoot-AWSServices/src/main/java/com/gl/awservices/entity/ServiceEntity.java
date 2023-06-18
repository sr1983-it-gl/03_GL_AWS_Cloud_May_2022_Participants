package com.gl.awservices.entity;

public class ServiceEntity {

	private Long id;
	
	private String name;
	
	private String associatedKeywords;

	public ServiceEntity() {}
	
	public ServiceEntity(Long id, String name, String associatedKeywords) {
		
		this.id = id;
		this.name = name;
		this.associatedKeywords = associatedKeywords;
	}
	
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

	public String getAssociatedKeywords() {
		return associatedKeywords;
	}

	public void setAssociatedKeywords(String associatedKeywords) {
		this.associatedKeywords = associatedKeywords;
	}
}
