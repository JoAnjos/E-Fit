package br.com.efit.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.efit.dao.UsuarioDao;
import br.com.efit.domain.Usuario;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioDao dao;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView listaTodos(ModelMap model) {
		model.addAttribute("usuarios", dao.getTodos());
		return new ModelAndView("/user/listUser", model);
	}
	
	@GetMapping("/exe")	
	public String colab() {
		return "redirect:/exercicio/todos";
	}
	
	
	@GetMapping("/cadastro")
	public String cadastro(@ModelAttribute("usuario") Usuario usuario, ModelMap model) {
		return "/user/addUser";
	}
	
	
	@GetMapping("/home")
	public String home(@ModelAttribute("usuario") Usuario usuario, ModelMap model) {
		return "/user/home";
	}
	
	@GetMapping("/listJunc")
	public String listJunc(@ModelAttribute("usuario") Usuario usuario, ModelMap model) {
		return "/user/listJunc";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/user/addUser";
		}
		dao.salvar(usuario);
		attr.addFlashAttribute("message", "Usuário cadastrado com sucesso.");
		return "redirect:/usuario/todos";
	}
	
	@GetMapping("/update/{id_user}")
	public ModelAndView preUpdate(@PathVariable("id_user") Long id, ModelMap model) {
		Usuario usuario = dao.getId(id);
		model.addAttribute("usuario", usuario);
		return new ModelAndView("/user/addUser", model);
	}
	
	@PostMapping("/update")
	public ModelAndView update(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return new ModelAndView("/user/addUser");
		}
		dao.editar(usuario);
		attr.addFlashAttribute("message", "Usuário modificado com sucesso.");
		return new ModelAndView("redirect:/usuario/todos");
	}
	
	
	@GetMapping("/delete/{id_user}")
	public String delete(@PathVariable("id_user") Long id, RedirectAttributes attr) {
		dao.excluir(id);
		attr.addFlashAttribute("message", "Usuário removido com sucesso.");
		return "redirect:/usuario/todos";
	}
}

