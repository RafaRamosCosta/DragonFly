package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.dragonfly.to.BairroTO;

public class BairroDAO {
	private Connection con = null;
	private BairroTO bairro;
	
	public BairroDAO() {
		this.con = new Conexao().abreConexao();
	}
	
	public ArrayList<BairroTO> listaBairros() {
		ArrayList<BairroTO> bairros = new ArrayList<BairroTO>();
		String sql = "SELECT * FROM T_DF_BAIRRO";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idBairro = rs.getInt(1);
				String nmBairro = rs.getString(2);
				String zona = rs.getString(3);
				bairros.add(new BairroTO(idBairro, nmBairro, zona));
			}
			Conexao.fechaConexao(con);
			return bairros;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public BairroTO listaBairro(int id) {
		bairro = new BairroTO();
		String sql = "SELECT * FROM T_DF_BAIRRO WHERE id_bairro = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idBairro = rs.getInt(1);
				String nmBairro = rs.getString(2);
				String zona = rs.getString(3);
				bairro = new BairroTO(idBairro, nmBairro, zona);
			}
			Conexao.fechaConexao(con);
			return bairro;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
