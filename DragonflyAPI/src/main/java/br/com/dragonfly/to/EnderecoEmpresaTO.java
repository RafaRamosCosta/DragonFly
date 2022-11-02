package br.com.dragonfly.to;

public class EnderecoEmpresaTO {
	private int idEndEmp, nrLog;
	private EmpresaTO empresa;
	private String nmLog, nmBairro, zona;
	
	public EnderecoEmpresaTO() {}

	public EnderecoEmpresaTO(int idEndEmp, int nrLog, EmpresaTO empresa, String nmLog, String nmBairro, String zona) {
		this.idEndEmp = idEndEmp;
		this.nrLog = nrLog;
		this.empresa = empresa;
		this.nmBairro = nmBairro;
		this.zona = zona;
	}

	public int getIdEndEmp() {
		return idEndEmp;
	}

	public void setIdEndEmp(int idEndEmp) {
		this.idEndEmp = idEndEmp;
	}

	public int getNrLog() {
		return nrLog;
	}

	public void setNrLog(int nrLog) {
		this.nrLog = nrLog;
	}

	public EmpresaTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaTO empresa) {
		this.empresa = empresa;
	}
	
	public String getNmLog() {
		return nmLog;
	}
	
	public void setNmLog(String nmLog) {
		this.nmLog = nmLog;
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
