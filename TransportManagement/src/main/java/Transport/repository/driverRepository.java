package Transport.repository;

import org.springframework.data.repository.CrudRepository;

import Transport.data.driver;

import org.springframework.data.jpa.repository.JpaRepository;

public interface driverRepository extends JpaRepository<driver, Long> {

}
