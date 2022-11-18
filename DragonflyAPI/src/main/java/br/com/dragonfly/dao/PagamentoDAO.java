package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.dragonfly.to.EmpresaTO;
import br.com.dragonfly.to.FormaPagtoTO;
import br.com.dragonfly.to.PagamentoTO;
import br.com.dragonfly.to.PedidoTO;

public class PagamentoDAO implements IDAO {
	private Connection con = null;
	private PagamentoTO pagamento;

	public PagamentoDAO() {
		this.con = new Conexao().abreConexao();
	}

	public String inserir(Object obj) {
		pagamento = (PagamentoTO) obj;
		String sql = "insert into t_df_pagamento(id_pagto, id_pedido, id_forma_pagto, id_empresa, dt_pagto, vl_total) "
				+ "SELECT NULL, " + "    PE.id_pedido, " + "    FP.id_forma_pagto, "
				+ "    E.id_empresa, " + "    TO_DATE(SYSDATE, 'DD/MM/YYYY'), "
				+ "    PR.vl_unitario*IP.qt_item_pedido as total "
				+ "FROM T_DF_PRODUTO PR INNER JOIN T_DF_ITEM_PEDIDO IP "
				+ "ON(PR.ID_PRODUTO = IP.ID_PRODUTO) INNER JOIN T_DF_PEDIDO PE "
				+ "ON(IP.ID_PEDIDO = PE.ID_PEDIDO) INNER JOIN T_DF_EMPRESA E "
				+ "ON(PE.id_empresa = E.id_empresa) INNER JOIN T_DF_FORMA_PAGAMENTO FP "
				+ "ON(FP.ID_FORMA_PAGTO = ?)" + "where e.id_empresa = (select max(id_empresa) from t_df_empresa) and pe.id_pedido = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pagamento.getFormaPagto().getIdFormaPagto());
			ps.setInt(2, pagamento.getPedido().getIdPedido());

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
		pagamento = (PagamentoTO) obj;
		String sql = "UPDATE T_DF_PAGAMENTO SET vl_total = ?, dt_pagto = ? WHERE id_pagto = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setFloat(1, pagamento.getVlTotal());
			ps.setString(2, pagamento.getDtPagto());
			ps.setInt(3, pagamento.getIdPagamento());

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
		pagamento = (PagamentoTO) obj;
		String sql = "DELETE FROM T_DF_PAGAMENTO WHERE id_pagto = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pagamento.getIdPagamento());

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

	public ArrayList<PagamentoTO> listarPagamentos() {
		String sql = "SELECT * FROM T_DF_PAGAMENTO ORDER BY 1";
		ArrayList<PagamentoTO> pagamentos = new ArrayList<PagamentoTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int idPagamento = rs.getInt(1);
				PedidoTO pedido = new PedidoTO();
				pedido.setIdPedido(rs.getInt(2));
				FormaPagtoTO formaPagto = new FormaPagtoTO();
				formaPagto.setIdFormaPagto(rs.getInt(3));
				EmpresaTO empresa = new EmpresaTO();
				empresa.setIdEmpresa(rs.getInt(4));
				String dtPagto = rs.getString(5);
				float vlTotal = rs.getFloat(6);
				pagamentos.add(new PagamentoTO(idPagamento, pedido, formaPagto, empresa, vlTotal, dtPagto));
			}

			Conexao.fechaConexao(con);
			return pagamentos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public PagamentoTO listarPagamento(int id) {
		String sql = "SELECT * FROM T_DF_PAGAMENTO WHERE id_pagto = ? ORDER BY 1";
		PagamentoTO pagamento = new PagamentoTO();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int idPagamento = rs.getInt(1);
				PedidoTO pedido = new PedidoTO();
				pedido.setIdPedido(rs.getInt(2));
				FormaPagtoTO formaPagto = new FormaPagtoTO();
				formaPagto.setIdFormaPagto(rs.getInt(3));
				EmpresaTO empresa = new EmpresaTO();
				empresa.setIdEmpresa(rs.getInt(4));
				String dtPagto = rs.getString(5);
				float vlTotal = rs.getFloat(6);
				pagamento = new PagamentoTO(idPagamento, pedido, formaPagto, empresa, vlTotal, dtPagto);
			}

			Conexao.fechaConexao(con);
			return pagamento;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
