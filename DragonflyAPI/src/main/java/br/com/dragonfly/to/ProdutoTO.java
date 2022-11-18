package br.com.dragonfly.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProdutoTO {
	private int idProduto;
	private FuncionarioTO func;
	private String nmProduto, dsProduto, stProduto;
	private float vlUnitario;
	
	public ProdutoTO() {}

	public ProdutoTO(int idProduto, FuncionarioTO func, String nmProduto, String dsProduto, String stProduto, float vlUnitario) {
		this.idProduto = idProduto;
		this.func = func;
		this.nmProduto = nmProduto;
		this.dsProduto = dsProduto;
		this.stProduto = stProduto;
		this.vlUnitario = vlUnitario;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public FuncionarioTO getFunc() {
		return func;
	}
	
	public void setFunc(FuncionarioTO func) {
		this.func = func;
	}
	
	public String getNmProduto() {
		return nmProduto;
	}

	public void setNmProduto(String nmProduto) {
		this.nmProduto = nmProduto;
	}

	public String getDsProduto() {
		return dsProduto;
	}

	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}

	public String getStProduto() {
		return stProduto;
	}

	public void setStProduto(String stProduto) {
		this.stProduto = stProduto;
	}

	public float getVlUnitario() {
		return vlUnitario;
	}

	public void setVlUnitario(float vlUnitario) {
		this.vlUnitario = vlUnitario;
	}
	
	
	
}	
