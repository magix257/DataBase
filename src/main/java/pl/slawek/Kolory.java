package pl.slawek;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kolory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
	
	 @Column
		private String nazwaKoloru;
	 
	 
	 public Kolory() {}


	public Kolory(Long id, String nazwaKoloru) {
		super();
		this.id = id;
		this.nazwaKoloru = nazwaKoloru;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNazwaKoloru() {
		return nazwaKoloru;
	}


	public void setNazwaKoloru(String nazwaKoloru) {
		this.nazwaKoloru = nazwaKoloru;
	}
	 
	 
	 
	 

}
