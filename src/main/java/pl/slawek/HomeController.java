package pl.slawek;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@Autowired
	KoloryRepo KoloryRepo;
	
	@Autowired
	KlienciRepo KlienciRepo;
		
	@Autowired
	WykrojnikiRepo WykrojnikiRepo;
	
	String filePath ="A\\WYRAZY\\input.metryka";
	ReadFileToString rfts = new ReadFileToString();
	
	@RequestMapping("/")
	public String home(ModelMap m) 
	{
		m.put("result", KoloryRepo.findAll());
		m.put("result2", KlienciRepo.findAll(Sort.by("numerKlienta").ascending()));
		m.put("result3", WykrojnikiRepo.findAll());
		
		return "home.jsp";
	}
	
	
	//ZAPISUJE METRYKE
	@RequestMapping("saveMetrics")
	public String saveMetrics(@RequestParam("numerKlienta") String numerKlienta, 
@RequestParam("numerEtykiety") String numerEtykiety, 
@RequestParam("idWykrojnika") String idWykrojnika,
@RequestParam("nawiniecie") String nawiniecie,
@RequestParam(required = false) boolean kolor1swiec,
@RequestParam(required = false) boolean kolor2swiec,
@RequestParam(required = false) boolean kolor3swiec,
@RequestParam(required = false) boolean kolor4swiec,
@RequestParam(required = false) boolean kolor5swiec,
@RequestParam(required = false) boolean kolor6swiec,
@RequestParam(required = false) boolean kolor7swiec,
@RequestParam(required = false) boolean kolor8swiec,
@RequestParam(required = false) String kolor1,
@RequestParam(required = false) String kolor2,
@RequestParam(required = false) String kolor3,
@RequestParam(required = false) String kolor4,
@RequestParam(required = false) String kolor5,
@RequestParam(required = false) String kolor6,
@RequestParam(required = false) String kolor7,
@RequestParam(required = false) String kolor8,
@RequestParam(required = false) String zalewany1,
@RequestParam(required = false) String zalewany2,
@RequestParam(required = false) String zalewany3,
@RequestParam(required = false) String zalewany4,
@RequestParam(required = false) String zalewany5,
@RequestParam(required = false) String zalewany6,
@RequestParam(required = false) String zalewany7,
@RequestParam(required = false) String zalewany8,
@RequestParam(required = false) String wspolne1,
@RequestParam(required = false) String wspolne2,
@RequestParam(required = false) String wspolne3,
@RequestParam(required = false) String wspolne4,
@RequestParam(required = false) String wspolne5,
@RequestParam(required = false) String wspolne6,
@RequestParam(required = false) String wspolne7,
@RequestParam(required = false) String wspolne8,
@RequestParam(required = false) String kat1,
@RequestParam(required = false) String kat2,
@RequestParam(required = false) String kat3,
@RequestParam(required = false) String kat4,
@RequestParam(required = false) String kat5,
@RequestParam(required = false) String kat6,
@RequestParam(required = false) String kat7,
@RequestParam(required = false) String kat8,
@RequestParam(required = false) String liniatura1,
@RequestParam(required = false) String liniatura2,
@RequestParam(required = false) String liniatura3,
@RequestParam(required = false) String liniatura4,
@RequestParam(required = false) String liniatura5,
@RequestParam(required = false) String liniatura6,
@RequestParam(required = false) String liniatura7,
@RequestParam(required = false) String liniatura8,
@RequestParam(required = false) String liniatura,
@RequestParam(required = false) String nazwaEtykiety,
@RequestParam(required = false) String nazwaKlienta,
@RequestParam(required = false) String grafik,
@RequestParam(required = false) String dataWysylki,
@RequestParam(required = false) String uwagi
) throws ParseException 
	{
		String grupa = "";
		String n1 = "";
		String n2 = "";
		String swiecic = "x ";
		
	String[] kolory = {kolor1, kolor2, kolor3, kolor4, kolor5, kolor6, kolor7, kolor8};
	String[] zalewane = {zalewany1, zalewany2, zalewany3, zalewany4, zalewany5, zalewany6, zalewany7, zalewany8};
	String[] wspolne = {wspolne1, wspolne2, wspolne3, wspolne4, wspolne5, wspolne6, wspolne7, wspolne8};
	String[] katy = {kat1, kat2, kat3, kat4, kat5, kat6, kat7, kat8};
	String[] liniatury = {liniatura1, liniatura2, liniatura3, liniatura4, liniatura5, liniatura6, liniatura7, liniatura8};
	boolean[] koloryswiec = {kolor1swiec, kolor2swiec, kolor3swiec, kolor4swiec, kolor5swiec, kolor6swiec, kolor7swiec, kolor8swiec};
	String[] input = {"numerKlienta", "numerEtykiety", "idWykrojnika", "nawiniecie", "stacja1", "zalewamy1", "wspolne1", "kat1", "liniatura1", 
			"stacja2", "zalewamy2", "wspolne2", "kat2", "liniatura2", "stacja3", "zalewamy3", "wspolne3", "kat3", "liniatura3", 
			"stacja4", "zalewamy4", "wspolne4", "kat4", "liniatura4", "stacja5", "zalewamy5", "wspolne5", "kat5", "liniatura5", 
			"stacja6", "zalewamy6", "wspolne6", "kat6", "liniatura6", "stacja7", "zalewamy7", "wspolne7", "kat7", "liniatura7", 
			"stacja8", "zalewamy8", "wspolne8", "kat8", "liniatura8", "liniatura", "nazwaEtykiety", "nazwaKlienta", "grafik", "data", "uwagi"};
	
	//ITERACJA PRZEZ WSZYSTKIE KOLORY DO WYPISANIA		
	for (int i=0; i<8; i++) {
		
		int dlugoscWyrazuKolory = kolory[i].length();
		int dlugoscWyrazuZalewane = zalewane[i].length();
		int dlugoscWyrazuWspolne = wspolne[i].length();
		int dlugoscWyrazuKaty = katy[i].length();
		
		//DODAJE TYLE SPACJI ILE BRAKUJE DO 26 ZNAKÓW
		for (int k=0; k<26-dlugoscWyrazuKolory; k++) {
			kolory[i]=kolory[i]+" ";
		}
		//TO SAMO DLA KOLORÓW ZALEWANYCH
		if (!zalewane[i].equals("")) {
			zalewane[i] = "*"+zalewane[i];
			for (int z=0; z<25-dlugoscWyrazuZalewane; z++) {
				zalewane[i]=zalewane[i]+" ";
			}//KONCZY FOR DLA ZALEWANE
		}//KONCZY IF DLA ZALEWANE
		else {
for (int z=0; z<26-dlugoscWyrazuZalewane; z++) {
				zalewane[i]=zalewane[i]+" ";
			}
		}//KONCZY ELSE
		
		
		//DODAJE ZNACZEK & DLA WSPÓLNYCH
		if (!wspolne[i].equals("")) {
			wspolne[i] = "&"+wspolne[i];
			for (int z=0; z<11-dlugoscWyrazuWspolne; z++) {
				wspolne[i]=wspolne[i]+" ";
			}
			}
		else {
			for (int z=0; z<12; z++) {
				wspolne[i]=wspolne[i]+" ";
			}
		}
		if (!katy[i].equals("")) {
			for (int z=0; z<8-dlugoscWyrazuKaty; z++) {
				katy[i]=katy[i]+" ";
			}
			}
		else {
			for (int z=0; z<8; z++) {
				katy[i]=katy[i]+" ";
			}
		}
		
		if (!liniatury[i].equals("")) {
			liniatury[i] = liniatury[i]+"lpi";
		}
		
			//BRAK ZNAKU x GDY KOLOR NIE SWIECONY
	
		}//KONCZY FOR DLA i
	
	
	if (uwagi.equals("")) {
		uwagi = "UWAGI:";
	}
	else {
		uwagi = uwagi + "UWAGI:";
	}
			

		//DODAJE PODGRUPE KLIENTOW DO SCIEZKI ZAPISU
		if (numerKlienta.length()<3) {
			grupa = "0";
		}
		else if (numerKlienta.length()<4) {
			grupa = String.valueOf(numerKlienta.charAt(0));
		}
		else {
			n1 = String.valueOf(numerKlienta.charAt(0));
			n2 = String.valueOf(numerKlienta.charAt(1));
			grupa = n1+n2;
		}
		
		
		try {
			//DODAJE ZERA PRZED NUMEREM KLIENTA ABY ZAPIS BYL 4 CYFROWY
			if (numerKlienta.length()<4) {
				for (int x = numerKlienta.length(); x<4; x++) {
					numerKlienta = "0"+numerKlienta;
				}
			}
			
			//DODAJE ZERA PRZED NUMEREM ETYKIETY ABY ZAPIS BYL 3 CYFROWY
			if (numerEtykiety.length()<4) {
				for (int x = numerEtykiety.length(); x<3; x++) {
					numerEtykiety = "0"+numerEtykiety;
				}
			}
			
			//DODAJE ZERA PRZED ID WYKROJNIKA ABY ZAPIS BYL 4 CYFROWY
			if (idWykrojnika.length()<4) {
				for (int x = idWykrojnika.length(); x<4; x++) {
					idWykrojnika = "0"+idWykrojnika;
				}
			}
			//ZMIANA FORMATU DATY
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			Date data = sdf1.parse(dataWysylki);
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
			String data2 = String.valueOf(sdf2.format(data));
			
			String[] output = {numerKlienta, numerEtykiety, idWykrojnika, nawiniecie, kolory[0], zalewane[0], wspolne[0], katy[0], liniatury[0],
					kolory[1], zalewane[1], wspolne[1], katy[1], liniatury[1], kolory[2], zalewane[2], wspolne[2], katy[2], liniatury[2], 
					kolory[3], zalewane[3], wspolne[3], katy[3], liniatury[3], kolory[4], zalewane[4], wspolne[4], katy[4], liniatury[4], 
					kolory[5], zalewane[5], wspolne[5], katy[5], liniatury[5], kolory[6], zalewane[6], wspolne[6], katy[6], liniatury[6], 
					kolory[7], zalewane[7], wspolne[7], katy[7], liniatury[7], liniatura, nazwaEtykiety, nazwaKlienta, grafik, data2, uwagi};
			
			String[] podmiana = new String[50];
			
			//PODMIENIA WYRAZY WE WZORCU
			String wyrazy = ReadFileToString.readLineByLineJava8(filePath);
		
		for (int z=0; z<1; z++) {
			podmiana[z] = wyrazy.replace(input[z], output[z]);
			for (int o=1; o<podmiana.length; o++) {
				podmiana[o] = podmiana[o-1].replace(input[o], output[o]);
				}
		}
			
		FileWriter fstream = new FileWriter("F:\\POMOCE NOWE\\PROGRAMOWANIE_JAVA\\SPRING\\Metryka\\KP\\"+grupa+"\\"+numerKlienta+"\\"+numerKlienta+"-"+numerEtykiety+"\\"+numerKlienta+"-"+numerEtykiety+".metryka");
		fstream.write(podmiana[49]); 
		fstream.close();
		} 
		
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return "error.jsp";
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		return "result.jsp";
	}
	
	//GETTING METRICS FROM POINTED FILE
	@GetMapping("getMetrics")
	public String getZlecenia()
	{
		
		
	
		
		return "result.jsp";
	}
	
	
}












