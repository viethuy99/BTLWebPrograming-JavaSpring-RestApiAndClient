package transport.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transport.data.route;
import transport.repository.routeRepository;

@Service
public class routeServiceImpl implements routeService {
	@Autowired
    private routeRepository routeRepository;

    @Override
    public Iterable<route> findAll() {
        return routeRepository.findAll();
    }

    @Override
    public List<route> search(String q) {
        return routeRepository.findByStartpointContaining(q);
    }

    @Override
    public route findOne(long id) {
        return routeRepository.getOne(id);
    }

    @Override
    public void save(route emp) {
    	routeRepository.save(emp);
    }

    @Override
    public void delete(route emp) {
    	routeRepository.delete(emp);
    }
}
