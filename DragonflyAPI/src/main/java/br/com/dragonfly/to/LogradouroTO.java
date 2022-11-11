package br.com.dragonfly.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LogradouroTO {
	private int idLog;
	private BairroTO bairro;
	private String nmLog;
	
	public LogradouroTO() {}

	public LogradouroTO(int idLog, BairroTO bairro, String nmLog) {
		this.idLog = idLog;
		this.bairro = bairro;
		this.nmLog = nmLog;
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

	public String getNmLog() {
		return nmLog;
	}

	public void setNmLog(String nmLog) {
		this.nmLog = nmLog;
	}
	
	
}
