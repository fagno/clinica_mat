package aula2403.controller;

import aula2403.model.entity.Veiculo;
import aula2403.model.repository.VeiculoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("veiculo")
public class VeiculoController {

    @Autowired
    VeiculoRepository repository;

    @GetMapping("/form")
    public ModelAndView form(Veiculo veiculo) {
        return new ModelAndView("veiculo/form");
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("veiculos", repository.veiculos());
        return new ModelAndView("/veiculo/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Veiculo veiculo, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView("/veiculo/form");
        }
        repository.save(veiculo);
        return new ModelAndView("redirect:/veiculo/list");
    }


}
