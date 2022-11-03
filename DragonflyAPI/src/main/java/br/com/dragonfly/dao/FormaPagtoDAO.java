package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.dragonfly.to.FormaPagtoTO;
public class FormaPagtoDAO {
	private Connection con;
	private FormaPagtoTO formaPagto;
	
	public FormaPagtoDAO() {
		this.con = new Conexao().abreConexao();
	}
	
	public String inserir(Object obj) {
		formaPagto = (FormaPagtoTO) obj;
		String sql = "INSERT INTO T_DF_FORMA_PAGAMENTO(id_forma_pagto, nm_forma_pagto, st_forma_pagto)"
				+ "VALUES(?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, null);
			ps.setString(2, formaPagto.getNmFormaPagto());
			ps.setString(3, "A");
			
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
		formaPagto = (FormaPagtoTO) obj;
		String sql = "UPDATE T_DF_FORMA_PAGAMENTO SET st_forma_pagto = ? WHERE id_forma_pagto = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, formaPagto.getStFormaPagto());
			ps.setInt(2, formaPagto.getIdFormaPagto());
			
			if (ps.executeUpdate() > 0) {
				Conexao.fechaConexao(con);
				return "Alterado com sucesso!";
			} else {
				Conexao.fechaConexao(con);
				return "Erro ao alterado!";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public String excluir(Object obj) {
		formaPagto = (FormaPagtoTO) obj;
		String sql = "DELETE FROM T_DF_FORMA_PAGAMENTO WHERE id_forma_pagto = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, formaPagto.getIdFormaPagto());
			
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
	
	public ArrayList<FormaPagtoTO> listaFormas() {
		String sql = "SELECT * FROM T_DF_FORMA_PAGAMENTO";
		ArrayList<FormaPagtoTO> formasPagto = new ArrayList<FormaPagtoTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idFormaPagto = rs.getInt(1);
				String nmFormaPagto = rs.getString(2);
				String stFormaPagto = rs.getString(3);
				formasPagto.add(new FormaPagtoTO(idFormaPagto, nmFormaPagto, stFormaPagto));
			}
			
			Conexao.fechaConexao(con);
			return formasPagto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public FormaPagtoTO listaForma(int id) {
		String sql = "SELECT * FROM T_DF_FORMA_PAGAMENTO WHERE id_forma_pagto = ?";
		FormaPagtoTO formaPagto = new FormaPagtoTO();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idFormaPagto = rs.getInt(1);
				String nmFormaPagto = rs.getString(2);
				String stFormaPagto = rs.getString(3);
				formaPagto = new FormaPagtoTO(idFormaPagto, nmFormaPagto, stFormaPagto);
			}
			
			Conexao.fechaConexao(con);
			return formaPagto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
