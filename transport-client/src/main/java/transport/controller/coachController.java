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

import transport.data.coach;
import transport.data.driver;
import transport.service.coachService;

@Controller
@RequestMapping("/coach")
public class coachController {
	@Autowired
	private coachService coachService;
	private RestTemplate rest = new RestTemplate();

	@GetMapping()
	public String index(Model model) {
		List<coach> coachs = Arrays.asList(rest.getForObject("http://localhost:8081/coach/search",coach[].class));
		model.addAttribute("coachs", coachs);
		return "listCoach";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("coach", new coach());
		return "formCoach";
	}

	@GetMapping("/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("coach", coachService.findOne(id));
		System.out.println(coachService.findOne(id).getId());
//		coach emp = rest.getForObject("http://localhost:8081/coach/idx/" + id,coach.class);
//		model.addAttribute("coach", emp);
		return "formCoach";
	}

	@PostMapping("/save")
	public String save(@Valid coach emp, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			System.out.println(emp.getId());
			System.out.println("loi");
			System.out.println(result.getFieldError());
			return "formCoach";
		}
		System.out.println(emp.getId());
		coachService.save(emp);
//		rest.postForObject("http://localhost:8081/coach", emp, coach.class);
		redirect.addFlashAttribute("success", "Saved successfully!");
		return "redirect:/coach";
	}

	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable long id, RedirectAttributes redirect) {
		coach emp = coachService.findOne(id); 
//		driverService.delete(emp);
		rest.delete("http://localhost:8081/coach/delete/{id}", emp.getId());
		redirect.addFlashAttribute("success", "Deleted successfully!");
		return "redirect:/coach";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/coach";
		}
		List<coach> coachs =
				Arrays.asList(rest.getForObject("http://localhost:8081/coach/search/" + s,coach[].class));
		model.addAttribute("coachs", coachs);
		return "listCoach";
	}
}