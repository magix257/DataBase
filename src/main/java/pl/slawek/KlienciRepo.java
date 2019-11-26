package pl.slawek;

import org.springframework.data.jpa.repository.JpaRepository;



public interface KlienciRepo extends JpaRepository<Klienci, Long>{
	Klienci findByNazwaKlienta(String nazwaKlienta);

} 