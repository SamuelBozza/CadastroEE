package com.estacio.CadastroEE.Controller;

import com.estacio.CadastroEE.Models.Produto;
import com.estacio.CadastroEE.Repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LojaController {
    @Autowired
    private LojaRepository lr;

    @RequestMapping(value = "/cadastrarProduto", method = RequestMethod.GET)
    public String form(){
        return "loja/formProduto";
    }

    @RequestMapping(value = "/cadastrarProduto", method = RequestMethod.POST)
    public String form(@ModelAttribute Produto produtos) {
        lr.save(produtos);
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String listaProdutos(Model model) {
        Iterable<Produto> produtos = lr.findAll();
        model.addAttribute("produtos", produtos);
        return "/index";
    }

    @RequestMapping("/deletarProduto")
    public String deletarProduto(@RequestParam int idProduto) {
        lr.deleteById(idProduto);
        return "redirect:/index";
    }
    @RequestMapping("/editarProduto")
    public String editarProduto(@RequestParam int idProduto, Model model) {
        Produto produto = lr.findById(idProduto);
        if (produto != null) {
            model.addAttribute("produto", produto);
            return "loja/formEditProduto";
        } else {
            return "redirect:/index";
        }
    }
    @RequestMapping(value = "/salvarProdutoEditado", method = RequestMethod.POST)
    public String salvarProdutoEditado(@ModelAttribute Produto produto) {
        lr.save(produto);
        return "redirect:/index";
    }
}
