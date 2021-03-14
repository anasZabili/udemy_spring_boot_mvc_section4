package com.anas.springbootmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.anas.model.Alien;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	

  @RequestMapping("add")
  // spring boot inject lobjet httpserver
  // RequestParam inject le variable d'identifant nb1
  // recurperé dans l'url dans nb1
  // Model est une interface qui agit comme un model
  // de cette facon a na plus besoin d'utiliser l'objet model view
  public String add(@RequestParam("nb1") int nb1, 
    @RequestParam("nb2")int nb2, Model model) {
      // , HttpSession session

    // le model view permet de factoriser le code
    // en prenant en parameter le nom de la vue souhaité
    // et les données

    // passe le nom de la vue dans le constructeur
    // ou avec la methode setviewname est similaire
    // ModelAndView mv = new ModelAndView("result");
    // mv.setViewName("result");

    int res = nb1 + nb2;
    // mv.addObject("res", res);
    model.addAttribute("res", res);

    // set attibut met dans les variable de session
    // "res" de valeur res
    // session.setAttribute("res", res);

    // return "result.jsp";
    return "result";
  }

  @ModelAttribute
  // model attribut avant de call des request mapping
  // spring va contruit un model contenenant les valeur specifié dans le
  // notre model
  // ModelAttribut permet donc de set note model avec des valeur
  // predefini avant que sping fasse toute autre action
  public void modelData(Model m) {
    m.addAttribute("name", "Aliens");
  } 


  @RequestMapping("addAlien")
  // model cree une intance de alien avec les attribut set au valeur
  // recu en appelant les setter du meme nom que les attributs
  // utiliser cette action nous evite bcp d'etape en faisant ca on 
  // a pas besoin de recevoir les parametre avec lannotation requeste param
  // on na pas besoin d'intance alien, et pas nonplus besoin dutiliser les setter
  // le nom de l'attribut dans lequel est injecté la valeur dans la page est
  // soit le nom de la class, soi la nom de la variable
  // soit le nom precisé en parametre
  public String addAlien(@ModelAttribute("al") Alien alien) {

    return "result";
  }
}