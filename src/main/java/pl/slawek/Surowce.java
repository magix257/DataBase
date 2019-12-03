package pl.slawek;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Surowce {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	
	

  @Column
	private String nazwaSurowca;
  @Column
	private String rodzajSurowca;
  
  
  public Surowce() {}


public Surowce(Long id, String nazwaSurowca, String rodzajSurowca) {
	super();
	this.id = id;
	this.nazwaSurowca = nazwaSurowca;
	this.rodzajSurowca = rodzajSurowca;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getNazwaSurowca() {
	return nazwaSurowca;
}


public void setNazwaSurowca(String nazwaSurowca) {
	this.nazwaSurowca = nazwaSurowca;
}


public String getRodzajSurowca() {
	return rodzajSurowca;
}


public void setRodzajSurowca(String rodzajSurowca) {
	this.rodzajSurowca = rodzajSurowca;
}


@Override
public String toString() {
	return "Surowce [id=" + id + ", nazwaSurowca=" + nazwaSurowca + ", rodzajSurowca=" + rodzajSurowca + "]";
}

    
}