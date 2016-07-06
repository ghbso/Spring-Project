package dai.ifma.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.qos.logback.core.net.SyslogOutputStream;
import dai.ifma.model.Cidade;
import dai.ifma.model.Cliente;
import dai.ifma.model.Frete;
import dai.ifma.service.FreteService;

@Controller
@RequestMapping("/frete")

public class FreteController {

	private static String FRETE_VIEW = "CadastroFrete";

	@Autowired
	private FreteService service;

	@RequestMapping
	public String cadastrarFrete(@ModelAttribute Frete frete) {

		ModelAndView modelAndView = new ModelAndView();
		Cidade cidade = service.primeiraCidade();
		Cliente cliente = this.service.primeiroCliente();

		if (cidade != null && cliente != null) {

			frete.setCidade(cidade);
			frete.setPeso(new BigDecimal("0"));
			frete.setValorTotal(service.calculaValorTotal(frete.getPeso(), cidade.getValorTaxa()));
			frete.setCliente(cliente);
			modelAndView.addObject(frete);
		}
		return FRETE_VIEW;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Frete frete, Errors error, RedirectAttributes attributes) {

		if (error.hasErrors()) {
			return FRETE_VIEW;
		} else {
			service.salvar(frete);
			attributes.addFlashAttribute("msg", "Frete salvo com sucesso");
			return "redirect:/frete";
		}

	}

	@ModelAttribute("render")
	public boolean isToRender() {
		Cidade cidade = service.primeiraCidade();
		Cliente cliente = this.service.primeiroCliente();
		if(cliente!=null && cidade!= null){
			return true;
		}
		return false;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody String calcular(@RequestParam(value = ("codigo")) Long codigoCidade,
			@RequestParam(value = ("pesoTotal")) BigDecimal pesoTotal) {

		Cidade cidade = service.buscarCidadePor(codigoCidade);
		BigDecimal taxaCidade = cidade.getValorTaxa();
		if (pesoTotal == null) {
			pesoTotal = new BigDecimal(0);
		}
		BigDecimal valorTotal = service.calculaValorTotal(pesoTotal, taxaCidade);
		String format = new DecimalFormat("0.00").format(valorTotal);
		return format;
	}

	@ModelAttribute("todasCidades")
	public List<Cidade> todasCidades() {
		return service.todasCidades();
	}

	@ModelAttribute("todosClientes")
	public List<Cliente> todosClientes() {
		return service.todosClientes();
	}

}