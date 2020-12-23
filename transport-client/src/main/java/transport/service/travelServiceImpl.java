package transport.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transport.data.travel;
import transport.repository.travelRepository;

@Service
public class travelServiceImpl implements travelService {
	@Autowired
    private travelRepository travelRepository;

    @Override
    public Iterable<travel> findAll() {
        return travelRepository.findAll();
    }

    @Override
    public List<travel> search(String q) {
        return travelRepository.findByDrivernameContaining(q);
    }

    @Override
    public travel findOne(long id) {
        return travelRepository.getOne(id);
    }

    @Override
    public void save(travel emp) {
    	travelRepository.save(emp);
    }

    @Override
    public void delete(travel emp) {
    	travelRepository.delete(emp);
    }
}
