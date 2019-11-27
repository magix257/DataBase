package pl.slawek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Autowired
	ZleceniaRepo repo;
	
	@Autowired
	KoloryRepo Koloryrepo;
	
	@Autowired
	KlienciRepo Kliencirepo;
	
	
	@RequestMapping("/")
	public String home(ModelMap m) 
	{
		m.put("result", Koloryrepo.findAll());
		m.put("result2", Kliencirepo.findAll());
		return "home.jsp";
	}
	
	
	
	@RequestMapping("addKolory")
	public String addKolory(ModelMap m) 
	{
		
		return "dodajKolor.jsp";
	}
	
	@RequestMapping("addKlienci")
	public String addKlienci(@ModelAttribute Klienci z, ModelMap m) 
	{
		
		return "dodajKlienta.jsp";
	}
	
	@RequestMapping("addZlecenie")
	public String addZlecenie(@ModelAttribute Zlecenia z, Model m) 
	{
		repo.save(z);
		m.addAttribute("result",repo.findAll());
		
		return "zlecenia.jsp";
	}
	
	@RequestMapping("delZlecenia")
	public String delZlecenie(@ModelAttribute Zlecenia z, Model m, @RequestParam("id") String id) 
	{
		
		repo.deleteById(Long.parseLong(id));
		m.addAttribute("result", "USUNIETO ZLECENIE");
		
		return "result.jsp";
	}
	
	
	//DODAJ KOLOR DO BAZY
	@RequestMapping("addKolor")
	public String addKolor(@ModelAttribute Kolory k, Model m) 
	{
		String nazwaKoloru =  k.getNazwaKoloru();
		if(Koloryrepo.findByNazwaKoloru(nazwaKoloru) != null) {
			m.addAttribute("result", "Kolor istnieje juz w bazie");	
		}	
		
		else {	
			Koloryrepo.save(k);
			m.addAttribute("result", Koloryrepo.findById(k.getId()));
		}
		
		return "result.jsp";
	}
	
	
	//DODAJ KLIENTA DO BAZY	
	@RequestMapping("addKlient")
	public String addKlient(@ModelAttribute Klienci k, Model m) 
	{
		String nazwaKlienta =  k.getNazwaKlienta();
		if(Kliencirepo.findByNazwaKlienta(nazwaKlienta) != null) {
			m.addAttribute("result", "Klient istnieje juz w bazie");	
		}	
		
		else {	
			Kliencirepo.save(k);
			m.addAttribute("result", Kliencirepo.findById(k.getId()));
		}
		
		return "result.jsp";
	}
	
	@GetMapping("getZlecenia")
	public String getStudents(@ModelAttribute Zlecenia z, Model m)
	{
		
		m.addAttribute("result", repo.findAll());
	//	m.addAttribute("result2", repo.findDistinctByNazwaKlienta(z.getNazwaKlienta()));
	
		
		return "zlecenia.jsp";
	}
	
	@GetMapping("getKlienci")
	public String getKlienci(@ModelAttribute Klienci kl, Model m)
	{
		
		m.addAttribute("result", Kliencirepo.findAll());
	//	m.addAttribute("result2", repo.findDistinctByNazwaKlienta(z.getNazwaKlienta()));
	
		
		return "result.jsp";
	}
	
	@GetMapping("getZleceniaIdDesc")
	public String getZleceniaIdDesc(@ModelAttribute Zlecenia z, Model m)
	{
		
		m.addAttribute("result", repo.findAll(Sort.by("id").descending()));
		
		return "zlecenia.jsp";
	}
	
	@GetMapping("getZleceniaNumerEtykietyDesc")
	public String getZleceniaNumerEtykietyDesc(@ModelAttribute Zlecenia z, Model m)
	{
		
		m.addAttribute("result", repo.findAll(Sort.by("numerEtykiety").descending()));
		
		return "zlecenia.jsp";
	}
		
}












