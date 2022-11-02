package br.com.dragonfly.teste;

import br.com.dragonfly.bo.ContatoEmpresaBO;
import br.com.dragonfly.bo.EmpresaBO;
import br.com.dragonfly.bo.FormaPagtoBO;
import br.com.dragonfly.bo.PagamentoBO;
import br.com.dragonfly.bo.PedidoBO;
import br.com.dragonfly.bo.ProdutoBO;
import br.com.dragonfly.dao.EnderecoEmpresaDAO;
import br.com.dragonfly.to.ContatoEmpresaTO;
import br.com.dragonfly.to.EmpresaTO;
import br.com.dragonfly.to.EnderecoEmpresaTO;
import br.com.dragonfly.to.FormaPagtoTO;
import br.com.dragonfly.to.PagamentoTO;
import br.com.dragonfly.to.PedidoTO;
import br.com.dragonfly.to.ProdutoTO;

public class Teste {
	public static void main(String[] args) {
		
		ProdutoTO prod = new ProdutoTO();
		prod.setIdProduto(1);
		prod.setNmProduto("Dragonfly DF90");
		prod.setDsProduto("Drone com IA e alta velociadade");
		prod.setStProduto("A");
		prod.setVlUnitario(1599.99f);
		
//		ProdutoBO pBO = new ProdutoBO();
//		System.out.println(pBO.cadastraProduto(prod));
		
		
		EmpresaTO empresa = new EmpresaTO();
		empresa.setIdEmpresa(1);
		empresa.setRzSocial("Grupo GCB");
		empresa.setNmFantasia("GCB");
		empresa.setLogin("gcb");
		empresa.setSenha("54321");
		empresa.setCnpj(1234567890);
		
//		EmpresaBO eBO = new EmpresaBO();
//		System.out.println(eBO.cadastraEmpresa(empresa));
		
		
//		EnderecoEmpresaTO endereco = new EnderecoEmpresaTO();
//		endereco.setIdEndEmp(1);
//		endereco.setEmpresa(empresa);
//		endereco.setNmLog("Av. Berrini");
//		endereco.setNrLog(199);
//		endereco.setNmBairro("Itaim Bibi");
//		endereco.setZona("ZS");
//		EnderecoEmpresaDAO endDAO = new EnderecoEmpresaDAO();
//		System.out.println(endDAO.inserir(endereco));
		
//		ContatoEmpresaTO contato = new ContatoEmpresaTO();
//		contato.setEmpresa(empresa);
//		contato.setNrTelefone(999999999);
//		contato.setEmailEmp("grupogcb@gmail.com");
//		ContatoEmpresaBO contBO = new ContatoEmpresaBO();
//		System.out.println(contBO.cadastraContato(contato));
		
	PedidoTO pedido = new PedidoTO();
		pedido.setIdPedido(1);
		pedido.setProduto(prod);
		pedido.setEmpresa(empresa);
		pedido.setDtPedido("01/11/2022");
		pedido.setQtProduto(40);
		
//		PedidoBO pBO = new PedidoBO();
//		System.out.println(pBO.cadastraPedido(pedido));
		
		
		FormaPagtoTO forma = new FormaPagtoTO();
		forma.setIdFormaPagto(1);
		forma.setNmFormaPagto("Cripto Moedas");
//		FormaPagtoBO fBO = new FormaPagtoBO();
//		System.out.println(fBO.cadastraFormaPagto(forma));
		
		PagamentoTO pagto = new PagamentoTO();
		pagto.setPedido(pedido);
		pagto.setFormaPagto(forma);
		pagto.setEmpresa(empresa);
		pagto.setDtPagto("01/11/2022");
		pagto.setVlTotal(63999.60f);
		PagamentoBO pBO = new PagamentoBO();
		System.out.println(pBO.cadastraPagamento(pagto));
		
	}
}
