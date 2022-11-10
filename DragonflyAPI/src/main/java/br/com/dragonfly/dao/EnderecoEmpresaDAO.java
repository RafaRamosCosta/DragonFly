package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.dragonfly.to.EmpresaTO;
import br.com.dragonfly.to.EnderecoEmpresaTO;
import br.com.dragonfly.to.LogradouroTO;

public class EnderecoEmpresaDAO implements IDAO{
	private Connection con = null;
	private EnderecoEmpresaTO endereco;
	
	public EnderecoEmpresaDAO() {
		this.con = new Conexao().abreConexao();
	}
	
	public String inserir(Object obj) {
		endereco = (EnderecoEmpresaTO) obj;
		String sql = "INSERT INTO T_DF_ENDERECO_EMPRESA(id_endereco_empresa, id_empresa, id_logradouro, nr_logradouro)"
				+ "VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, null);
			ps.setInt(2, endereco.getEmpresa().getIdEmpresa());
			ps.setInt(3, endereco.getLog().getIdLog());
			ps.setLong(4, endereco.getNrLog());
			
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
		String sql = "UPDATE T_DF_ENDERECO_EMPRESA SET id_logradouro = ?, nr_logradouro = ? WHERE id_endereco_empresa = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, endereco.getLog().getIdLog());
			ps.setInt(2, endereco.getNrLog());
			ps.setInt(3, endereco.getEmpresa().getIdEmpresa());
			
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
			Conexao.fechaConexao(con);
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
				LogradouroTO log = new LogradouroTO();
				log.setIdLog(rs.getInt(3));
				int nrLog = rs.getInt(4);
				enderecos.add(new EnderecoEmpresaTO(idEndEmp, nrLog, empresa, log));
			}
			Conexao.fechaConexao(con);
			return enderecos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public EnderecoEmpresaTO listaEndereco(int id) {
		String sql = "SELECT * FROM T_DF_ENDERECO_EMPRESA WHERE id_empresa = ?";
		EnderecoEmpresaTO endereco = new EnderecoEmpresaTO();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idEndEmp = rs.getInt(1);
				EmpresaTO empresa = new EmpresaTO();
				empresa.setIdEmpresa(rs.getInt(2));
				LogradouroTO log = new LogradouroTO();
				log.setIdLog(rs.getInt(3));
				int nrLog = rs.getInt(4);
				endereco = new EnderecoEmpresaTO(idEndEmp, nrLog, empresa, log);
			}
			Conexao.fechaConexao(con);
			return endereco;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
