package Transport.controller;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Transport.data.coach;
import Transport.data.driver;
import Transport.repository.driverRepository;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;

@RestController
@RequestMapping(path = "/driver", produces = "application/json")
@CrossOrigin(origins = "*")
public class driverController {
	private driverRepository driverRepo;
	@Autowired
	EntityLinks entityLinks;

	public driverController(driverRepository driverRepo) {
		this.driverRepo = driverRepo;
	}

	@GetMapping("/search")
	public Iterable<driver> recentDriver() {
		return driverRepo.findAll();
	}
	
	@GetMapping("/idx/{id}")
	public driver SearchById(@PathVariable("id") Long id) {
		Optional<driver> driverInfo = driverRepo.findById(id);
		if (driverInfo.isPresent()) {
			return driverInfo.get();
		}
		return null;
	}
	
	@GetMapping("/search/{drivername}")
	public Iterable<driver> SearchByName(@PathVariable("drivername") String drivername) {
		Iterable<driver> a = driverRepo.findAll();
		List<driver> driverSearch = new ArrayList<driver>();
		driverSearch = (List<driver>) a;
		for (int i = 0; i < driverSearch.size(); i++) {
			if (!driverSearch.get(i).getDrivername().contains(drivername)) {
				driverSearch.remove(i);
			}
		}
		return driverSearch;
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public driver postDriver(@RequestBody driver driver) {
		return driverRepo.save(driver);
	}

	@DeleteMapping("/delete/{driverId}")
	public void deleteDriver(@PathVariable("driverId") Long driverId) {
		try {
			driverRepo.deleteById(driverId);
		} catch (EmptyResultDataAccessException e) {
		}
	}

	@PutMapping("/{driverId}")
	public driver putDriver(@RequestBody driver driver) {
		return driverRepo.save(driver);
	}
}