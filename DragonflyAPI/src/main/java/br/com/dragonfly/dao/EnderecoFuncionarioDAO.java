package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.dragonfly.to.EnderecoFuncionarioTO;
import br.com.dragonfly.to.FuncionarioTO;
import br.com.dragonfly.to.LogradouroTO;

@XmlRootElement
public class EnderecoFuncionarioDAO implements IDAO{
	private Connection con = null;
	private EnderecoFuncionarioTO endereco;
	
	public EnderecoFuncionarioDAO() {
		this.con = new Conexao().abreConexao();
	}
	
	public String inserir(Object obj) {
		endereco = (EnderecoFuncionarioTO) obj;
		String sql = "INSERT INTO T_DF_ENDERECO_FUNCIONARIO(id_endereco_funcionario, id_funcionario, id_logradouro, nr_logradouro_func) "
				+ "VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, null);
			ps.setInt(2, endereco.getFunc().getIdFunc());
			ps.setInt(3, endereco.getLog().getIdLog());
			ps.setInt(4, endereco.getNrLog());
			
			if (ps.executeUpdate() > 0) {
				Conexao.fechaConexao(con);
				return "Inserido com sucesso!";
			} else {
				Conexao.fechaConexao(con);
				return "Erro ao inserir!";
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public String alterar(Object obj) {
		endereco = (EnderecoFuncionarioTO) obj;
		String sql = "UPDATE T_DF_ENDERECO_FUNCIONARIO SET id_logradouro = ?, nr_logradouro = ? WHERE id_endereco_funcionario = ? ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, endereco.getLog().getIdLog());
			ps.setInt(2, endereco.getNrLog());
			ps.setInt(3, endereco.getIdEndFunc());
			
			if (ps.executeUpdate() > 0) {
				Conexao.fechaConexao(con);
				return "Alterado com sucesso!";
			} else {
				Conexao.fechaConexao(con);
				return "Erro ao alterar!";
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public String excluir(Object obj) {
		endereco = (EnderecoFuncionarioTO) obj;
		String sql = "DELETE FROM T_DF_ENDERECO_FUNCIONARIO WHERE id_endereco_funcionario = ? ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, endereco.getIdEndFunc());
			
			if (ps.executeUpdate() > 0) {
				Conexao.fechaConexao(con);
				return "Exclído com sucesso!";
			} else {
				Conexao.fechaConexao(con);
				return "Erro ao excluir!";
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public ArrayList<EnderecoFuncionarioTO> listaEnderecos() {
		ArrayList<EnderecoFuncionarioTO> enderecos = new ArrayList<EnderecoFuncionarioTO>();
		String sql = "SELECT * FROM T_DF_ENDERECO_FUNCIONARIO";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idEnd = rs.getInt(1);
				FuncionarioTO func = new FuncionarioTO();
				func.setIdFunc(rs.getInt(2));
				LogradouroTO log = new LogradouroTO();
				log.setIdLog(rs.getInt(3));
				int nrLog = rs.getInt(4);
				enderecos.add(new EnderecoFuncionarioTO(idEnd, func, log, nrLog));
			}
			Conexao.fechaConexao(con);
			return enderecos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public EnderecoFuncionarioTO listaEndereco(int id) {
		EnderecoFuncionarioTO endereco = new EnderecoFuncionarioTO();
		String sql = "SELECT * FROM T_DF_ENDERECO_FUNCIONARIO WHERE id_funcionario = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idEnd = rs.getInt(1);
				FuncionarioTO func = new FuncionarioTO();
				func.setIdFunc(rs.getInt(2));
				LogradouroTO log = new LogradouroTO();
				log.setIdLog(rs.getInt(3));
				int nrLog = rs.getInt(4);
				endereco = new EnderecoFuncionarioTO(idEnd, func, log, nrLog);
			}
			Conexao.fechaConexao(con);
			return endereco;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
