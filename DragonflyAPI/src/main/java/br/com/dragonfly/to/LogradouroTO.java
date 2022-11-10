package br.com.dragonfly.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LogradouroTO {
	private int idLog;
	private BairroTO bairro;
	private String nmLogradouro;
	
	public LogradouroTO() {}

	public LogradouroTO(int idLog, BairroTO bairro, String nmLogradouro) {
		this.idLog = idLog;
		this.bairro = bairro;
		this.nmLogradouro = nmLogradouro;
	}

	public int getIdLog() {
		return idLog;
	}

	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}

	public BairroTO getBairro() {
		return bairro;
	}

	public void setBairro(BairroTO bairro) {
		this.bairro = bairro;
	}

	public String getNmLogradouro() {
		return nmLogradouro;
	}

	public void setNmLogradouro(String nmLogradouro) {
		this.nmLogradouro = nmLogradouro;
	}
	
	
}
