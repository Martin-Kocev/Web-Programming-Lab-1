package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Long> {
//    List<Chef> findAll();
    Optional<Chef> findById(long id);
    Chef findChefsByFirstName(String gordon);
//    Chef save(Chef chef);
}
