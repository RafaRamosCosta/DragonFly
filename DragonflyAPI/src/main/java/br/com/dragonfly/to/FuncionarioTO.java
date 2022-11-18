package br.com.dragonfly.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FuncionarioTO {
	private int idFunc;
	private String nmFunc;
	private long cpf;
	private String dtNasc, login, senha;
	
	public FuncionarioTO() {}

	public FuncionarioTO(int idFunc, String nmFunc, long cpf, String dtNasc, String login, String senha) {
		this.idFunc = idFunc;
		this.nmFunc = nmFunc;
		this.cpf = cpf;
		this.dtNasc = dtNasc;
		this.login = login;
		this.senha = senha;
	}

	public int getIdFunc() {
		return idFunc;
	}

	public void setIdFunc(int idFunc) {
		this.idFunc = idFunc;
	}

	public String getNmFunc() {
		return nmFunc;
	}

	public void setNmFunc(String nmFunc) {
		this.nmFunc = nmFunc;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
