package pl.slawek;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestParam(required = false) String liniatura8
) 
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
	String[] kolorywydruk = new String[8];
	
	//ITERACJA PRZEZ WSZYSTKIE KOLORY DO WYPISANIA		
	for (int i=0; i<8; i++) {
		
		if (kolory[i].length()>=26) {
			kolory[i] = kolory[i]+"\t";
		}
		else if ((kolory[i].length()<26) && (kolory[i].length()>21)){
			kolory[i] = kolory[i]+"\t"+"\t";
		}
		else if ((kolory[i].length()<22) && (kolory[i].length()>17)) {
			kolory[i] = kolory[i]+"\t"+"\t"+"\t";
		}
		else if ((kolory[i].length()<18) && (kolory[i].length()>13)) {
			kolory[i] = kolory[i]+"\t"+"\t"+"\t"+"\t";
		}
		else if ((kolory[i].length()<14) && (kolory[i].length()>9)) {
			kolory[i] = kolory[i]+"\t"+"\t"+"\t"+"\t"+"\t";
		}
		else if ((kolory[i].length()<10) && (kolory[i].length()>5)) {
			kolory[i] = kolory[i]+"\t"+"\t"+"\t"+"\t"+"\t"+"\t";
		}
		else if ((kolory[i].length()<6) && (kolory[i].length()>1)) {
			kolory[i] = kolory[i]+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t";
		}
		else if (kolory[i].length()<2) {
			kolory[i] = kolory[i]+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t";
		}
		
		//TO SAMO DLA KOLORÓW ZALEWANYCH
		if (zalewane[i].length()>=26) {
			zalewane[i] = zalewane[i]+"\t";
		}
		else if ((zalewane[i].length()<26) && (zalewane[i].length()>22)){
			zalewane[i] = zalewane[i]+"\t"+"\t";
		}
		else if ((zalewane[i].length()<23) && (zalewane[i].length()>18)) {
			zalewane[i] = zalewane[i]+"\t"+"\t"+"\t";
		}
		else if ((zalewane[i].length()<19) && (zalewane[i].length()>14)) {
			zalewane[i] = zalewane[i]+"\t"+"\t"+"\t"+"\t";
		}
		else if ((zalewane[i].length()<15) && (zalewane[i].length()>9)) {
			zalewane[i] = zalewane[i]+"\t"+"\t"+"\t"+"\t"+"\t";
		}
		else if ((zalewane[i].length()<10) && (zalewane[i].length()>5)) {
			zalewane[i] = zalewane[i]+"\t"+"\t"+"\t"+"\t"+"\t"+"\t";
		}
		else if ((zalewane[i].length()<6) && (zalewane[i].length()>1)) {
			zalewane[i] = zalewane[i]+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t";
		}
		else if (zalewane[i].length()<2) {
			zalewane[i] = zalewane[i]+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t";
		}
		
		
		
		
			//BRAK ZNAKU x GDY KOLOR NIE SWIECONY
		if (koloryswiec[i] == false) {
			kolorywydruk[i] = ""+kolory[i]+"&"+zalewane[i]+wspolne[i]+katy[i]+liniatury[i]+"\n"+"\n";	
		}
		else {
			kolorywydruk[i] = ""+swiecic+kolory[i]+"&"+zalewane[i]+wspolne[i]+katy[i]+liniatury[i]+"\n"+"\n";
		}
			
		}//KONCZY FOR DLA i
			

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
			
			
			FileWriter fstream = new FileWriter("F:\\POMOCE NOWE\\PROGRAMOWANIE_JAVA\\SPRING\\Metryka\\KP\\"+grupa+"\\"+numerKlienta+"\\"+numerKlienta+"-"+numerEtykiety+"\\"+numerKlienta+"-"+numerEtykiety+".metryka");

			
			fstream.write(numerKlienta); 
			fstream.write("-");
			fstream.write(numerEtykiety);
			fstream.write("\n"+"\n");
			fstream.write("id"+idWykrojnika);
			fstream.write("\t");
			fstream.write("n"+nawiniecie);
			fstream.write("\n"+"\n");
			for (int z=0; z<kolorywydruk.length; z++) {
			fstream.write(kolorywydruk[z]); 
			}
		//fstream.write(text);
		
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












