package br.com.dragonfly.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ContatoEmpresaTO {
	private int idContEmp, nrTelefone;
	private EmpresaTO empresa;
	private String emailEmp;

	public ContatoEmpresaTO() {
	}

	public ContatoEmpresaTO(int idContEmp, int nrTelefone, EmpresaTO empresa, String emailEmp) {
		this.idContEmp = idContEmp;
		this.nrTelefone = nrTelefone;
		this.empresa = empresa;
		this.emailEmp = emailEmp;
	}

	public int getIdContEmp() {
		return idContEmp;
	}

	public void setIdContEmp(int idContEmp) {
		this.idContEmp = idContEmp;
	}

	public int getNrTelefone() {
		return nrTelefone;
	}

	public void setNrTelefone(int nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public EmpresaTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaTO empresa) {
		this.empresa = empresa;
	}

	public String getEmailEmp() {
		return emailEmp;
	}

	public void setEmailEmp(String emailEmp) {
		this.emailEmp = emailEmp;
	}

}
