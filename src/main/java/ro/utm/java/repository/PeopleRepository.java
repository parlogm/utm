package ro.utm.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.utm.java.entities.People;

import java.util.List;

@Repository("peopleRepository")
public interface PeopleRepository extends JpaRepository<People, Long> {

    People findByCnp(String cnp);
    List<People> findByEmailContains(String email);
    People findByEmail(String email);

}
