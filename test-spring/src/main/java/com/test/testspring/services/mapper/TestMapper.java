package com.test.testspring.services.mapper;

import org.mapstruct.*;

import com.test.testspring.domain.Test;
import com.test.testspring.services.dto.TestDTO;

@Mapper(componentModel = "spring", uses = {})
public interface TestMapper extends EntityMapper<TestDTO, Test>{

	
	Test toEntity(TestDTO continenteDTO);

    default Test fromId(Long id) {
        if (id == null) {
            return null;
        }
        Test test = new Test();
        test.setId(id);
        return test;
    }
}
