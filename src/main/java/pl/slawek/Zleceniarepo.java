package pl.slawek;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ZleceniaRepo extends JpaRepository<Zlecenia, Long>{
	
	Zlecenia findByIdWykrojnika(int idWykrojnika);
	Zlecenia findByIloscEtykiet(int iloscEtykiet);
	Zlecenia findByGilza(int gilza);
	Zlecenia findByNumerKlienta(int numerKlienta);
	Zlecenia findByNumerEtykietyIgnoreCase(String numerEtykiety);
	Zlecenia findByNazwaKlientaIgnoreCase(String nazwaKlienta);
	Zlecenia findByRodzajSurowcaIgnoreCase(String rodzajSurowca);
	Zlecenia findByDataWysylki(Date dataWysylki);
	Zlecenia findByKolor1IgnoreCase(String kolor1);
	Zlecenia findByKolor2IgnoreCase(String kolor2);
	Zlecenia findByKolor3IgnoreCase(String kolor3);
	Zlecenia findByKolor4IgnoreCase(String kolor4);
	Zlecenia findByKolor5IgnoreCase(String kolor5);
	Zlecenia findByKolor6IgnoreCase(String kolor6);
	Zlecenia findByKolor7IgnoreCase(String kolor7);
	Zlecenia findByKolor8IgnoreCase(String kolor8);
	
} 
 