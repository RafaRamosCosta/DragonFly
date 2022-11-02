package br.com.dragonfly.bo;

import java.util.ArrayList;

import br.com.dragonfly.dao.PagamentoDAO;
import br.com.dragonfly.to.PagamentoTO;

public class PagamentoBO {
	private PagamentoDAO pDAO;
	
	public String cadastraPagamento(PagamentoTO pagamento) {
		pDAO = new PagamentoDAO();
		return pDAO.inserir(pagamento);
	}
	
	public String alteraPagamento(PagamentoTO pagamento) {
		pDAO = new PagamentoDAO();
		return pDAO.alterar(pagamento);
	}
	
	public String excluiPagamento(int id) {
		pDAO = new PagamentoDAO();
		PagamentoTO pagamento = new PagamentoTO();
		pagamento.setIdPagamento(id);
		return pDAO.excluir(pagamento);
	}
	
	public ArrayList<PagamentoTO> listaPagamentos() {
		ArrayList<PagamentoTO> pagamentos;
		pDAO = new PagamentoDAO();
		pagamentos = pDAO.listarPagamentos();
		return pagamentos;
	}
	
	public PagamentoTO listaPagamento(int id) {
		PagamentoTO pagamento;
		pDAO = new PagamentoDAO();
		pagamento = pDAO.listarPagamento(id);
		return pagamento;
	}
}
