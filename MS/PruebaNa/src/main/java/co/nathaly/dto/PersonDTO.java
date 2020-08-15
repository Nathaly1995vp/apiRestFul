/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.nathaly.dto;

import co.nathaly.modelo.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

/**
 *
 * @author Nathaly
 */
public class PersonDTO {

    private Integer id;

    private String identificationNumber;

    private String fullName;

    private Date birth;

    private PersonDTO idMother;

    private PersonDTO idFather;

    public PersonDTO() {
    }

    public PersonDTO(Person person) {
        if (person != null) {
            this.id = person.getId();
            this.identificationNumber = person.getIdentificationNumber();
            this.fullName = person.getFullName();
            this.birth = person.getBirth();
            this.idMother = person.getIdMother() != null ? new PersonDTO(person.getIdMother()) : null;
            this.idFather = person.getIdFather() != null ? new PersonDTO(person.getIdFather()) : null;
        }
    }

    @JsonIgnore
    public Person getPerson() {
        Person person = new Person();
        person.setId(this.id);
        person.setIdentificationNumber(this.identificationNumber);
        person.setFullName(this.fullName);
        person.setBirth(this.birth);
        if (this.idFather != null) {
            person.setIdFather(this.idFather.getPerson());
        }
        if (this.idMother != null) {
            person.setIdMother(this.idMother.getPerson());
        }
        return person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public PersonDTO getIdMother() {
        return idMother;
    }

    public void setIdMother(PersonDTO idMother) {
        this.idMother = idMother;
    }

    public PersonDTO getIdFather() {
        return idFather;
    }

    public void setIdFather(PersonDTO idFather) {
        this.idFather = idFather;
    }

    
}
