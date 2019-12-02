package pl.slawek;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wykrojniki {
	
	@Id
private int id;

	@Column
	private String typ;
	@Column
	private int szerokoscPapieru;
	@Column
	private String uzytki;
	@Column
	private int zeby;
	@Column
	private BigDecimal szerokosc;
	@Column
	private BigDecimal dlugosc;
	@Column
	private String r;
	@Column
	private String a1;
	@Column
	private String a2;
	@Column
	private String tuba;
	@Column
	private int blokada;
	@Column
	private int predkosc;
	

	public Wykrojniki() {}


	public Wykrojniki(int id, String typ, int szerokoscPapieru, String uzytki, int zeby, BigDecimal szerokosc,
			BigDecimal dlugosc, String r, String a1, String a2, String tuba, int blokada, int predkosc) {
		super();
		this.id = id;
		this.typ = typ;
		this.szerokoscPapieru = szerokoscPapieru;
		this.uzytki = uzytki;
		this.zeby = zeby;
		this.szerokosc = szerokosc;
		this.dlugosc = dlugosc;
		this.r = r;
		this.a1 = a1;
		this.a2 = a2;
		this.tuba = tuba;
		this.blokada = blokada;
		this.predkosc = predkosc;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTyp() {
		return typ;
	}


	public void setTyp(String typ) {
		this.typ = typ;
	}


	public int getSzerokoscPapieru() {
		return szerokoscPapieru;
	}


	public void setSzerokoscPapieru(int szerokoscPapieru) {
		this.szerokoscPapieru = szerokoscPapieru;
	}


	public String getUzytki() {
		return uzytki;
	}


	public void setUzytki(String uzytki) {
		this.uzytki = uzytki;
	}


	public int getZeby() {
		return zeby;
	}


	public void setZeby(int zeby) {
		this.zeby = zeby;
	}


	public BigDecimal getSzerokosc() {
		return szerokosc;
	}


	public void setSzerokosc(BigDecimal szerokosc) {
		this.szerokosc = szerokosc;
	}


	public BigDecimal getDlugosc() {
		return dlugosc;
	}


	public void setDlugosc(BigDecimal dlugosc) {
		this.dlugosc = dlugosc;
	}


	public String getR() {
		return r;
	}


	public void setR(String r) {
		this.r = r;
	}


	public String getA1() {
		return a1;
	}


	public void setA1(String a1) {
		this.a1 = a1;
	}


	public String getA2() {
		return a2;
	}


	public void setA2(String a2) {
		this.a2 = a2;
	}


	public String getTuba() {
		return tuba;
	}


	public void setTuba(String tuba) {
		this.tuba = tuba;
	}


	public int getBlokada() {
		return blokada;
	}


	public void setBlokada(int blokada) {
		this.blokada = blokada;
	}


	public int getPredkosc() {
		return predkosc;
	}


	public void setPredkosc(int predkosc) {
		this.predkosc = predkosc;
	}


	@Override
	public String toString() {
		return "Wykrojniki [id=" + id + ", typ=" + typ + ", szerokoscPapieru=" + szerokoscPapieru + ", uzytki=" + uzytki
				+ ", zeby=" + zeby + ", szerokosc=" + szerokosc + ", dlugosc=" + dlugosc + ", r=" + r + ", a1=" + a1
				+ ", a2=" + a2 + ", tuba=" + tuba + ", blokada=" + blokada + ", predkosc=" + predkosc + "]";
	}
	
	

	
	
}
