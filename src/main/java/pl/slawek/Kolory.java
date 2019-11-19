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
	
	@Column
	private int R;
	
	@Column
	private int G;
	
	@Column
	private int B;
	 
	 public Kolory() {}

	public Kolory(Long id, String nazwaKoloru, int r, int g, int b) {
		super();
		this.id = id;
		this.nazwaKoloru = nazwaKoloru;
		R = r;
		G = g;
		B = b;
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

	public int getR() {
		return R;
	}

	public void setR(int r) {
		R = r;
	}

	public int getG() {
		return G;
	}

	public void setG(int g) {
		G = g;
	}

	public int getB() {
		return B;
	}

	public void setB(int b) {
		B = b;
	}

	@Override
	public String toString() {
		return "Kolory [id=" + id + ", nazwaKoloru=" + nazwaKoloru + ", R=" + R + ", G=" + G + ", B=" + B + "]";
	}

	 
	 
	 
	 
}
	