package pl.slawek;

import org.springframework.data.jpa.repository.JpaRepository;



public interface KlienciRepo extends JpaRepository<Klienci, Long>{
	Klienci findByNumerKlienta(int numerKlienta);
	Klienci findByNazwaKlienta(String nazwaKlienta);
	

} 