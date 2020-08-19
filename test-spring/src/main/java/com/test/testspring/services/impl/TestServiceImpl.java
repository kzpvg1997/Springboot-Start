package com.test.testspring.services.impl;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.testspring.domain.Test;
import com.test.testspring.repository.TestRepository;
import com.test.testspring.services.TestService;
import com.test.testspring.services.dto.TestDTO;
import com.test.testspring.services.mapper.TestMapper;
import com.test.testspring.web.rest.errors.TestException;

@Service
@Transactional
public class TestServiceImpl implements TestService{

	
    private final Logger log = LoggerFactory.getLogger(TestServiceImpl.class);
	
    private final TestRepository testRepository;
    
    private final TestMapper testMapper;
    
    public TestServiceImpl (TestRepository testRepository, TestMapper testMapper) {
		this.testRepository = testRepository;
		this.testMapper = testMapper;
	}
    
    /**
     * Metodo que obtiene una lista de Test
     */
	@Override
	@Transactional(readOnly = true)
	public List<TestDTO> obtenerTests() {
		log.info("Se empiezan a obtener todos los Test desde la BD");
		return testRepository.findAll().stream()
				.map(testMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Método que crea un Test en la BD
	 */
	@Override
	public TestDTO crearTest(TestDTO testDTO) {
		log.info("Se va a insertar un nuevo Test");
		//validamos que esta cedula ya no este registrada
		if(this.buscarTestPorCedula(testDTO.getCedula()).isPresent()){
			throw new TestException("Este test con cedula:"+testDTO.getCedula()+" ya se encuentra registrado", TestServiceImpl.class.getName(), "500");
		}else{
			Test test = testMapper.toEntity(testDTO);
			test = testRepository.save(test);
			return testMapper.toDto(test);
			
		}
		
	}

	/**
	 * Método que busca un test por cedula
	 */
	@Override
	public Optional<TestDTO> buscarTestPorCedula(String cedula) {
		
		if(cedula == null || cedula.equals("")){
			log.error("*********** por favor ingrese cedula ***********");
		}
		return testRepository.buscarTestPorCedula(cedula).map(testMapper::toDto);
	}

}
