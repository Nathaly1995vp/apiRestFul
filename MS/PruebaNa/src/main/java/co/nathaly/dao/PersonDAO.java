/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.nathaly.dao;

import co.nathaly.modelo.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nathaly
 */
public interface PersonDAO extends JpaRepository<Person, Integer> {

    public Person findByidentificationNumber(String identificationNumber);
}
