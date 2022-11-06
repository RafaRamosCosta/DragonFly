package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.dragonfly.to.EmpresaTO;

public class EmpresaDAO implements IDAO{
	private Connection con = null;
	private EmpresaTO empresa;
	
	public EmpresaDAO() {
		this.con = new Conexao().abreConexao();
	}
	
	public String inserir(Object obj) {
		empresa = (EmpresaTO) obj;
		String sql = "INSERT INTO T_DF_EMPRESA(id_empresa, nm_fantasia, nm_razao_social, nr_cnpj, ds_login, ds_senha) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, null);
			ps.setString(2, empresa.getNmFantasia());
			ps.setString(3, empresa.getRzSocial());
			ps.setLong(4, empresa.getCnpj());
			ps.setString(5, empresa.getLogin());
			ps.setString(6, empresa.getSenha());
			
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
		empresa = (EmpresaTO) obj;
		String sql = "UPDATE T_DF_EMPRESA SET nm_fantasia = ?, nm_razao_social = ?, nr_cnpj = ?, ds_login = ?, ds_senha = ? WHERE id_empresa = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, empresa.getNmFantasia());
			ps.setString(2, empresa.getRzSocial());
			ps.setLong(3, empresa.getCnpj());
			ps.setString(4, empresa.getLogin());
			ps.setString(5, empresa.getSenha());
			ps.setInt(6, empresa.getIdEmpresa());
			
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
		empresa = (EmpresaTO) obj;
		String sql = "DELETE FROM T_DF_EMPRESA WHERE id_empresa = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empresa.getIdEmpresa());
			
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
	
	public ArrayList<EmpresaTO> listaEmpresas() {
		String sql = "SELECT * FROM T_DF_EMPRESA";
		ArrayList<EmpresaTO> empresas = new ArrayList<EmpresaTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idEmp = rs.getInt(1);
				String nmFantasia = rs.getString(2);
				String rzSocial = rs.getString(3);
				long cnpj = rs.getLong(4);
				String login = rs.getString(5);
				String senha = rs.getString(6);
				empresas.add(new EmpresaTO(idEmp, cnpj, nmFantasia, rzSocial, login, senha));
			}
			Conexao.fechaConexao(con);
			return empresas;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public EmpresaTO listaEmpresa(int id) {
		String sql = "SELECT * FROM T_DF_EMPRESA WHERE id_empresa = ?";
		EmpresaTO empresa = new EmpresaTO();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idEmp = rs.getInt(1);
				String nmFantasia = rs.getString(2);
				String rzSocial = rs.getString(3);
				long cnpj = rs.getLong(4);
				String login = rs.getString(5);
				String senha = rs.getString(6);
				empresa = new EmpresaTO(idEmp, cnpj, nmFantasia, rzSocial, login, senha);
			}
			Conexao.fechaConexao(con);
			return empresa;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public EmpresaTO login(EmpresaTO emp) {
		String sql = "SELECT * FROM T_DF_EMPRESA WHERE ds_login = ? and ds_senha = ?";
		EmpresaTO empresa = new EmpresaTO();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, emp.getLogin());
			ps.setString(2, emp.getSenha());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idEmp = rs.getInt(1);
				String nmFantasia = rs.getString(2);
				String rzSocial = rs.getString(3);
				long cnpj = rs.getLong(4);
				String login = rs.getString(5);
				String senha = rs.getString(6);
				empresa = new EmpresaTO(idEmp, cnpj, nmFantasia, rzSocial, login, senha);
			}
			Conexao.fechaConexao(con);
			return empresa;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
