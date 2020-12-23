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

import transport.data.travel;
import transport.service.travelService;

@Controller
@RequestMapping("/travel")
public class travelController {
	@Autowired
	private travelService travelService;
	private RestTemplate rest = new RestTemplate();


	@GetMapping()
	public String index(Model model) {
//		model.addAttribute("travels", travelService.findAll());
		List<travel> travels =
				Arrays.asList(rest.getForObject("http://localhost:8081/travel/search",travel[].class));
		model.addAttribute("travels", travels);
		return "listTravel";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("travel", new travel());
		return "formTravel";
	}

	@GetMapping("/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("travel", travelService.findOne(id));
		return "formTravel";
	}

	@PostMapping("/save")
	public String save(@Valid travel emp, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "formTravel";
		}
//		travelService.save(emp);
		rest.postForObject("http://localhost:8081/travel", emp, travel.class);
		redirect.addFlashAttribute("success", "Saved successfully!");
		return "redirect:/travel";
	}

	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		travel emp = travelService.findOne(id); 
//		travelService.delete(emp);
		rest.delete("http://localhost:8081/travel/delete/{id}", emp.getId());
		redirect.addFlashAttribute("success", "Deleted successfully!");
		return "redirect:/travel";
	}

	@GetMapping("/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/travel";
		}

		model.addAttribute("travels", travelService.search(s));
		return "listTravel";
	}
}