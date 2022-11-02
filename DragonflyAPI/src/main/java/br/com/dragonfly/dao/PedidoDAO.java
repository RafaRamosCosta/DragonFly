package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.dragonfly.to.EmpresaTO;
import br.com.dragonfly.to.PedidoTO;
import br.com.dragonfly.to.ProdutoTO;


public class PedidoDAO {
	private Connection con = null;
	private PedidoTO pedido;
	
	public PedidoDAO() {
		this.con = new Conexao().abreConexao();
	}
	
	public String inserir(Object obj) {
		pedido = (PedidoTO) obj;
		String sql = "INSERT INTO T_DF_PEDIDO(id_pedido, id_produto, id_empresa, dt_pedido, qt_produto) "
				+ "VALUES(?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, null);
			ps.setInt(2, pedido.getProduto().getIdProduto());
			ps.setInt(3, pedido.getEmpresa().getIdEmpresa());
			ps.setString(4, pedido.getDtPedido());
			ps.setInt(5, pedido.getQtProduto());
			
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
		pedido = (PedidoTO) obj;
		String sql = "UPDATE T_DF_PEDIDO SET dt_pedido = ?, qt_produto = ? WHERE id_pedido = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pedido.getDtPedido());
			ps.setInt(2, pedido.getQtProduto());
			ps.setInt(3, pedido.getIdPedido());
			
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
		pedido = (PedidoTO) obj;
		String sql = "DELETE FROM T_DF_PEDIDO WHERE id_pedido = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pedido.getIdPedido());
			
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
	
	public ArrayList<PedidoTO> listaPedidos() {
		String sql = "SELECT * FROM T_DF_PEDIDO";
		ArrayList<PedidoTO> pedidos = new ArrayList<PedidoTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idPedido = rs.getInt(1);
				ProdutoTO produto = new ProdutoTO();
				produto.setIdProduto(rs.getInt(2));
				EmpresaTO empresa = new EmpresaTO();
				empresa.setIdEmpresa(rs.getInt(3));
				String dtPedido = rs.getString(4);
				int qtPedido = rs.getInt(5);
				pedidos.add(new PedidoTO(idPedido, empresa, produto, dtPedido, qtPedido));
			}
			Conexao.fechaConexao(con);
			return pedidos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public PedidoTO listaPedido(int id) {
		String sql = "SELECT * FROM T_DF_PEDIDO WHERE id_pedido = ?";
		PedidoTO item = new PedidoTO();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idPedido = rs.getInt(1);
				ProdutoTO produto = new ProdutoTO();
				produto.setIdProduto(rs.getInt(2));
				EmpresaTO empresa = new EmpresaTO();
				empresa.setIdEmpresa(rs.getInt(3));
				String dtPedido = rs.getString(4);
				int qtPedido = rs.getInt(5);
				pedido = new PedidoTO(idPedido, empresa, produto, dtPedido, qtPedido);
			}
			
			Conexao.fechaConexao(con);
			return item;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
