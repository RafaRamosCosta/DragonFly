package br.com.dragonfly.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ContatoFuncionarioTO {
	private int idContFunc;
	private FuncionarioTO func;
	private int nrTelefone;
	private String emailFunc;
	
	public ContatoFuncionarioTO() {}

	public ContatoFuncionarioTO(int idContFunc, FuncionarioTO func, int nrTelefone, String emailFunc) {
		this.idContFunc = idContFunc;
		this.func = func;
		this.nrTelefone = nrTelefone;
		this.emailFunc = emailFunc;
	}

	public int getIdContFunc() {
		return idContFunc;
	}

	public void setIdContFunc(int idContFunc) {
		this.idContFunc = idContFunc;
	}

	public FuncionarioTO getFunc() {
		return func;
	}

	public void setFunc(FuncionarioTO func) {
		this.func = func;
	}

	public int getNrTelefone() {
		return nrTelefone;
	}

	public void setNrTelefone(int nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public String getEmailFunc() {
		return emailFunc;
	}

	public void setEmailFunc(String emailFunc) {
		this.emailFunc = emailFunc;
	}
	
	
}
