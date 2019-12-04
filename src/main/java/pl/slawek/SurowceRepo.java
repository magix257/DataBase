package pl.slawek;

import org.springframework.data.jpa.repository.JpaRepository;



public interface SurowceRepo extends JpaRepository<Surowce, Long>{

	Surowce findByNazwaSurowcaIgnoreCase(String nazwaSurowca);
} 