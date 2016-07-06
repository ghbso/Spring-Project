package dai.ifma.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dai.ifma.model.Cidade;
import dai.ifma.model.Cliente;
import dai.ifma.model.Frete;
import dai.ifma.repository.Cidades;
import dai.ifma.repository.Clientes;
import dai.ifma.repository.Fretes;

@Service
public class FreteService {

	private final Integer TAXA_FRETE = 10;

	@Autowired
	private Cidades cidades;

	@Autowired
	private Clientes clientes;

	@Autowired
	private Fretes fretes;

	public Cidade primeiraCidade() {
		List<Cidade> cidadeList = cidades.findAll();
		if (cidadeList.size() > 0) {
			return cidadeList.get(0);
		}
		return null;
	}

	public BigDecimal calculaValorTotal(BigDecimal pesoTotal, BigDecimal valorTaxa) {
		BigDecimal valorFrete = valorTaxa.multiply(new BigDecimal(TAXA_FRETE.toString()));
		valorFrete = valorFrete.add(pesoTotal);
		return valorFrete;
	}

	public List<Cidade> todasCidades() {
		return cidades.findAll();
	}

	public Cliente primeiroCliente() {
		List<Cliente> clienteList = clientes.findAll();
		if (clienteList.isEmpty()){
			return null;
		}
		return clienteList.get(0);
	}

	public List<Cliente> todosClientes() {
		return clientes.findAll();
	}

	public void salvar(Frete frete) {
		fretes.save(frete);
	}

	public Cidade buscarCidadePor(Long codigoCidade) {
		return cidades.findOne(codigoCidade);
	}

	public List<Frete> todosFretes() {
		return fretes.findAll();
	}
}
