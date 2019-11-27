package pl.slawek;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Klienci {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	
	
	@Column
	private int numerKlienta;
  @Column
	private String nazwaKlienta;
  
  
  public Klienci() {}


public Klienci(Long id, int numerKlienta, String nazwaKlienta) {
	super();
	this.id = id;
	this.numerKlienta = numerKlienta;
	this.nazwaKlienta = nazwaKlienta;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public int getNumerKlienta() {
	return numerKlienta;
}


public void setNumerKlienta(int numerKlienta) {
	this.numerKlienta = numerKlienta;
}


public String getNazwaKlienta() {
	return nazwaKlienta;
}


public void setNazwaKlienta(String nazwaKlienta) {
	this.nazwaKlienta = nazwaKlienta;
}


@Override
public String toString() {
	return "Klienci [id=" + id + ", numerKlienta=" + numerKlienta + ", nazwaKlienta=" + nazwaKlienta + "]";
}
  
  

  
  
}
