package dai.ifma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dai.ifma.model.Cliente;
import dai.ifma.repository.Clientes;

@Service
public class ClienteService {

	@Autowired
	private Clientes clientes;

	public void salvar(Cliente cliente) {
		clientes.save(cliente);
	}
}
