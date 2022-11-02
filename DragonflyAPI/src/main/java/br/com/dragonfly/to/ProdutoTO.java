package br.com.dragonfly.to;

public class ProdutoTO {
	private int idProduto;
	private String nmProduto, dsProduto, stProduto;
	private float vlUnitario;
	
	public ProdutoTO() {}

	public ProdutoTO(int idProduto, String nmProduto, String dsProduto, String stProduto, float vlUnitario) {
		this.idProduto = idProduto;
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
