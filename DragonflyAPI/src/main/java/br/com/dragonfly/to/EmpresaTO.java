package br.com.dragonfly.to;

public class EmpresaTO {
	private int idEmpresa;
	private String nmFantasia, rzSocial, login, senha;
	private long cnpj;
	
	public EmpresaTO() {}
	
	public EmpresaTO(int idEmpresa, long cnpj, String nmFantasia, String rzSocial, String login, String senha) {
		this.idEmpresa = idEmpresa;
		this.cnpj = cnpj;
		this.nmFantasia = nmFantasia;
		this.rzSocial = rzSocial;
		this.login = login;
		this.senha = senha;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public String getNmFantasia() {
		return nmFantasia;
	}

	public void setNmFantasia(String nmFantasia) {
		this.nmFantasia = nmFantasia;
	}

	public String getRzSocial() {
		return rzSocial;
	}

	public void setRzSocial(String rzSocial) {
		this.rzSocial = rzSocial;
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
