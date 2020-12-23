package transport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import transport.data.coach;

public interface coachRepository extends JpaRepository<coach, Long> {

    List<coach> findByIdContaining(long id);
    

}