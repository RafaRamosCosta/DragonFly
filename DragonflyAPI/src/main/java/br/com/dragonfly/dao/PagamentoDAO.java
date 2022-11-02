package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		String sql = "INSERT INTO T_DF_PAGAMENTO(id_pagto, id_pedido, id_forma_pagto, id_empresa, dt_pagto, vl_total)"
				+ "VALUES(?, ?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, null);
			ps.setInt(2, pagamento.getPedido().getIdPedido());
			ps.setInt(3, pagamento.getFormaPagto().getIdFormaPagto());
			ps.setInt(4, pagamento.getEmpresa().getIdEmpresa());
			ps.setString(5, pagamento.getDtPagto());
			ps.setFloat(6, pagamento.getVlTotal());

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
				return "Erro ao alterado!";
			}
		} catch (Exception e) {
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
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public ArrayList<PagamentoTO> listarPagamentos() {
		String sql = "SELECT * FROM T_DF_PAGAMENTO";
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
				pagamentos.add(new PagamentoTO(idPagamento, formaPagto, empresa, pedido, vlTotal, dtPagto));
			}

			Conexao.fechaConexao(con);
			return pagamentos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public PagamentoTO listarPagamento(int id) {
		String sql = "SELECT * FROM T_DF_PAGAMENTO WHERE id_pagto = ?";
		PagamentoTO pagamento = new PagamentoTO();
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
				pagamento = new PagamentoTO(idPagamento, formaPagto, empresa, pedido, vlTotal, dtPagto);
			}

			Conexao.fechaConexao(con);
			return pagamento;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
