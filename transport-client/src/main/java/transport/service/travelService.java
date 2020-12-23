package transport.service;

import java.util.List;

import transport.data.travel;

public interface travelService {
	Iterable<travel> findAll();

    List<travel> search(String q);

    travel findOne(long id);

    void save(travel emp);

    void delete(travel emp);

}
