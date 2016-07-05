package dai.ifma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dai.ifma.model.Cliente;
import dai.ifma.service.ClienteService;

@Controller
@RequestMapping("/cliente")

public class ClienteController {

	private static final String NOVO_CLIENTE_VIEW = "CadastroCliente";
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping
	public String cadastrarCliente(@ModelAttribute("cliente") Cliente cliente) {
		
		ModelAndView mv = new ModelAndView(NOVO_CLIENTE_VIEW);
		mv.addObject("cliente", cliente );
		
		return NOVO_CLIENTE_VIEW;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvar(@Validated Cliente cliente, 
			Errors erro, 
			RedirectAttributes attributes){
		
		if(erro.hasErrors()){
			return NOVO_CLIENTE_VIEW;
		}else{
			clienteService.salvar(cliente);
			attributes.addFlashAttribute("msg", "Cliente salvo com sucesso!");
			
			return "redirect:/cliente";

		}
		
	}
	
	
}