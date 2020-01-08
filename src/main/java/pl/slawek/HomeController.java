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
		m.addAttribute("result", KoloryRepo.findAll());
		return "dodajKolor.jsp";
	}
	
	
	//OTWIERA STRONE DODAJ KLIENTA
	@RequestMapping("addKlienci")
	public String addKlienci(@ModelAttribute Klienci kl, ModelMap m) 
	{
		m.addAttribute("result", KlienciRepo.findAll(Sort.by("numerKlienta").ascending()));
		return "dodajKlienta.jsp";
	}
	
	//OTWIERA STRONE DODAJ SUROWIEC
	@RequestMapping("addSurowce")
	public String addSurowce(@ModelAttribute Surowce s, ModelMap m) 
	{
		m.addAttribute("result", SurowceRepo.findAll());
		return "dodajSurowiec.jsp";
	}
	
	
	//DODAJE ZLECENIE DO BAZY
	@RequestMapping("addZlecenie")
	public String addZlecenie(@ModelAttribute Zlecenia z, Model m) 
	{

		 int idWykrojnika =  z.getIdWykrojnika();
//		 int priorytet = z.getPriorytet();
	 int iloscEtykiet = z.getIloscEtykiet();
//		 int gilza = z.getGilza();
//		 int numerKlienta = z.getNumerKlienta();
//		 String numerEtykiety = z.getNumerEtykiety();
//		 String nazwaKlienta = z.getNazwaKlienta();
//		 String nazwaEtykiety = z.getNazwaEtykiety();
//		 String maszyna = z.getMaszyna();
//		 String rodzajSurowca = z.getRodzajSurowca();
//		 String wystawil = z.getWystawil();
//		 String kolor1 = z.getKolor1();
//		 String kolor2 = z.getKolor2();
//		 String kolor3 = z.getKolor3();
//		 String kolor4 = z.getKolor4();
//		 String kolor5 = z.getKolor5();
//		 String kolor6 = z.getKolor6();
//		 String kolor7 = z.getKolor7();
//		 String kolor8 = z.getKolor8();
//		 Date dataWysylki = z.getDataWysylki();

		if(ZleceniaRepo.findByIdWykrojnika(idWykrojnika) != null && ZleceniaRepo.findByIloscEtykiet(iloscEtykiet) != null) {
			m.addAttribute("result", "Zlecenie istnieje juz w bazie");	
			return "result.jsp";
		}	
		
		else {	
			ZleceniaRepo.save(z);
			m.addAttribute("result",ZleceniaRepo.findAll());
		}
		
		
		
		
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
	public String getZlecenia(@ModelAttribute Zlecenia z, Kolory k, Model m)
	{
		
		m.addAttribute("result", ZleceniaRepo.findAll());
		m.addAttribute("result2", KoloryRepo.findAll());
	  
	
		
		return "zlecenia.jsp";
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
		

	//POBIERA STRONE DODAJ KLIENTA I SORTUJE PO NUMERZE KLIENTA MALEJĄCO
		@RequestMapping("addKlienciNumerKlientaDesc")
		public String addKlienciNumerKlientaDesc(@ModelAttribute Klienci kl, ModelMap m) 
		{
			m.addAttribute("result", KlienciRepo.findAll(Sort.by("numerKlienta").descending()));
			
			return "dodajKlienta.jsp";
		}
		
		//POBIERA STRONE DODAJ KLIENTA I SORTUJE PO NAZWIE KLIENTA MALEJĄCO
				@RequestMapping("addKlienciNazwaKlientaDesc")
				public String addKlienciNazwaKlientaDesc(@ModelAttribute Klienci kl, ModelMap m) 
				{
					m.addAttribute("result", KlienciRepo.findAll(Sort.by("nazwaKlienta").descending()));
					
					return "dodajKlienta.jsp";
				}
				
				//POBIERA STRONE DODAJ KLIENTA I SORTUJE PO NAZWIE KLIENTA MALEJĄCO
				@RequestMapping("addKlienciNazwaKlientaAsc")
				public String addKlienciNazwaKlientaAsc(@ModelAttribute Klienci kl, ModelMap m) 
				{
					m.addAttribute("result", KlienciRepo.findAll(Sort.by("nazwaKlienta").ascending()));
					
					return "dodajKlienta.jsp";
				}



}












