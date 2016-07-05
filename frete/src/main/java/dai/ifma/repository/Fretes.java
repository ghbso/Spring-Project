package dai.ifma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dai.ifma.model.Cidade;
import dai.ifma.model.Cliente;
import dai.ifma.model.Frete;

@Repository
public interface Fretes extends JpaRepository<Frete, Long> {

}
