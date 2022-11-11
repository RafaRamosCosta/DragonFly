package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.dragonfly.to.BairroTO;
import br.com.dragonfly.to.LogradouroTO;

public class LogradouroDAO {
	private Connection con = null;
	
	public LogradouroDAO() {
		this.con = new Conexao().abreConexao();
	}
	
	public ArrayList<LogradouroTO> listaLogradouros() {
		ArrayList<LogradouroTO> logs = new ArrayList<LogradouroTO>();
		String sql = "SELECT * FROM T_DF_LOGRADOURO";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idLog = rs.getInt(1);
				BairroTO bairro = new BairroTO();
				bairro.setIdBairro(rs.getInt(2));
				String nmLog = rs.getString(3);
				logs.add(new LogradouroTO(idLog, bairro, nmLog));
			}
			Conexao.fechaConexao(con);
			return logs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<LogradouroTO> listaLogradouro(int id) {
		ArrayList<LogradouroTO> logs = new ArrayList<LogradouroTO>();
		String sql = "SELECT L.id_logradouro, B.id_bairro, B.nm_bairro, L.nm_logradouro from T_DF_LOGRADOURO L INNER JOIN "
				+ "T_DF_BAIRRO B ON(L.id_bairro = B.id_bairro) WHERE L.id_bairro = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idLog = rs.getInt(1);
				BairroTO bairro = new BairroTO();
				bairro.setIdBairro(rs.getInt(2));
				bairro.setNmBairro(rs.getString(3));
				String nmLog = rs.getString(4);
				logs.add(new LogradouroTO(idLog, bairro, nmLog));
			}
			Conexao.fechaConexao(con);
			return logs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
