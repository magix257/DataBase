package pl.slawek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	ZleceniaRepo repo;
	
	@Autowired
	KoloryRepo Krepo;
	
	
	@RequestMapping("/")
	public String home(ModelMap m) 
	{
		m.put("result", Krepo.findAll());
		return "zlecenia.jsp";
	}
	
	@RequestMapping("addKolory")
	public String addKolory() 
	{
		return "dodajKolor.jsp";
	}
	
	@RequestMapping("addZlecenie")
	public String addZlecenie(@ModelAttribute Zlecenia z, Model m) 
	{
		repo.save(z);
		m.addAttribute("result", repo.findById(z.getId()));
		
		return "result.jsp";
	}
	
	@RequestMapping("addKolor")
	public String addKolor(@ModelAttribute Kolory k, Model m) 
	{
		Krepo.save(k);
		m.addAttribute("result", Krepo.findById(k.getId()));
		
		return "result.jsp";
	}
	
	
	@GetMapping("getZlecenia")
	public String getStudents(@ModelAttribute Zlecenia z, Model m)
	{
		
		m.addAttribute("result", repo.findAll());
		
		return "result.jsp";
	}
		
}
