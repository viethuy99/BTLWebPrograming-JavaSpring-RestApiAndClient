package Transport.api;

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

import Transport.route;
import Transport.data.routeRepository;

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

	@GetMapping
	public Iterable<route> recentroute() {
		return routeRepo.findAll();
	}

	@GetMapping("/{id}")
	public route SearchById(@PathVariable("id") Long id) {
		Optional<route> routeInfor = routeRepo.findById(id);
		if (routeInfor.isPresent()) {
			return routeInfor.get();
		}
		return null;
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public route postRoute(@RequestBody route route) {
		return routeRepo.save(route);
	}

	@DeleteMapping("/{routeId}")
	public void deleteRoute(@PathVariable("routeId") Long routeId) {
		try {
			routeRepo.deleteById(routeId);
		} catch (EmptyResultDataAccessException e) {
		}
	}

	@PutMapping("/{coachId}")
	public route putRoute(@RequestBody route route) {
		return routeRepo.save(route);
	}
}
