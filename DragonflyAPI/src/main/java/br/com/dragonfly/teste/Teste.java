package br.com.dragonfly.teste;

import br.com.dragonfly.bo.ContatoEmpresaBO;
import br.com.dragonfly.bo.EmpresaBO;
import br.com.dragonfly.bo.EnderecoEmpresaBO;
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
		prod.setVlUnitario(10499.99f);
		
		ProdutoBO pBO = new ProdutoBO();
		System.out.println(pBO.excluiProduto(prod.getIdProduto()));
		
		
		EmpresaTO empresa = new EmpresaTO();
		empresa.setIdEmpresa(1);
		empresa.setRzSocial("Grupo GCB");
		empresa.setNmFantasia("GCB");
		empresa.setLogin("gcb");
		empresa.setSenha("12345");
		empresa.setCnpj(230439478);
		
//		EmpresaBO eBO = new EmpresaBO();
//		System.out.println(eBO.alteraEmpresa(empresa));
		
		
		EnderecoEmpresaTO endereco = new EnderecoEmpresaTO();
		endereco.setIdEndEmp(1);
		endereco.setEmpresa(empresa);
		endereco.setNmLog("Av. Chucri Zaidan");
		endereco.setNrLog(150);
		endereco.setNmBairro("Itaim Bibi");
		endereco.setZona("ZS");
//		EnderecoEmpresaBO eBO = new EnderecoEmpresaBO();
//		System.out.println(eBO.alteraEndereco(endereco));
		
		ContatoEmpresaTO contato = new ContatoEmpresaTO();
		contato.setIdContEmp(1);
		contato.setEmpresa(empresa);
		contato.setNrTelefone(991427364);
		contato.setEmailEmp("grupogcb@gcb.com.br");
//		ContatoEmpresaBO contBO = new ContatoEmpresaBO();
//		System.out.println(contBO.alteraContato(contato));
		
	PedidoTO pedido = new PedidoTO();
		pedido.setIdPedido(1);
		pedido.setProduto(prod);
		pedido.setEmpresa(empresa);
		pedido.setDtPedido("01/11/2022");
		pedido.setQtProduto(30);
		
//		PedidoBO pBO = new PedidoBO();
//		System.out.println(pBO.alteraPedido(pedido));
		
		
		FormaPagtoTO forma = new FormaPagtoTO();
		forma.setIdFormaPagto(1);
		forma.setNmFormaPagto("Cripto Moedas");
//		FormaPagtoBO fBO = new FormaPagtoBO();
//		System.out.println(fBO.cadastraFormaPagto(forma));
		
		PagamentoTO pagto = new PagamentoTO();
		pagto.setIdPagamento(1);
		pagto.setPedido(pedido);
		pagto.setFormaPagto(forma);
		pagto.setEmpresa(empresa);
		pagto.setDtPagto("01/11/2022");
		pagto.setVlTotal(314999.70f);
//		PagamentoBO pBO = new PagamentoBO();
//		System.out.println(pBO.alteraPagamento(pagto));
		
	}
}
