package pl.slawek;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

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
	
	//DODAJE ZLECENIE DO BAZY
	@RequestMapping("saveMetrics")
	public String saveMetrics(@RequestParam("numerKlienta") String numerKlienta, 
@RequestParam("numerEtykiety") String numerEtykiety, 
@RequestParam("idWykrojnika") String idWykrojnika,
@RequestParam("nawiniecie") String nawiniecie
//@RequestParam("kolor1swiec") String kolor1swiec,
//@RequestParam("kolor1") String kolor1,
//@RequestParam("zalewany1") String zalewany1,
//@RequestParam("wspolne1") String wspolne1,
//@RequestParam("kat1") String kat1,
//@RequestParam("liniatura1") String liniatura1
) 
	{
		try {
			FileWriter fstream = new FileWriter("F:\\POMOCE NOWE\\PROGRAMOWANIE_JAVA\\SPRING\\Metryka\\KP\\2\\0247\\0247-111\\"+numerKlienta+""+numerEtykiety+".metryka");

			
			fstream.write(numerKlienta); 
			fstream.write("-");
			fstream.write(numerEtykiety);
			fstream.write("\n");
			fstream.write("\n");
			fstream.write("id"+idWykrojnika);
			fstream.write("\t");
			fstream.write("n"+nawiniecie);
			
		//fstream.write(text);
		fstream.write("\n");
		fstream.close();
		
		
		} 
		
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
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












