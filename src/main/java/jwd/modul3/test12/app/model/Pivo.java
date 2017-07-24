package jwd.Modul3.Test12.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Pivo {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String naziv;
	@ManyToOne(fetch = FetchType.EAGER)
	private VrstaPiva vrstaPiva;
	@Column
	private Double procenatAlkohola;
	@Column
	private Double ibu;
	@Column
	private Integer naStanju;
	@ManyToOne(fetch = FetchType.EAGER)
	private Pivara pivara;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public VrstaPiva getVrstaPiva() {
		return vrstaPiva;
	}

	public void setVrstaPiva(VrstaPiva vrstaPiva) {
		this.vrstaPiva = vrstaPiva;
		if (!vrstaPiva.getPiva().contains(this)) {
			vrstaPiva.getPiva().add(this);
		}
	}

	public Double getProcenatAlkohola() {
		return procenatAlkohola;
	}

	public void setProcenatAlkohola(Double procenatAlkohola) {
		this.procenatAlkohola = procenatAlkohola;
	}

	public Double getIbu() {
		return ibu;
	}

	public void setIbu(Double ibu) {
		this.ibu = ibu;
	}

	public Integer getNaStanju() {
		return naStanju;
	}

	public void setNaStanju(Integer naStanju) {
		this.naStanju = naStanju;
	}

	public Pivara getPvara() {
		return pivara;
	}

	public void setPvara(Pivara pivara) {
		this.pivara = pivara;
		if (pivara != null && !pivara.getPiva().contains(this)) {
			pivara.getPiva().add(this);
		}
	}

}
