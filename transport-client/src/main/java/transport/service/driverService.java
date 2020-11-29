package transport.service;

import java.util.List;

import transport.data.driver;

public interface driverService {
	Iterable<driver> findAll();

    List<driver> search(String q);

    driver findOne(long id);

    void save(driver emp);

    void delete(driver emp);
}
