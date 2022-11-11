package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.dragonfly.to.FuncionarioTO;

public class FuncionarioDAO implements IDAO {
	private Connection con;
	private FuncionarioTO func;

	public FuncionarioDAO() {
		this.con = new Conexao().abreConexao();
	}

	public String inserir(Object obj) {
		func = (FuncionarioTO) obj;
		String sql = "INSERT INTO T_DF_FUNCIONARIO(id_funcionario, nm_funcionario, nr_cpf, dt_nascimento, ds_login, ds_senha) VALUES (?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, null);
			ps.setString(2, func.getNmFunc());
			ps.setLong(3, func.getCpf());
			ps.setString(4, func.getDtNasc());
			ps.setString(5, func.getLogin());
			ps.setString(6, func.getSenha());

			if (ps.executeUpdate() > 0) {
				Conexao.fechaConexao(con);
				return "Inserido com sucesso!";
			} else {
				Conexao.fechaConexao(con);
				return "Erro ao inserir!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public String alterar(Object obj) {
		func = (FuncionarioTO) obj;
		String sql = "UPDATE T_DF_FUNCIONARIO SET  nm_funcionario = ?, nr_cpf = ?, dt_nascimento = ?, ds_login = ? , ds_senha = ? WHERE id_funcionario = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, func.getNmFunc());
			ps.setLong(2, func.getCpf());
			ps.setString(3, func.getDtNasc());
			ps.setString(4, func.getLogin());
			ps.setString(5, func.getSenha());
			ps.setInt(6, func.getIdFunc());

			if (ps.executeUpdate() > 0) {
				Conexao.fechaConexao(con);
				return "Alterado com sucesso!";
			} else {
				Conexao.fechaConexao(con);
				return "Erro ao alterar!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public String excluir(Object obj) {
		func = (FuncionarioTO) obj;
		String sql = "DELETE FROM T_DF_FUNCIONARIO WHERE id_funcionario = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, func.getIdFunc());

			if (ps.executeUpdate() > 0) {
				Conexao.fechaConexao(con);
				return "Excluído com sucesso!";
			} else {
				Conexao.fechaConexao(con);
				return "Erro ao excluir!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public ArrayList<FuncionarioTO> listaFuncs() {
		ArrayList<FuncionarioTO> funcs = new ArrayList<FuncionarioTO>();
		String sql = "SELECT * FROM T_DF_FUNCIONARIO";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int idFunc = rs.getInt(1);
				String nmFunc = rs.getString(2);
				long cpf = rs.getLong(3);
				String dtNasc = rs.getString(4);
				String login = rs.getString(5);
				String senha = rs.getString(6);
				funcs.add(new FuncionarioTO(idFunc, nmFunc, cpf, dtNasc, login, senha));
			}
			Conexao.fechaConexao(con);
			return funcs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public FuncionarioTO listaFuncs(int id) {
		String sql = "SELECT * FROM T_DF_FUNCIONARIO WHERE id_funcionario = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int idFunc = rs.getInt(1);
				String nmFunc = rs.getString(2);
				long cpf = rs.getLong(3);
				String dtNasc = rs.getString(4);
				String login = rs.getString(5);
				String senha = rs.getString(6);
				func = new FuncionarioTO(idFunc, nmFunc, cpf, dtNasc, login, senha);
			}
			Conexao.fechaConexao(con);
			return func;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public FuncionarioTO login(FuncionarioTO func) {
		String sql = "SELECT * FROM T_DF_FUNCIONARIO WHERE ds_login = ? and ds_senha = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, func.getLogin());
			ps.setString(2, func.getSenha());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int idFunc = rs.getInt(1);
				String nmFunc = rs.getString(2);
				long cpf = rs.getLong(3);
				String dtNasc = rs.getString(4);
				String login = rs.getString(5);
				String senha = rs.getString(6);
				func = new FuncionarioTO(idFunc, nmFunc, cpf, dtNasc, login, senha);
			}
			Conexao.fechaConexao(con);
			if (func.getIdFunc() != 0) {
				return func;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}
