package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.dragonfly.to.BairroTO;
import br.com.dragonfly.to.LogradouroTO;

public class LogradouroDAO {
	private Connection con = null;
	private LogradouroTO log;
	
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
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public LogradouroTO listaLogradouro(int id) {
		log = new LogradouroTO();
		String sql = "SELECT * FROM T_DF_BAIRRO WHERE id_bairro = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idLog = rs.getInt(1);
				BairroTO bairro = new BairroTO();
				bairro.setIdBairro(rs.getInt(2));
				String nmLog = rs.getString(3);
				log = new LogradouroTO(idLog, bairro, nmLog);
			}
			Conexao.fechaConexao(con);
			return log;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
