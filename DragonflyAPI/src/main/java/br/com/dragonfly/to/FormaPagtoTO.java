package br.com.dragonfly.to;

public class FormaPagtoTO {
	private int idFormaPagto;
	private String nmFormaPagto, stFormaPagto;
	
	public FormaPagtoTO() {}

	public FormaPagtoTO(int idFormaPagto, String nmFormaPagto, String stFormaPagto) {
		this.idFormaPagto = idFormaPagto;
		this.nmFormaPagto = nmFormaPagto;
		this.stFormaPagto = stFormaPagto;
	}

	public int getIdFormaPagto() {
		return idFormaPagto;
	}

	public void setIdFormaPagto(int idFormaPagto) {
		this.idFormaPagto = idFormaPagto;
	}

	public String getNmFormaPagto() {
		return nmFormaPagto;
	}

	public void setNmFormaPagto(String nmFormaPagto) {
		this.nmFormaPagto = nmFormaPagto;
	}

	public String getStFormaPagto() {
		return stFormaPagto;
	}

	public void setStFormaPagto(String stFormaPagto) {
		this.stFormaPagto = stFormaPagto;
	}
	
	
	
}
