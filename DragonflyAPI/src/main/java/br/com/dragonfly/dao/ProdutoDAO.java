package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.dragonfly.to.ProdutoTO;

public class ProdutoDAO implements IDAO{
	private Connection con = null;
	private ProdutoTO produto;

	public ProdutoDAO() {
		this.con = new Conexao().abreConexao();
	}

	public String inserir(Object obj) {
		produto = (ProdutoTO) obj;
		String sql = "INSERT INTO T_DF_PRODUTO(id_produto, nm_produto, ds_produto, vl_unitario, st_produto) "
				+ "VALUES(?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, null);
			ps.setString(2, produto.getNmProduto());
			ps.setString(3, produto.getDsProduto());
			ps.setFloat(4, produto.getVlUnitario());
			ps.setString(5, produto.getStProduto());

			if (ps.executeUpdate() > 0) {
				Conexao.fechaConexao(con);
				return "Inserido com sucesso!";
			} else {
				Conexao.fechaConexao(con);
				return "Erro ao inserir!";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public String alterar(Object obj) {
		produto = (ProdutoTO) obj;
		String sql = "UPDATE T_DF_PRODUTO SET nm_produto = ?, ds_produto = ?, vl_unitario = ?, st_produto = ? WHERE id_produto = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, produto.getNmProduto());
			ps.setString(2, produto.getDsProduto());
			ps.setFloat(3, produto.getVlUnitario());
			ps.setString(4, produto.getStProduto());
			ps.setInt(5, produto.getIdProduto());

			if (ps.executeUpdate() > 0) {
				Conexao.fechaConexao(con);
				return "Alterado com sucesso!";
			} else {
				Conexao.fechaConexao(con);
				return "Erro ao alterar!";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public String excluir(Object obj) {
		produto = (ProdutoTO) obj;
		String sql = "DELETE FROM T_DF_PRODUTO WHERE id_produto = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, produto.getIdProduto());

			if (ps.executeUpdate() > 0) {
				Conexao.fechaConexao(con);
				return "Excluído com sucesso!";
			} else {
				Conexao.fechaConexao(con);
				return "Erro ao excluir!";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public ArrayList<ProdutoTO> listaProdutos() {
		String sql = "SELECT * FROM T_DF_PRODUTO";
		ArrayList<ProdutoTO> produtos = new ArrayList<ProdutoTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idProduto = rs.getInt(1);
				String nmProduto = rs.getString(2);
				String dsProduto = rs.getString(3);
				float vlUnitario = rs.getFloat(4);
				String stProduto = rs.getString(5);
				produtos.add(new ProdutoTO(idProduto, nmProduto, dsProduto, stProduto, vlUnitario));
			}
			Conexao.fechaConexao(con);
			return produtos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ProdutoTO listaProduto(int id) {
		String sql = "SELECT * FROM T_DF_PRODUTO WHERE id_produto = ?";
		ProdutoTO produto = new ProdutoTO();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idProduto = rs.getInt(1);
				String nmProduto = rs.getString(2);
				String dsProduto = rs.getString(3);
				float vlUnitario = rs.getFloat(4);
				String stProduto = rs.getString(5);
				produto = new ProdutoTO(idProduto, nmProduto, dsProduto, stProduto, vlUnitario);
			}
			Conexao.fechaConexao(con);
			return produto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
