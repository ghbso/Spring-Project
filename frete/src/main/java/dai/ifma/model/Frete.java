package dai.ifma.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "Frete")
public class Frete {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotEmpty(message = "Descrição é obrigatório")
	private String descricao;

	@NotNull(message = "Peso é obrigatório")
	@DecimalMin(value = "0", message = "Peso não pode ser menor que 0")
	@NumberFormat(pattern = "0")
	private BigDecimal peso;

	@NotNull(message = "Valor Total é obrigatório")
	@DecimalMin(value = "0.00", message = "Valor não pode ser menor que 0,00")
	@NumberFormat(pattern = "#,##0.00")
	@Column(name="valor")
	private BigDecimal valorTotal;

	@ManyToOne
	@JoinColumn(name = "codigo_cliente")
	@NotNull(message = "Cliente é obrigatório")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "codigo_cidade")
	@NotNull(message = "Cidade é obrigatório")
	private Cidade cidade;
	
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	
	
}
