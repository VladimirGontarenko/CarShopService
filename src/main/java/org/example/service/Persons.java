package org.example.service;

import org.example.dto.PersonDto;

import java.util.List;

public interface Persons {
    public PersonDto addNewPerson();
    public List<PersonDto> findAll();
    public PersonDto updateCar(PersonDto personDto);
    public boolean deletePerson (PersonDto personDto);
    public List<PersonDto> filterPerson (String filter);
}
