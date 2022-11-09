package br.com.dragonfly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.dragonfly.to.ItemPedidoTO;
import br.com.dragonfly.to.PedidoTO;
import br.com.dragonfly.to.ProdutoTO;

public class ItemPedidoDAO implements IDAO {
	private Connection con = null;
	private ItemPedidoTO itemPedido;

	public ItemPedidoDAO() {
		this.con = new Conexao().abreConexao();
	}

	public String inserir(Object obj) {
		itemPedido = (ItemPedidoTO) obj;
		String sql = "INSERT INTO T_DF_ITEM_PEDIDO(id_item_pedido, id_pedido, id_produto, qt_item_pedido) "
				+ "VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, null);
			ps.setInt(2, itemPedido.getPedido().getIdPedido());
			ps.setInt(3, itemPedido.getProduto().getIdProduto());
			ps.setInt(4, itemPedido.getQtItemPedido());
			
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
		itemPedido = (ItemPedidoTO) obj;
		String sql = "UPDATE T_DF_ITEM_PEDIDO SET qt_item_pedido = ?, WHERE id_item_pedido = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemPedido.getQtItemPedido());
			ps.setInt(2, itemPedido.getIdItemPedido());
			
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
		itemPedido = (ItemPedidoTO) obj;
		String sql = "DELETE FROM T_DF_ITEM_PEDIDO WHERE id_item_pedido = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemPedido.getIdItemPedido());
			
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
	
	public ArrayList<ItemPedidoTO> listaItens() {
		String sql = "SELECT * FROM T_DF_ITEM_PEDIDO";
		ArrayList<ItemPedidoTO> itens = new ArrayList<ItemPedidoTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idItemPedido = rs.getInt(1);
				PedidoTO pedido = new PedidoTO();
				pedido.setIdPedido(rs.getInt(2));
				ProdutoTO produto = new ProdutoTO();
				produto.setIdProduto(rs.getInt(3));
				int qtItemProduto = rs.getInt(4);
				itens.add(new ItemPedidoTO(idItemPedido, pedido, produto, qtItemProduto));
			}
			Conexao.fechaConexao(con);
			return itens;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ItemPedidoTO listaItem(int id) {
		String sql = "SELECT * FROM T_DF_ITEM_PEDIDO WHERE id_item_pedido = ?";
		ItemPedidoTO item = new ItemPedidoTO();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idItemPedido = rs.getInt(1);
				PedidoTO pedido = new PedidoTO();
				pedido.setIdPedido(rs.getInt(2));
				ProdutoTO produto = new ProdutoTO();
				produto.setIdProduto(rs.getInt(3));
				int qtItemProduto = rs.getInt(4);
				item = new ItemPedidoTO(idItemPedido, pedido, produto, qtItemProduto);
			}
			Conexao.fechaConexao(con);
			return item;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
