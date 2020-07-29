package com.singletonapps.crm.backend.repository;

import com.singletonapps.crm.backend.domain.Company;
import com.singletonapps.crm.backend.domain.Contact;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@RunWith(SpringRunner.class)
class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    void shouldFindByCompanyId() {
        //given
        final String companyName = "Apple";
        final Company company = new Company();
        company.setName(companyName);
        company.setEmployees(List.of(new Contact()));

        //when
        final Company saved = companyRepository.save(company);
        final Long id = saved.getId();
        //then
        final Optional<Company> byId = companyRepository.findById(id);

        assertEquals(companyName, byId.get().getName());
        assertNotNull(byId.get().getId());
    }
}