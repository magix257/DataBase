package pl.slawek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	@Autowired
	WykrojnikiRepo WykrojnikiRepo;
	
	
	
	
	
	
	
	@RequestMapping("/")
	public String home(ModelMap m) 
	{
		m.put("result", Koloryrepo.findAll());
		m.put("result2", Kliencirepo.findAll(Sort.by("numerKlienta").ascending()));
		m.put("result3", WykrojnikiRepo.findAll());
		return "home.jsp";
	}
	
	
	//OTWIERA STRONE DODAJ KOLOR
	@RequestMapping("addKolory")
	public String addKolory(ModelMap m) 
	{
		
		return "dodajKolor.jsp";
	}
	
	
	//OTWIERA STRONE DODAJ KLIENTA
	@RequestMapping("addKlienci")
	public String addKlienci(@ModelAttribute Klienci z, ModelMap m) 
	{
		
		return "dodajKlienta.jsp";
	}
	
	
	//DODAJE ZLECENIE DO BAZY
	@RequestMapping("addZlecenie")
	public String addZlecenie(@ModelAttribute Zlecenia z, Model m) 
	{
		repo.save(z);
		m.addAttribute("result",repo.findAll());
		
		return "zlecenia.jsp";
	}
	//USUWA ZLECENIE Z BAZY
	@PostMapping("delZlecenia")
	public String delZlecenie(@ModelAttribute Zlecenia z, Model m, @RequestParam("id") String id) 
	{
		
		repo.deleteById(Long.parseLong(id));
		m.addAttribute("result", repo.findAll());
		
		return "zlecenia.jsp";
	}
	
	//USUWA KLIENTA Z BAZY
	@RequestMapping("delKlienci")
	public String delKlienci(@ModelAttribute Klienci kl, Model m, @RequestParam("id") String id) 
	{
		
		Kliencirepo.deleteById(Long.parseLong(id));
		m.addAttribute("result", "USUNIETO KLIENTA");
		
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
	
	
	
	//POBIERA ZLECENIA Z BAZY
	@GetMapping("getZlecenia")
	public String getStudents(@ModelAttribute Zlecenia z, Model m)
	{
		
		m.addAttribute("result", repo.findAll());
	//	m.addAttribute("result2", repo.findDistinctByNazwaKlienta(z.getNazwaKlienta()));
	
		
		return "zlecenia.jsp";
	}
	
	//POBIERA KLIENTÓW Z BAZY
	@GetMapping("getKlienci")
	public String getKlienci(@ModelAttribute Klienci kl, Model m)
	{
		
		m.addAttribute("result", Kliencirepo.findAll(Sort.by("numerKlienta").ascending()));
	//	m.addAttribute("result2", repo.findDistinctByNazwaKlienta(z.getNazwaKlienta()));
	
		
		return "klienci.jsp";
	}
	
	//POBIERA ZLECENIA Z BAZY I SORTUJE PO ID MALEJĄCO
	@GetMapping("getZleceniaIdDesc")
	public String getZleceniaIdDesc(@ModelAttribute Zlecenia z, Model m)
	{
		
		m.addAttribute("result", repo.findAll(Sort.by("id").descending()));
		
		return "zlecenia.jsp";
	}
	
	//POBIERA ZLECENIA Z BAZY I SORTUJE PO NUMERZE ETYKIETY MALEJĄCO
	@GetMapping("getZleceniaNumerEtykietyDesc")
	public String getZleceniaNumerEtykietyDesc(@ModelAttribute Zlecenia z, Model m)
	{
		
		m.addAttribute("result", repo.findAll(Sort.by("numerEtykiety").descending()));
		
		return "zlecenia.jsp";
	}
		
}












