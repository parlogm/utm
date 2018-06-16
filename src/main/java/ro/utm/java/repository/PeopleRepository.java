package ro.utm.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.utm.java.entities.People;

@Repository("peopleRepository")
public interface PeopleRepository extends JpaRepository<People, Long> {

    People findByCnp(String cnp);

}
