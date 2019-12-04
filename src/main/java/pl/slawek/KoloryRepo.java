package pl.slawek;

import org.springframework.data.jpa.repository.JpaRepository;



public interface KoloryRepo extends JpaRepository<Kolory, Long>{
	Kolory findByNazwaKoloruIgnoreCase(String nazwaKoloru);

} 