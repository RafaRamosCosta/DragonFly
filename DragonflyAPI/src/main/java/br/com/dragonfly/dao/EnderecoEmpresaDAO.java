package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.dragonfly.to.EmpresaTO;
import br.com.dragonfly.to.EnderecoEmpresaTO;

public class EnderecoEmpresaDAO implements IDAO{
	private Connection con = null;
	private EnderecoEmpresaTO endereco;
	
	public EnderecoEmpresaDAO() {
		this.con = new Conexao().abreConexao();
	}
	
	public String inserir(Object obj) {
		endereco = (EnderecoEmpresaTO) obj;
		String sql = "INSERT INTO T_DF_ENDERECO_EMPRESA(id_endereco_empresa, id_empresa, nm_logradouro, nr_logradouro, nm_bairro, ds_zona)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, null);
			ps.setInt(2, endereco.getEmpresa().getIdEmpresa());
			ps.setString(3, endereco.getNmLog());
			ps.setLong(4, endereco.getNrLog());
			ps.setString(5, endereco.getNmBairro());
			ps.setString(6, endereco.getZona());
			
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
		endereco = (EnderecoEmpresaTO) obj;
		String sql = "UPDATE T_DF_ENDERECO_EMPRESA SET nm_logradouro = ?, nr_logradouro = ?, nm_bairro = ? WHERE id_endereco_empresa = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, endereco.getEmpresa().getIdEmpresa());
			ps.setString(2, endereco.getNmLog());
			ps.setLong(3, endereco.getNrLog());
			ps.setString(4, endereco.getNmBairro());
			ps.setInt(5, endereco.getIdEndEmp());
			
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
		endereco = (EnderecoEmpresaTO) obj;
		String sql = "DELETE FROM T_DF_ENDERECO_EMPRESA WHERE id_endereco_empresa = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, endereco.getIdEndEmp());
			
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
	
	public ArrayList<EnderecoEmpresaTO> listaEnderecos() {
		String sql = "SELECT * FROM T_DF_ENDERECO_EMPRESA";
		ArrayList<EnderecoEmpresaTO> enderecos = new ArrayList<EnderecoEmpresaTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idEndEmp = rs.getInt(1);
				EmpresaTO empresa = new EmpresaTO();
				empresa.setIdEmpresa(rs.getInt(2));
				String nmLog = rs.getString(3);
				int nrLog = rs.getInt(4);
				String nmBairro = rs.getString(5);
				String zona = rs.getString(6);
				enderecos.add(new EnderecoEmpresaTO(idEndEmp, nrLog, empresa, nmLog, nmBairro, zona));
			}
			Conexao.fechaConexao(con);
			return enderecos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public EnderecoEmpresaTO listaEndereco(int id) {
		String sql = "SELECT * FROM T_DF_ENDERECO_EMPRESA WHERE id_endereco_empresa = ?";
		EnderecoEmpresaTO endereco = new EnderecoEmpresaTO();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idEndEmp = rs.getInt(1);
				EmpresaTO empresa = new EmpresaTO();
				empresa.setIdEmpresa(rs.getInt(2));
				String nmLog = rs.getString(3);
				int nrLog = rs.getInt(4);
				String nmBairro = rs.getString(5);
				String zona = rs.getString(6);
				endereco = new EnderecoEmpresaTO(idEndEmp, nrLog, empresa, nmLog, nmBairro, zona);
			}
			Conexao.fechaConexao(con);
			return endereco;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
