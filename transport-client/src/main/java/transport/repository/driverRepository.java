package transport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import transport.data.driver;

public interface driverRepository extends JpaRepository<driver, Long> {

    List<driver> findByDrivernameContaining(String q);
    

}