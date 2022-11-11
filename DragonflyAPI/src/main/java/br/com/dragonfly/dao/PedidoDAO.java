package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.dragonfly.to.EmpresaTO;
import br.com.dragonfly.to.PedidoTO;


public class PedidoDAO {
	private Connection con = null;
	private PedidoTO pedido;
	
	public PedidoDAO() {
		this.con = new Conexao().abreConexao();
	}
	
	public String inserir(Object obj) {
		pedido = (PedidoTO) obj;
		String sql = "INSERT INTO T_DF_PEDIDO(id_pedido, id_empresa, dt_pedido) "
				+ "VALUES(?, ?, TO_DATE(?, 'DD/MM/YYYY'))";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, null);
			ps.setInt(2, pedido.getEmpresa().getIdEmpresa());
			ps.setString(3, pedido.getDtPedido());
			
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
		pedido = (PedidoTO) obj;
		String sql = "UPDATE T_DF_PEDIDO SET dt_pedido = ? WHERE id_pedido = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pedido.getDtPedido());
			ps.setInt(2, pedido.getIdPedido());
			
			if (ps.executeUpdate() > 0) {
				Conexao.fechaConexao(con);
				return "Alterado com sucesso!";
			} else {
				Conexao.fechaConexao(con);
				return "Erro ao alterado!";
			}
		} catch (SQLException e) {
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
		} catch (SQLException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public ArrayList<PedidoTO> listaPedidos() {
		String sql = "SELECT * FROM T_DF_PEDIDO ORDER BY 1";
		ArrayList<PedidoTO> pedidos = new ArrayList<PedidoTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idPedido = rs.getInt(1);
				EmpresaTO empresa = new EmpresaTO();
				empresa.setIdEmpresa(rs.getInt(2));
				String dtPedido = rs.getString(3);
				pedidos.add(new PedidoTO(idPedido, empresa, dtPedido));
			}
			Conexao.fechaConexao(con);
			return pedidos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<PedidoTO> listaPedidos(int id) {
		String sql = "SELECT * FROM T_DF_PEDIDO WHERE id_empresa = ? ORDER BY 1";
		ArrayList<PedidoTO> pedidos = new ArrayList<PedidoTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idPedido = rs.getInt(1);
				EmpresaTO empresa = new EmpresaTO();
				empresa.setIdEmpresa(rs.getInt(2));
				String dtPedido = rs.getString(3);
				pedidos.add(new PedidoTO(idPedido, empresa, dtPedido));
			}
			
			Conexao.fechaConexao(con);
			return pedidos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
