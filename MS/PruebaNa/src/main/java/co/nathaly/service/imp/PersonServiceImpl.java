/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.nathaly.service.imp;

import co.nathaly.dao.PersonDAO;
import co.nathaly.dto.PersonDTO;
import co.nathaly.modelo.Person;
import co.nathaly.service.PersonService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDAO personDAO;

    @Override
    public List<PersonDTO> consultarTodos() {
        List<Person> listadoEntity = personDAO.findAll();
        List<PersonDTO> personDTOList = new ArrayList<>();
        listadoEntity.forEach((person) -> {
            personDTOList.add(new PersonDTO(person));
        });
        return personDTOList;
    }

    @Override
    public PersonDTO addPerson(PersonDTO person) {
        Person personEntity = null;
        if (personDAO.findByidentificationNumber(person.getIdentificationNumber()) == null) {
            personEntity = personDAO.save(person.getPerson());
        }
        return personEntity == null ? null : new PersonDTO(personEntity);
    }

}
