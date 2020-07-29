package com.singletonapps.crm.backend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Company extends AbstractEntity {

    private String name;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<Contact> employees = new LinkedList<>();

    public Company() {
    }

    public Company(String name) {
        setName(name);
    }
}
