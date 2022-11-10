package br.com.dragonfly.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EnderecoEmpresaTO {
	private int idEndEmp, nrLog;
	private EmpresaTO empresa;
	private LogradouroTO log;

	public EnderecoEmpresaTO() {}

	public EnderecoEmpresaTO(int idEndEmp, int nrLog, EmpresaTO empresa, LogradouroTO log) {
		this.idEndEmp = idEndEmp;
		this.nrLog = nrLog;
		this.empresa = empresa;
		this.log = log;
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

	public LogradouroTO getLog() {
		return log;
	}

	public void setLog(LogradouroTO log) {
		this.log = log;
	}

}