package pl.slawek;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Zlecenia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;
		
	  @Column
		private int idWykrojnika;
	  @Column
		private int szerokoscSurowca;
	  @Column
		private int priorytet;
	  @Column
		private int iloscEtykiet;
	  @Column
		private int gilza;
	  @Column
		private int numerKlienta;
	  @Column
		private String numerEtykiety;
	  @Column
		private String nazwaKlienta;
	  @Column
		private String nazwaEtykiety;
	  @Column
		private String maszyna;
	  @Column
		private String rodzajSurowca;
	  @Column
		private String wystawil;
	  @Column
		private String kolor1;
	  @Column
		private String kolor2;
	  @Column
		private String kolor3;
	  @Column
		private String kolor4;
	  @Column
		private String kolor5;
	  @Column
		private String kolor6;
	  @Column
		private String kolor7;
	  @Column
		private String kolor8;
	  @Column
		private Date dataWysylki;
		
		
		public Zlecenia() {}


		public Zlecenia(Long id, int idWykrojnika, int szerokoscSurowca, int priorytet, int iloscEtykiet, int gilza,
				int numerKlienta, String numerEtykiety, String nazwaKlienta, String nazwaEtykiety, String maszyna,
				String rodzajSurowca, String wystawil, String kolor1, String kolor2, String kolor3, String kolor4,
				String kolor5, String kolor6, String kolor7, String kolor8, Date dataWysylki) {
			super();
			this.id = id;
			this.idWykrojnika = idWykrojnika;
			this.szerokoscSurowca = szerokoscSurowca;
			this.priorytet = priorytet;
			this.iloscEtykiet = iloscEtykiet;
			this.gilza = gilza;
			this.numerKlienta = numerKlienta;
			this.numerEtykiety = numerEtykiety;
			this.nazwaKlienta = nazwaKlienta;
			this.nazwaEtykiety = nazwaEtykiety;
			this.maszyna = maszyna;
			this.rodzajSurowca = rodzajSurowca;
			this.wystawil = wystawil;
			this.kolor1 = kolor1;
			this.kolor2 = kolor2;
			this.kolor3 = kolor3;
			this.kolor4 = kolor4;
			this.kolor5 = kolor5;
			this.kolor6 = kolor6;
			this.kolor7 = kolor7;
			this.kolor8 = kolor8;
			this.dataWysylki = dataWysylki;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public int getIdWykrojnika() {
			return idWykrojnika;
		}


		public void setIdWykrojnika(int idWykrojnika) {
			this.idWykrojnika = idWykrojnika;
		}


		public int getSzerokoscSurowca() {
			return szerokoscSurowca;
		}


		public void setSzerokoscSurowca(int szerokoscSurowca) {
			this.szerokoscSurowca = szerokoscSurowca;
		}


		public int getPriorytet() {
			return priorytet;
		}


		public void setPriorytet(int priorytet) {
			this.priorytet = priorytet;
		}


		public int getIloscEtykiet() {
			return iloscEtykiet;
		}


		public void setIloscEtykiet(int iloscEtykiet) {
			this.iloscEtykiet = iloscEtykiet;
		}


		public int getGilza() {
			return gilza;
		}


		public void setGilza(int gilza) {
			this.gilza = gilza;
		}


		public int getNumerKlienta() {
			return numerKlienta;
		}


		public void setNumerKlienta(int numerKlienta) {
			this.numerKlienta = numerKlienta;
		}


		public String getNumerEtykiety() {
			return numerEtykiety;
		}


		public void setNumerEtykiety(String numerEtykiety) {
			this.numerEtykiety = numerEtykiety;
		}


		public String getNazwaKlienta() {
			return nazwaKlienta;
		}


		public void setNazwaKlienta(String nazwaKlienta) {
			this.nazwaKlienta = nazwaKlienta;
		}


		public String getNazwaEtykiety() {
			return nazwaEtykiety;
		}


		public void setNazwaEtykiety(String nazwaEtykiety) {
			this.nazwaEtykiety = nazwaEtykiety;
		}


		public String getMaszyna() {
			return maszyna;
		}


		public void setMaszyna(String maszyna) {
			this.maszyna = maszyna;
		}


		public String getRodzajSurowca() {
			return rodzajSurowca;
		}


		public void setRodzajSurowca(String rodzajSurowca) {
			this.rodzajSurowca = rodzajSurowca;
		}


		public String getWystawil() {
			return wystawil;
		}


		public void setWystawil(String wystawil) {
			this.wystawil = wystawil;
		}


		public String getKolor1() {
			return kolor1;
		}


		public void setKolor1(String kolor1) {
			this.kolor1 = kolor1;
		}


		public String getKolor2() {
			return kolor2;
		}


		public void setKolor2(String kolor2) {
			this.kolor2 = kolor2;
		}


		public String getKolor3() {
			return kolor3;
		}


		public void setKolor3(String kolor3) {
			this.kolor3 = kolor3;
		}


		public String getKolor4() {
			return kolor4;
		}


		public void setKolor4(String kolor4) {
			this.kolor4 = kolor4;
		}


		public String getKolor5() {
			return kolor5;
		}


		public void setKolor5(String kolor5) {
			this.kolor5 = kolor5;
		}


		public String getKolor6() {
			return kolor6;
		}


		public void setKolor6(String kolor6) {
			this.kolor6 = kolor6;
		}


		public String getKolor7() {
			return kolor7;
		}


		public void setKolor7(String kolor7) {
			this.kolor7 = kolor7;
		}


		public String getKolor8() {
			return kolor8;
		}


		public void setKolor8(String kolor8) {
			this.kolor8 = kolor8;
		}


		public Date getDataWysylki() {
			return dataWysylki;
		}


		public void setDataWysylki(Date dataWysylki) {
			this.dataWysylki = dataWysylki;
		}


		@Override
		public String toString() {
			return "Zlecenia [id=" + id + ", idWykrojnika=" + idWykrojnika + ", szerokoscSurowca=" + szerokoscSurowca
					+ ", priorytet=" + priorytet + ", iloscEtykiet=" + iloscEtykiet + ", gilza=" + gilza
					+ ", numerKlienta=" + numerKlienta + ", numerEtykiety=" + numerEtykiety + ", nazwaKlienta="
					+ nazwaKlienta + ", nazwaEtykiety=" + nazwaEtykiety + ", maszyna=" + maszyna + ", rodzajSurowca="
					+ rodzajSurowca + ", wystawil=" + wystawil + ", kolor1=" + kolor1 + ", kolor2=" + kolor2
					+ ", kolor3=" + kolor3 + ", kolor4=" + kolor4 + ", kolor5=" + kolor5 + ", kolor6=" + kolor6
					+ ", kolor7=" + kolor7 + ", kolor8=" + kolor8 + ", dataWysylki=" + dataWysylki + "]";
		}

		

		
}