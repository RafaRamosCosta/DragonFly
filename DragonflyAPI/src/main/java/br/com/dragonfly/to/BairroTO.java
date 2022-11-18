package br.com.dragonfly.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BairroTO {
	private int idBairro;
	private String nmBairro;
	private String zona;
	
	public BairroTO() {}

	public BairroTO(int idBairro, String nmBairro, String zona) {
		this.idBairro = idBairro;
		this.nmBairro = nmBairro;
		this.zona = zona;
	}

	public int getIdBairro() {
		return idBairro;
	}

	public void setIdBairro(int idBairro) {
		this.idBairro = idBairro;
	}

	public String getNmBairro() {
		return nmBairro;
	}

	public void setNmBairro(String nmBairro) {
		this.nmBairro = nmBairro;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	
	
	
}
