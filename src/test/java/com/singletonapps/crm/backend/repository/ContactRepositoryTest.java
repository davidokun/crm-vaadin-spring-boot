package com.singletonapps.crm.backend.repository;

import com.singletonapps.crm.backend.domain.Contact;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    void shouldFindContactById() {
        //given
        final Contact contact = new Contact();
        contact.setFirstName("Jon");
        contact.setLastName("Snow");
        contact.setEmail("some@email.com");
        contact.setStatus(Contact.Status.Customer);

        //when
        final Contact saved = contactRepository.save(contact);

        //then
        final Optional<Contact> byId = contactRepository.findById(saved.getId());

        assertEquals("Jon", byId.get().getFirstName());
    }
}