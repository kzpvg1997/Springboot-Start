package com.test.testspring.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import com.test.testspring.services.TestService;
import com.test.testspring.services.dto.TestDTO;
import com.test.testspring.web.rest.errors.BadRequestAlertException;

@RestController
@RequestMapping("/api")
public class TestResource {

	
	private final Logger log = LoggerFactory.getLogger(TestResource.class);

   // private static final String ENTITY_NAME = "TestAplication";
    
    private final String TEST_STATIC = "/test";
    
    private final TestService testService;
    
    public TestResource(TestService testService) {
		this.testService = testService;
	}
    
    
    @PostMapping(TEST_STATIC+"/crear-test")
    public ResponseEntity<TestDTO> createBanco(@Valid @RequestBody TestDTO testDTO) throws URISyntaxException {
        log.info("REST request to save Test : {}", testDTO);
        if (testDTO.getId() != null) {
            throw new BadRequestAlertException("A new Test cannot already have an ID", TestResource.class.getName(), "idexists");
        }
        TestDTO result = testService.crearTest(testDTO);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }
    
    @GetMapping(TEST_STATIC+"/obtener-test/{cedula}")
    public ResponseEntity<TestDTO> getTest(@PathVariable String cedula) {
        log.info("REST request to get Test : {}", cedula);
        Optional<TestDTO> test = testService.buscarTestPorCedula(cedula);
        return new ResponseEntity<>(test.get(),HttpStatus.OK);
    }
    
    /**
     * {@code GET  /tests} : obtiene todos los tests.
     *
     * @return La {@link ResponseEntity} con estado {@code 200 (OK)} y la lista de los tests.
     */
    @GetMapping(TEST_STATIC+"/obtener-todos")
    public List<TestDTO> getAllTests() {
        log.info("REST request to get all Bancos");
        return testService.obtenerTests();
    }
    
    
}
