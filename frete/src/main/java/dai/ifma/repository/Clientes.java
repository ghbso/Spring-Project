package dai.ifma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dai.ifma.model.Cliente;

@Repository
public interface Clientes extends JpaRepository<Cliente, Long> {

}
