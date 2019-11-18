package pl.slawek;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Zlecenia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
		private String[] kolory;
	  @Column
		private Date dataWysylki;
		
		
		public Zlecenia() {}
		
		public Zlecenia(Long id, int idWykrojnika, int szerokoscSurowca, int priorytet, int iloscEtykiet, int gilza,
				String numerEtykiety, String nazwaKlienta, String nazwaEtykiety, String maszyna, String rodzajSurowca,
				String wystawil, String[] kolory, Date dataWysylki) {
			super();
			this.id = id;
			this.idWykrojnika = idWykrojnika;
			this.szerokoscSurowca = szerokoscSurowca;
			this.priorytet = priorytet;
			this.iloscEtykiet = iloscEtykiet;
			this.gilza = gilza;
			this.numerEtykiety = numerEtykiety;
			this.nazwaKlienta = nazwaKlienta;
			this.nazwaEtykiety = nazwaEtykiety;
			this.maszyna = maszyna;
			this.rodzajSurowca = rodzajSurowca;
			this.wystawil = wystawil;
			this.kolory = kolory;
			this.dataWysylki = dataWysylki;
		}
		@Override
		public String toString() {
			return "Zlecenia [id=" + id + ", idWykrojnika=" + idWykrojnika + ", szerokoscSurowca=" + szerokoscSurowca
					+ ", priorytet=" + priorytet + ", iloscEtykiet=" + iloscEtykiet + ", gilza=" + gilza
					+ ", numerEtykiety=" + numerEtykiety + ", nazwaKlienta=" + nazwaKlienta + ", nazwaEtykiety="
					+ nazwaEtykiety + ", maszyna=" + maszyna + ", rodzajSurowca=" + rodzajSurowca + ", wystawil="
					+ wystawil + ", kolory=" + Arrays.toString(kolory) + ", dataWysylki=" + dataWysylki + "]";
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
		public String[] getKolory() {
			return kolory;
		}
		public void setKolory(String[] kolory) {
			this.kolory = kolory;
		}
		public Date getDataWysylki() {
			return dataWysylki;
		}
		public void setDataWysylki(Date dataWysylki) {
			this.dataWysylki = dataWysylki;
		}
	
		
	
		
	
}
