package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.dragonfly.to.ContatoFuncionarioTO;
import br.com.dragonfly.to.FuncionarioTO;

public class ContatoFuncionarioDAO implements IDAO{
	private Connection con = null;
	private ContatoFuncionarioTO contato;
	
	public ContatoFuncionarioDAO() {
		this.con = new Conexao().abreConexao();
	}
	
	public String inserir (Object obj) {
		contato = (ContatoFuncionarioTO) obj;
		String sql = "INSERT INTO T_DF_CONTATO_FUNCIONARIO(id_contato_funcionario, id_funcionario, nr_telefone, ds_email) "
				+ "VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, null);
			ps.setInt(2, contato.getFunc().getIdFunc());
			ps.setInt(3, contato.getNrTelefone());
			ps.setString(4, contato.getEmailFunc());
			
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
	
	public String alterar (Object obj) {
		contato = (ContatoFuncionarioTO) obj;
		String sql = "UPDATE T_DF_CONTATO_FUNCIONARIO SET nr_telefone = ?, ds_email = ? WHERE id_funcionario = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, contato.getNrTelefone());
			ps.setString(2, contato.getEmailFunc());
			ps.setInt(3, contato.getIdContFunc());
			
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
	
	public String excluir (Object obj) {
		contato = (ContatoFuncionarioTO) obj;
		String sql = "DELETE FROM T_DF_CONTATO_FUNCIONARIO WHERE id_funcionario = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, contato.getIdContFunc());
			
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
	
	public ArrayList<ContatoFuncionarioTO> listaContatos() {
		ArrayList<ContatoFuncionarioTO> contatos = new ArrayList<ContatoFuncionarioTO>();
		String sql = "SELECT * FROM T_DF_CONTATO_FUNCIONARIO";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idContFunc = rs.getInt(1);
				FuncionarioTO func = new FuncionarioTO();
				func.setIdFunc(rs.getInt(2));
				int nrTelefone = rs.getInt(3);
				String emailFunc = rs.getString(4);
				contatos.add(new ContatoFuncionarioTO(idContFunc, func, nrTelefone, emailFunc));
			}
			Conexao.fechaConexao(con);
			return contatos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ContatoFuncionarioTO listaContato(int id) {
		ContatoFuncionarioTO contato = new ContatoFuncionarioTO();
		String sql = "SELECT * FROM T_DF_CONTATO_FUNCIONARIO WHERE id_funcionario = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idContFunc = rs.getInt(1);
				FuncionarioTO func = new FuncionarioTO();
				func.setIdFunc(rs.getInt(2));
				int nrTelefone = rs.getInt(3);
				String emailFunc = rs.getString(4);
				contato = new ContatoFuncionarioTO(idContFunc, func, nrTelefone, emailFunc);
			}
			Conexao.fechaConexao(con);
			return contato;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
