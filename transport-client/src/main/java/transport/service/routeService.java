package transport.service;

import java.util.List;

import transport.data.route;

public interface routeService {
	Iterable<route> findAll();

    List<route> search(String q);

    route findOne(long id);

    void save(route emp);

    void delete(route emp);
}
