package dai.ifma.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dai.ifma.model.Cidade;
import dai.ifma.model.Cliente;
import dai.ifma.service.CidadeService;

@Controller
@RequestMapping("/")
public class CidadeController {
	
	private static final String NOVA_CIDADE_VIEW = "CadastroCidade";
	
	@Autowired
	private CidadeService service;
	
	@RequestMapping
	public String cadastrarCidade(@ModelAttribute Cidade cidade) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(cidade);
		
		return NOVA_CIDADE_VIEW;
	}
	
	@ModelAttribute("todasUFs")
	public List<String> todasUFs(){
		List<String> ufs = Arrays.asList("MA","RJ");
		Collections.sort(ufs);
		return ufs;
	}

	@RequestMapping(method=RequestMethod.POST)
	public String salvar(@Validated Cidade cidade, 
			Errors errors,
			RedirectAttributes attributes){
		
		
		if(errors.hasErrors()){
			return NOVA_CIDADE_VIEW;
		}else{
			service.salvar(cidade);
			attributes.addFlashAttribute("msg", "Cidade cadastrada com sucesso!");
			return "redirect:/cidade";
		}
	}

	
}