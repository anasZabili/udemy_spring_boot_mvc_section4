package com.anas.springbootmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
  @RequestMapping("/")
  public String home() {
    System.out.println("Home page requested");
    return "index";
  }

  @RequestMapping("add")
  // spring boot inject lobjet httpserver
  // RequestParam inject le variable d'identifant nb1
  // recurperé dans l'url dans nb1
  public ModelAndView add(@RequestParam("nb1") int nb1, 
    @RequestParam("nb2")int nb2) {
      // , HttpSession session

    // le model view permet de factoriser le code
    // en prenant en parameter le nom de la vue souhaité
    // et les données
    ModelAndView mv = new ModelAndView();
    mv.setViewName("result");

    int res = nb1 + nb2;
    mv.addObject("res", res);

    // set attibut met dans les variable de session
    // "res" de valeur res
    // session.setAttribute("res", res);

    // return "result.jsp";
    return mv;
  }
}
