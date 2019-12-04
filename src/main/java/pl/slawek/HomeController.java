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
	ZleceniaRepo ZleceniaRepo;
	
	@Autowired
	KoloryRepo KoloryRepo;
	
	@Autowired
	KlienciRepo KlienciRepo;
		
	@Autowired
	WykrojnikiRepo WykrojnikiRepo;
	
	@Autowired
	SurowceRepo SurowceRepo;
	
	
	
	
	
	@RequestMapping("/")
	public String home(ModelMap m) 
	{
		m.put("result", KoloryRepo.findAll());
		m.put("result2", KlienciRepo.findAll(Sort.by("numerKlienta").ascending()));
		m.put("result3", WykrojnikiRepo.findAll());
		m.put("result4", SurowceRepo.findAll());
		
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
	public String addKlienci(@ModelAttribute Klienci kl, ModelMap m) 
	{
		
		return "dodajKlienta.jsp";
	}
	
	//OTWIERA STRONE DODAJ SUROWIEC
	@RequestMapping("addSurowce")
	public String addSurowce(@ModelAttribute Surowce s, ModelMap m) 
	{
		
		return "dodajSurowiec.jsp";
	}
	
	
	//DODAJE ZLECENIE DO BAZY
	@RequestMapping("addZlecenie")
	public String addZlecenie(@ModelAttribute Zlecenia z, Model m) 
	{
		ZleceniaRepo.save(z);
		m.addAttribute("result",ZleceniaRepo.findAll());
		
		return "zlecenia.jsp";
	}
	//USUWA ZLECENIE Z BAZY
	@PostMapping("delZlecenia")
	public String delZlecenie(@ModelAttribute Zlecenia z, Model m, @RequestParam("id") String id) 
	{
		
		ZleceniaRepo.deleteById(Long.parseLong(id));
		m.addAttribute("result", ZleceniaRepo.findAll());
		
		return "zlecenia.jsp";
	}
	
	
	//USUWA KOLOR Z BAZY
		@GetMapping("delKolory")
		public String delKolory(@ModelAttribute Kolory k, Model m, @RequestParam("id") String id) 
		{
			
			KoloryRepo.deleteById(Long.parseLong(id));
			m.addAttribute("result", KoloryRepo.findAll());
			
			return "kolory.jsp";
		}
	
	
	
	//USUWA KLIENTA Z BAZY
	@RequestMapping("delKlienci")
	public String delKlienci(@ModelAttribute Klienci kl, Model m, @RequestParam("id") String id) 
	{
		
		KlienciRepo.deleteById(Long.parseLong(id));
		m.addAttribute("result", "USUNIETO KLIENTA");
		
		return "result.jsp";
	}
	
	//USUWA SUROWIEC Z BAZY
		@RequestMapping("delSurowce")
		public String delSurowce(@ModelAttribute Surowce s, Model m, @RequestParam("id") String id) 
		{
			
			SurowceRepo.deleteById(Long.parseLong(id));
			m.addAttribute("result", "USUNIETO SUROWIEC");
			
			return "result.jsp";
		}
	
	
	//DODAJ KOLOR DO BAZY
	@RequestMapping("addKolor")
	public String addKolor(@ModelAttribute Kolory k, Model m) 
	{
		String nazwaKoloru =  k.getNazwaKoloru();
		if(KoloryRepo.findByNazwaKoloruIgnoreCase(nazwaKoloru) != null) {
			m.addAttribute("result", "Kolor istnieje juz w bazie");	
		}	
		
		else {	
			KoloryRepo.save(k);
			m.addAttribute("result", KoloryRepo.findById(k.getId()));
		}
		
		return "result.jsp";
	}
	
	
	//DODAJ KLIENTA DO BAZY	
	@RequestMapping("addKlient")
	public String addKlient(@ModelAttribute Klienci kl, Model m) 
	{
		String nazwaKlienta =  kl.getNazwaKlienta();
		int numerKlienta =  kl.getNumerKlienta();
		
		if(KlienciRepo.findByNazwaKlientaIgnoreCase(nazwaKlienta) != null) {
			m.addAttribute("result", "Klient o podanej nazwie istnieje juz w bazie");	
		}	
		
		else if(KlienciRepo.findByNumerKlienta(numerKlienta) !=null){
			m.addAttribute("result", "Numer Klienta istnieje juz w bazie");	
		}	
		
		else {	
			KlienciRepo.save(kl);
			m.addAttribute("result", KlienciRepo.findById(kl.getId()));
		}
		
		return "result.jsp";
	}
	
	//DODAJ SUROWIEC DO BAZY	
		@RequestMapping("addSurowiec")
		public String addSurowiec(@ModelAttribute Surowce s, Model m) 
		{
			String nazwaSurowca =  s.getNazwaSurowca();
			if(SurowceRepo.findByNazwaSurowcaIgnoreCase(nazwaSurowca) != null) {
				m.addAttribute("result", "Surowiec istnieje juz w bazie");	
			}	
			
			else {	
				SurowceRepo.save(s);
				m.addAttribute("result", SurowceRepo.findById(s.getId()));
			}
			
			return "result.jsp";
		}
	
	
	
	//POBIERA ZLECENIA Z BAZY
	@GetMapping("getZlecenia")
	public String getStudents(@ModelAttribute Zlecenia z, Model m)
	{
		
		m.addAttribute("result", ZleceniaRepo.findAll());
	//	m.addAttribute("result2", repo.findDistinctByNazwaKlienta(z.getNazwaKlienta()));
	
		
		return "zlecenia.jsp";
	}
	
	//POBIERA KLIENTÓW Z BAZY
	@GetMapping("getKlienci")
	public String getKlienci(@ModelAttribute Klienci kl, Model m)
	{
		
		m.addAttribute("result", KlienciRepo.findAll(Sort.by("numerKlienta").ascending()));
	//	m.addAttribute("result2", repo.findDistinctByNazwaKlienta(z.getNazwaKlienta()));
	
		
		return "klienci.jsp";
	}
	
	//POBIERA SUROWCE Z BAZY
		@GetMapping("getSurowce")
		public String getSurowce(@ModelAttribute Surowce s, Model m)
		{
			
			m.addAttribute("result", SurowceRepo.findAll());
		
			
			return "surowce.jsp";
		}
		
	//POBIERA KOLORY Z BAZY
				@GetMapping("getKolory")
				public String getKolory(@ModelAttribute Surowce s, Model m)
				{
					
					m.addAttribute("result", KoloryRepo.findAll());
				
					
					return "kolory.jsp";
				}
	
	
	
	//POBIERA ZLECENIA Z BAZY I SORTUJE PO ID MALEJĄCO
	@GetMapping("getZleceniaIdDesc")
	public String getZleceniaIdDesc(@ModelAttribute Zlecenia z, Model m)
	{
		
		m.addAttribute("result", ZleceniaRepo.findAll(Sort.by("id").descending()));
		
		return "zlecenia.jsp";
	}
	
	//POBIERA ZLECENIA Z BAZY I SORTUJE PO NUMERZE ETYKIETY MALEJĄCO
	@GetMapping("getZleceniaNumerEtykietyDesc")
	public String getZleceniaNumerEtykietyDesc(@ModelAttribute Zlecenia z, Model m)
	{
		
		m.addAttribute("result", ZleceniaRepo.findAll(Sort.by("numerEtykiety").descending()));
		
		return "zlecenia.jsp";
	}
		
}












