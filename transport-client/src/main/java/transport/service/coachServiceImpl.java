package transport.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transport.data.coach;
import transport.repository.coachRepository;

@Service
public class coachServiceImpl implements coachService {
	@Autowired
    private coachRepository coachRepository;

    @Override
    public Iterable<coach> findAll() {
        return coachRepository.findAll();
    }

    public List<coach> search (long q) {
        return coachRepository.findByIdContaining(q);
    }

    @Override
    public coach findOne(long id) {
        return coachRepository.getOne(id);
    }

    @Override
    public void save(coach emp) {
    	coachRepository.save(emp);
    }

    @Override
    public void delete(coach emp) {
    	coachRepository.delete(emp);
    }


}
