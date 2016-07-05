package dai.ifma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dai.ifma.model.Cidade;
import dai.ifma.repository.Cidades;

@Service
public class CidadeService {

	@Autowired
	private Cidades cidades;

	public void salvar(Cidade cidade) {
		cidades.save(cidade);	
	}
}
