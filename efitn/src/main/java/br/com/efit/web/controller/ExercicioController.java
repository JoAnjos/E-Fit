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

import br.com.efit.dao.ExercicioDao;
import br.com.efit.domain.Exercicio;

@Controller
@RequestMapping("exercicio")
public class ExercicioController {

	@Autowired
	private ExercicioDao dao;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView listaTodos(ModelMap model) {
		model.addAttribute("exercicios", dao.getTodos());
		return new ModelAndView("/exe/list", model);
	}
	
	@GetMapping("/user")	
	public String colab() {
		return "redirect:/usuario/todos";
	}
	
	@GetMapping("/cadastro")
	public String cadastro(@ModelAttribute("exercicio") Exercicio exercicio, ModelMap model) {
		return "/exe/add";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("exercicio") Exercicio exercicio, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/exe/add";
		}
		dao.salvar(exercicio);
		attr.addFlashAttribute("message", "Exercício salvo com sucesso.");
		return "redirect:/exercicio/todos";
	}
	
	@GetMapping("/update/{id_exer}")
	public ModelAndView preUpdate(@PathVariable("id_exer") Long id, ModelMap model) {
		Exercicio exercicio = dao.getId(id);
		model.addAttribute("exercicio", exercicio);
		return new ModelAndView("/exe/add", model);
	}
	
	@PostMapping("/update")
	public ModelAndView update(@Valid @ModelAttribute("exercicio") Exercicio exercicio, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return new ModelAndView("/exe/add");
		}
		dao.editar(exercicio);
		attr.addFlashAttribute("message", "Exercício alterado com sucesso.");
		return new ModelAndView("redirect:/exercicio/todos");
	}
	
	
	@GetMapping("/delete/{id_exer}")
	public String delete(@PathVariable("id_exer") Long id, RedirectAttributes attr) {
		dao.excluir(id);
		attr.addFlashAttribute("message", "Exercício excluído com sucesso.");
		return "redirect:/exercicio/todos";
	}
}

