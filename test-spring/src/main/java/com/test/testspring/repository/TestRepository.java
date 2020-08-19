package com.test.testspring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.testspring.domain.Test;


@SuppressWarnings("unused")
@Repository
public interface TestRepository extends JpaRepository<Test, Long>{

	
	@Query("SELECT t FROM Test t WHERE t.cedula = :cedula")
	Optional<Test> buscarTestPorCedula(@Param("cedula") String cedula);
}
