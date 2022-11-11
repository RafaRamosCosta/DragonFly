package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.dragonfly.to.FuncionarioTO;
import br.com.dragonfly.to.ProdutoTO;

public class ProdutoDAO implements IDAO{
	private Connection con = null;
	private ProdutoTO produto;

	public ProdutoDAO() {
		this.con = new Conexao().abreConexao();
	}

	public String inserir(Object obj) {
		produto = (ProdutoTO) obj;
		String sql = "INSERT INTO T_DF_PRODUTO(id_produto, id_funcionario, nm_produto, ds_produto, vl_unitario, st_produto) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, null);
			ps.setInt(2, produto.getFunc().getIdFunc());
			ps.setString(3, produto.getNmProduto());
			ps.setString(4, produto.getDsProduto());
			ps.setFloat(5, produto.getVlUnitario());
			ps.setString(6, "A");

			if (ps.executeUpdate() > 0) {
				Conexao.fechaConexao(con);
				return "Inserido com sucesso!";
			} else {
				Conexao.fechaConexao(con);
				return "Erro ao inserir!";
			}
		} catch (SQLException e) {
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
		} catch (SQLException e) {
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
		} catch (SQLException e) {
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
				FuncionarioTO func = new FuncionarioTO();
				func.setIdFunc(rs.getInt(2));
				String nmProduto = rs.getString(3);
				String dsProduto = rs.getString(4);
				float vlUnitario = rs.getFloat(5);
				String stProduto = rs.getString(6);
				produtos.add(new ProdutoTO(idProduto, func, nmProduto, dsProduto, stProduto, vlUnitario));
			}
			Conexao.fechaConexao(con);
			return produtos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ProdutoTO listaProduto(int id) {
		String sql = "SELECT * FROM T_DF_PRODUTO WHERE id_funcionario = ?";
		ProdutoTO produto = new ProdutoTO();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idProduto = rs.getInt(1);
				FuncionarioTO func = new FuncionarioTO();
				func.setIdFunc(rs.getInt(2));
				String nmProduto = rs.getString(3);
				String dsProduto = rs.getString(4);
				float vlUnitario = rs.getFloat(5);
				String stProduto = rs.getString(6);
				produto = new ProdutoTO(idProduto, func, nmProduto, dsProduto, stProduto, vlUnitario);
			}
			Conexao.fechaConexao(con);
			return produto;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
