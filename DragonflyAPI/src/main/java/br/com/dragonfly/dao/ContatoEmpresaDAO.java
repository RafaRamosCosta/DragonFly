package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.dragonfly.to.ContatoEmpresaTO;
import br.com.dragonfly.to.EmpresaTO;

public class ContatoEmpresaDAO implements IDAO{
	private Connection con;
	private ContatoEmpresaTO contato;
	
	public ContatoEmpresaDAO() {
		this.con = new Conexao().abreConexao();
	}
	
	public String inserir(Object obj) {
		contato = (ContatoEmpresaTO) obj;
		String sql = "INSERT INTO T_DF_CONTATO_EMPRESA(id_contato_empresa, id_empresa, nr_telefone, ds_email)"
				+ "VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, null);
			ps.setInt(2, contato.getEmpresa().getIdEmpresa());
			ps.setInt(3, contato.getNrTelefone());
			ps.setString(4, contato.getEmailEmp());
			
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
		contato = (ContatoEmpresaTO) obj;
		String sql = "UPDATE T_DF_CONTATO_EMPRESA SET nr_telefone = ?, ds_email = ? WHERE id_contato_empresa = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, contato.getNrTelefone());
			ps.setString(2, contato.getEmailEmp());
			ps.setInt(3, contato.getIdContEmp());
			
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
		contato = (ContatoEmpresaTO) obj;
		String sql = "DELETE FROM T_DF_CONTATO_EMPRESA WHERE id_contato_empresa = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, contato.getIdContEmp());
			
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
	
	public ArrayList<ContatoEmpresaTO> listaContatos() {
		String sql = "SELECT * FROM T_DF_CONTATO_EMPRESA";
		ArrayList<ContatoEmpresaTO> contatos = new ArrayList<ContatoEmpresaTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idContEmp = rs.getInt(1);
				EmpresaTO empresa = new EmpresaTO();
				empresa.setIdEmpresa(rs.getInt(2));
				int nrTelefone = rs.getInt(3);
				String emailEmp = rs.getString(4);
				contatos.add(new ContatoEmpresaTO(idContEmp, nrTelefone, empresa, emailEmp));
			}
			Conexao.fechaConexao(con);
			return contatos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ContatoEmpresaTO listaContato(int id) {
		String sql = "SELECT * FROM T_DF_CONTATO_EMPRESA WHERE id_contato_empresa = ?";
		ContatoEmpresaTO contato = new ContatoEmpresaTO();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idContEmp = rs.getInt(1);
				EmpresaTO empresa = new EmpresaTO();
				empresa.setIdEmpresa(rs.getInt(2));
				int nrTelefone = rs.getInt(3);
				String emailEmp = rs.getString(4);
				contato = new ContatoEmpresaTO(idContEmp, nrTelefone, empresa, emailEmp);
			}
			Conexao.fechaConexao(con);
			return contato;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
