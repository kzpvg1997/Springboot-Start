package com.test.testspring.services;

import java.util.List;
import java.util.Optional;

import com.test.testspring.services.dto.TestDTO;

public interface TestService {

	/**
	 * Método que obtiene todos los test desde la BD
	 * 
	 * @return lista de Test
	 */
	List<TestDTO> obtenerTests ();
	
	
	/**
	 * Método cre crea un Test en la BD
	 * 
	 * @param testDTO el objeto DTO con el cual se guardara
	 */
	TestDTO crearTest(TestDTO testDTO);
	
	/**
	 * Metodo que busca un Test mediante la cedula
	 * @param cedula el parametro por el que se va a buscar
	 * @return un TestDTO
	 */
	Optional<TestDTO> buscarTestPorCedula(String cedula);
}
