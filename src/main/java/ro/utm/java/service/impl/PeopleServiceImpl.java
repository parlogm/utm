package ro.utm.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utm.java.entities.People;
import ro.utm.java.repository.PeopleRepository;
import ro.utm.java.service.PeopleService;

import java.util.List;

@Service("peopleService")
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public List<People> getAllPeople() {
        return peopleRepository.findAll();
    }

    @Override
    public void savePerson(People person) {
        peopleRepository.save(person);
    }

    @Override
    public People findPersonByCNP(String cnp) {
        return peopleRepository.findByCnp(cnp);
    }

    @Override
    public void updatePerson(People person) {
        peopleRepository.save(person);
    }

    @Override
    public void removePerson(People person) {
        peopleRepository.delete(person);
    }

    @Override
    public List<People> findByEmail(String email) {
        return peopleRepository.findByEmailContains(email);
    }

    @Override
    public People findByEmailUnique(String email) {
        return peopleRepository.findByEmail(email);
    }
}
