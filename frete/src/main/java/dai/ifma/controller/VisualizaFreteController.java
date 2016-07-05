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
@RequestMapping("/visualiza-frete")

public class VisualizaFreteController {

	private static String VISUALIZA_FRETE_VIEW = "VisualizaFrete";

	@Autowired
	private FreteService service;

	@RequestMapping
	public String cadastrarFrete() {
			return VISUALIZA_FRETE_VIEW;
	}

	
	@ModelAttribute("fretes")
	public List<Frete> todosFretes() {
		return service.todosFretes();
	}
	
}