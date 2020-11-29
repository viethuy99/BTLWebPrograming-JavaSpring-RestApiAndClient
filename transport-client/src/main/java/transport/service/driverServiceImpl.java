package transport.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transport.data.driver;
import transport.repository.driverRepository;

@Service
public class driverServiceImpl implements driverService {
	@Autowired
    private driverRepository driverRepository;

    @Override
    public Iterable<driver> findAll() {
        return driverRepository.findAll();
    }

    @Override
    public List<driver> search(String q) {
        return driverRepository.findByDrivernameContaining(q);
    }

    @Override
    public driver findOne(long id) {
        return driverRepository.getOne(id);
    }

    @Override
    public void save(driver emp) {
    	driverRepository.save(emp);
    }

    @Override
    public void delete(driver emp) {
    	driverRepository.delete(emp);
    }
}
