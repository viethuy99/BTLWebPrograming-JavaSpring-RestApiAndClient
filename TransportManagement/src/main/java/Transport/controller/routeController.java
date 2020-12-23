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

import Transport.data.driver;
import Transport.data.route;
import Transport.repository.routeRepository;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(path = "/route", produces = "application/json")
@CrossOrigin(origins = "*")
public class routeController {
	private routeRepository routeRepo;
	@Autowired
	EntityLinks entityLinks;

	public routeController(routeRepository routeRepo) {
		this.routeRepo = routeRepo;
	}

	@GetMapping("/search")
	public Iterable<route> recentroute() {
		return routeRepo.findAll();
	}

	@GetMapping("/idx/{id}")
	public route SearchById(@PathVariable("id") Long id) {
		Optional<route> routeInfo = routeRepo.findById(id);
		if (routeInfo.isPresent()) {
			return routeInfo.get();
		}
		return null;
	}
	
	@GetMapping("/search/{startpoint}")
	public Iterable<route> SearchByName(@PathVariable("startpoint") String startpoint) {
		Iterable<route> a = routeRepo.findAll();
		List<route> routeSearch = new ArrayList<route>();
		routeSearch = (List<route>) a;
		for (int i = 0; i < routeSearch.size(); i++) {
			if (!routeSearch.get(i).getStartpoint().contains(startpoint)) {
				routeSearch.remove(i);
			}
		}
		return routeSearch;
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public route postRoute(@RequestBody route route) {
		return routeRepo.save(route);
	}

	@DeleteMapping("/delete/{routeId}")
	public void deleteRoute(@PathVariable("routeId") Long routeId) {
		try {
			routeRepo.deleteById(routeId);
		} catch (EmptyResultDataAccessException e) {
		}
	}

	@PutMapping("/{routeId}")
	public route putRoute(@RequestBody route route) {
		return routeRepo.save(route);
	}
}
