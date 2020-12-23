package transport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import transport.data.travel;

public interface travelRepository extends JpaRepository<travel, Long> {

    List<travel> findByDrivernameContaining(String q);
    

}