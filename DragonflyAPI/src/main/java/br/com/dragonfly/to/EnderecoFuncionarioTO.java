package br.com.dragonfly.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EnderecoFuncionarioTO {
	private int idEndFunc;
	private FuncionarioTO func;
	private LogradouroTO log;
	private int nrLog;

	public EnderecoFuncionarioTO() {}

	public EnderecoFuncionarioTO(int idEndFunc, FuncionarioTO func, LogradouroTO log, int nrLog) {
		this.idEndFunc = idEndFunc;
		this.func = func;
		this.log = log;
		this.nrLog = nrLog;
	}

	public int getIdEndFunc() {
		return idEndFunc;
	}

	public void setIdEndFunc(int idEndFunc) {
		this.idEndFunc = idEndFunc;
	}

	public FuncionarioTO getFunc() {
		return func;
	}

	public void setFunc(FuncionarioTO func) {
		this.func = func;
	}

	public LogradouroTO getLog() {
		return log;
	}

	public void setLog(LogradouroTO log) {
		this.log = log;
	}

	public int getNrLog() {
		return nrLog;
	}

	public void setNrLog(int nrLog) {
		this.nrLog = nrLog;
	}

}
