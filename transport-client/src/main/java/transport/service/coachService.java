package transport.service;

import java.util.List;

import transport.data.coach;

public interface coachService {
	Iterable<coach> findAll();

    List<coach> search(long q);

    coach findOne(long id);

    void save(coach emp);

    void delete(coach emp);
}
