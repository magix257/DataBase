package pl.slawek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	Zleceniarepo repo;
	
	
	
	@RequestMapping("/")
	public String home() 
	{
		return "zlecenia.jsp";
	}
	
	@RequestMapping("addZlecenie")
	public String addZlecenie(@ModelAttribute Zlecenia z, Model m) 
	{
		repo.save(z);
		m.addAttribute("result", repo.findById(z.getId()));
		
		return "result.jsp";
	}
	
	@GetMapping("getZlecenia")
	public String getStudents(@ModelAttribute Zlecenia z, Model m)
	{
		
		m.addAttribute("result", repo.findAll());
		
		return "result.jsp";
	}
		
}
