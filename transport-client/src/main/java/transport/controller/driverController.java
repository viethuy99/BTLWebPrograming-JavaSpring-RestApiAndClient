package transport.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import transport.data.driver;
import transport.service.driverService;

@Controller
@RequestMapping("/driver")
public class driverController {
	@Autowired
	private driverService driverService;
	private RestTemplate rest = new RestTemplate();


	@GetMapping()
	public String index(Model model) {
//		model.addAttribute("drivers", driverService.findAll());
		List<driver> drivers =
				Arrays.asList(rest.getForObject("http://localhost:8081/driver/search",driver[].class));
		model.addAttribute("drivers", drivers);
		return "listDriver";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("driver", new driver());
		return "formDriver";
	}

	@GetMapping("/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("driver", driverService.findOne(id));
		return "formDriver";
	}

	@PostMapping("/save")
	public String save(@Valid driver emp, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "formDriver";
		}
//		driverService.save(emp);
		rest.postForObject("http://localhost:8081/driver", emp, driver.class);
		redirect.addFlashAttribute("success", "Saved successfully!");
		return "redirect:/driver";
	}

	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		driver emp = driverService.findOne(id); 
//		driverService.delete(emp);
		rest.delete("http://localhost:8081/driver/delete/{id}", emp.getId());
		redirect.addFlashAttribute("success", "Deleted successfully!");
		return "redirect:/driver";
	}

	@GetMapping("/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/driver";
		}

		model.addAttribute("drivers", driverService.search(s));
		return "listDriver";
	}
}