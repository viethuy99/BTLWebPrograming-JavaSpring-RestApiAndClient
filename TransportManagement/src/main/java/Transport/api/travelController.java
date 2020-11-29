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

import Transport.travel;
import Transport.data.travelRepository;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(path = "/travel", produces = "application/json")
@CrossOrigin(origins = "*")
public class travelController {
	private travelRepository travelRepo;
	@Autowired
	EntityLinks entityLinks;

	public travelController(travelRepository travelRepo) {
		this.travelRepo = travelRepo;
	}

	@GetMapping("/search")
	public Iterable<travel> recentroute() {
		return travelRepo.findAll();
	}

	@GetMapping("/search/{id}")
	public travel SearchById(@PathVariable("id") Long id) {
		Optional<travel> travelInfor = travelRepo.findById(id);
		if (travelInfor.isPresent()) {
			return travelInfor.get();
		}
		return null;
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public travel postTravel(@RequestBody travel travel) {
		return travelRepo.save(travel);
	}

	@DeleteMapping("/delete/{routeId}")
	public void deleteTravel(@PathVariable("travelId") Long routeId) {
		try {
			travelRepo.deleteById(routeId);
		} catch (EmptyResultDataAccessException e) {
		}
	}

	@PutMapping("/{travelId}")
	public travel putTravel(@RequestBody travel travel) {
		return travelRepo.save(travel);
	}
}
