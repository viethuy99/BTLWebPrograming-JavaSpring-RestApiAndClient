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

import transport.data.route;
import transport.service.routeService;

@Controller
@RequestMapping("/route")
public class routeController {
	@Autowired
	private routeService routeService;
	private RestTemplate rest = new RestTemplate();


	@GetMapping()
	public String index(Model model) {
//		model.addAttribute("routes", routeService.findAll());
		List<route> routes =
				Arrays.asList(rest.getForObject("http://localhost:8081/route/search",route[].class));
		model.addAttribute("routes", routes);
		return "listRoute";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("route", new route());
		return "formRoute";
	}

	@GetMapping("/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("route", routeService.findOne(id));
		return "formRoute";
	}

	@PostMapping("/save")
	public String save(@Valid route emp, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "formRoute";
		}
//		routeService.save(emp);
		rest.postForObject("http://localhost:8081/route", emp, route.class);
		redirect.addFlashAttribute("success", "Saved successfully!");
		return "redirect:/route";
	}

	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		route emp = routeService.findOne(id); 
//		routeService.delete(emp);
		rest.delete("http://localhost:8081/route/delete/{id}", emp.getId());
		redirect.addFlashAttribute("success", "Deleted successfully!");
		return "redirect:/route";
	}

	@GetMapping("/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/route";
		}

		model.addAttribute("routes", routeService.search(s));
		return "listRoute";
	}
}