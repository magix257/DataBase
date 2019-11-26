package pl.slawek;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ZleceniaRepo extends JpaRepository<Zlecenia, Long>{

	
	List<Zlecenia> findDistinctByNazwaKlienta(String nazwaKlienta);
} 
 