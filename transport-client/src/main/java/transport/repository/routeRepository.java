package transport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import transport.data.route;

public interface routeRepository extends JpaRepository<route, Long> {

    List<route> findByStartpointContaining(String q);
    

}
