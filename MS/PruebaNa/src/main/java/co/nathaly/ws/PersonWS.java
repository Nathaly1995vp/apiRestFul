package co.nathaly.ws;

import co.nathaly.dto.PersonDTO;
import co.nathaly.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nathaly
 */
@Controller
@CrossOrigin
@RequestMapping(path = "/Person")
public class PersonWS {

    @Autowired
    PersonService personService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity getAll() {
        try {
            return new ResponseEntity(personService.consultarTodos(), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity add(@RequestBody PersonDTO newPerson) {
        try {
            return new ResponseEntity(personService.addPerson(newPerson), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
