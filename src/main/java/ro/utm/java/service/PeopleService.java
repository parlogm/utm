package ro.utm.java.service;

import ro.utm.java.entities.People;

import java.util.List;

public interface PeopleService {
    List<People> getAllPeople();
    void savePerson(People person);
    People findPersonByCNP(String cnp);
    void updatePerson(People person);
    void removePerson(People person);
    List<People> findByEmail(String email);
    People findByEmailUnique(String email);
}
