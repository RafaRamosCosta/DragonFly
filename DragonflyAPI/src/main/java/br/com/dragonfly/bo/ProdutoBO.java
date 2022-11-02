package br.com.dragonfly.bo;

import java.util.ArrayList;

import br.com.dragonfly.dao.ProdutoDAO;
import br.com.dragonfly.to.ProdutoTO;

public class ProdutoBO {
	private ProdutoDAO pDAO;
	
	public String cadastraProduto(ProdutoTO produto) {
		pDAO = new ProdutoDAO();
		return pDAO.inserir(produto);
	}
	
	public String alteraProduto(ProdutoTO produto) {
		pDAO = new ProdutoDAO();
		return pDAO.alterar(produto);
	}
	
	public String excluiProduto(ProdutoTO produto) {
		pDAO = new ProdutoDAO();
		return pDAO.excluir(produto);
	}
	
	public ArrayList<ProdutoTO> listaProdutos() {
		ArrayList<ProdutoTO> empresas;
		pDAO = new ProdutoDAO();
		empresas = pDAO.listaProdutos();
		return empresas;
	}
	
	public ProdutoTO listaProduto(int id) {
		pDAO = new ProdutoDAO();
		return pDAO.listaProduto(id);
	}
}
