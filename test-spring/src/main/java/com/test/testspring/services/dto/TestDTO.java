package com.test.testspring.services.dto;

import java.io.Serializable;

public class TestDTO implements Serializable{

	private Long id;

    private String nombre;
    
    private String apellido;
    
    private String cedula;
    
    public TestDTO(){
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
    
    
}
