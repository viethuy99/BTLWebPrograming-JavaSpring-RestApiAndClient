package Transport.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
import org.springframework.hateoas.server.EntityLinks;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Transport.data.coach;
import Transport.data.driver;
import Transport.repository.coachRepository;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(path = "/coach", produces = "application/json")
@CrossOrigin(origins = "*")
public class coachController {
	private coachRepository coachRepo;
	@Autowired
	EntityLinks entityLinks;

	public coachController(coachRepository coachRepo) {
		this.coachRepo = coachRepo;
	}

	@GetMapping("/search")
	public Iterable<coach> recentCouch() {
		return coachRepo.findAll();
	}

	@GetMapping("/idx/{id}")
	public coach SearchById(@PathVariable("id") Long id) {
		Optional<coach> coachInfor = coachRepo.findById(id);
		if (coachInfor.isPresent()) {
			return coachInfor.get();
		}
		return null;
	}
	
	@GetMapping("/search/{productor}")
	public Iterable<coach> SearchByName(@PathVariable("productor") String productor) {
		Iterable<coach> a = coachRepo.findAll();
		List<coach> coachSearch = new ArrayList<coach>();
		coachSearch = (List<coach>) a;
		for (int i = 0; i < coachSearch.size(); i++) {
			if (!coachSearch.get(i).getProductor().contains(productor)) {
				coachSearch.remove(i);
			}
		}
		return coachSearch;
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public coach postCoach(@RequestBody coach coach) {
		return coachRepo.save(coach);
	}

	@DeleteMapping("/delete/{coachId}")
	public void deleteCoach(@PathVariable("coachId") Long coachId) {
		try {
			coachRepo.deleteById(coachId);
		} catch (EmptyResultDataAccessException e) {
		}
	}

	@PutMapping("/{coachId}")
	public coach putCoach(@RequestBody coach coach) {
		return coachRepo.save(coach);
	}
}