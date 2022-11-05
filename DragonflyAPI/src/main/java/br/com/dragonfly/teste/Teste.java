package br.com.dragonfly.teste;

import br.com.dragonfly.bo.ContatoEmpresaBO;
import br.com.dragonfly.bo.EmpresaBO;
import br.com.dragonfly.bo.EnderecoEmpresaBO;
import br.com.dragonfly.bo.FormaPagtoBO;
import br.com.dragonfly.bo.FuncionarioBO;
import br.com.dragonfly.bo.PagamentoBO;
import br.com.dragonfly.bo.PedidoBO;
import br.com.dragonfly.bo.ProdutoBO;
import br.com.dragonfly.dao.EnderecoEmpresaDAO;
import br.com.dragonfly.dao.FuncionarioDAO;
import br.com.dragonfly.to.ContatoEmpresaTO;
import br.com.dragonfly.to.EmpresaTO;
import br.com.dragonfly.to.EnderecoEmpresaTO;
import br.com.dragonfly.to.FormaPagtoTO;
import br.com.dragonfly.to.FuncionarioTO;
import br.com.dragonfly.to.PagamentoTO;
import br.com.dragonfly.to.PedidoTO;
import br.com.dragonfly.to.ProdutoTO;

public class Teste {
	public static void main(String[] args) {
		
		FuncionarioTO func = new FuncionarioTO();
		func.setIdFunc(12);
		func.setNmFunc("Leonardo Ramos Costa");
		func.setCpf(49985018877l);
		func.setDtNasc("04/03/2004");
		func.setLogin("lrc");
		func.setSenha("040304");
		
//		FuncionarioBO fBO = new FuncionarioBO();
//		System.out.println(fBO.excluirFuncionario(func.getIdFunc()));
		
		ProdutoTO prod = new ProdutoTO();
		prod.setIdProduto(2);
		prod.setNmProduto("Dragonfly DF30");
		prod.setDsProduto("Drone controlado por controle remoto, capacidade de carga de até 30kg.");
		prod.setStProduto("A");
		prod.setVlUnitario(6499.99f);
		
//		ProdutoBO pBO = new ProdutoBO();
//		System.out.println(pBO.excluiProduto(prod.getIdProduto()));
		
		
		EmpresaTO empresa = new EmpresaTO();
		empresa.setIdEmpresa(1);
		empresa.setRzSocial("IBM");
		empresa.setNmFantasia("IBM");
		empresa.setLogin("ibm");
		empresa.setSenha("27364");
		empresa.setCnpj(357234578);
		
//		EmpresaBO eBO = new EmpresaBO();
//		System.out.println(eBO.excluiEmpresa(empresa.getIdEmpresa()));
		
		
		EnderecoEmpresaTO endereco = new EnderecoEmpresaTO();
		endereco.setIdEndEmp(1);
		endereco.setEmpresa(empresa);
		endereco.setNmLog("Av. Chucri Zaidan");
		endereco.setNrLog(150);
		endereco.setNmBairro("Itaim Bibi");
		endereco.setZona("ZS");
//		EnderecoEmpresaBO endBO = new EnderecoEmpresaBO();
//		System.out.println(endBO.cadastraEndereco(endereco));
		
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
//		System.out.println(pBO.excluiPedido(pedido.getIdPedido()));
		
		
		FormaPagtoTO forma = new FormaPagtoTO();
		forma.setIdFormaPagto(2);
		forma.setNmFormaPagto("Boleto Banário");
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
