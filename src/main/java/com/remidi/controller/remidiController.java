package com.remidi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.remidi.entity.User;
import com.remidi.repository.UserRepository;
import com.remidi.service.UserService;

import jakarta.transaction.Transactional;

@Controller 
public class remidiController  {

	@Autowired
    private UserService userService;
	
	@Autowired
	private UserRepository userRepository;


        @RequestMapping(value="/index", method=RequestMethod.GET)
        public String loadForm(Model model) {

            model.addAttribute("user", new User());
            return "index";
        }
        
        @RequestMapping(value="/membros", method=RequestMethod.GET)
        public String loadMembros(Model model) {

            model.addAttribute("user", new User());
            return "membros";
        }
        
       /* @RequestMapping(value="/home", method=RequestMethod.GET)
        public String loadHome(Model model) {
            model.addAttribute("user", new User());

            // Adicionar a lista de aniversariantes ao modelo
            List<User> aniversariantes = userService.getAniversariantes();
            model.addAttribute("aniversariantes", aniversariantes);
            System.out.println(aniversariantes);
            
            return "home";
        }*/
        @RequestMapping(value="/home")
    	public ModelAndView listaLivros(){
    		ModelAndView mv = new ModelAndView("home");
    		Iterable<User> user = userRepository.findAll();
    		mv.addObject("home", user);
    		return mv;
    	}
        
        @GetMapping("/api/aniversariantes")
        public List<User> getAniversariantes() {
            return userService.getAniversariantes();
        }

           
        @RequestMapping(value="/cadastrar", method=RequestMethod.GET)
        public String loadCadastrar(Model model) {

            model.addAttribute("user", new User());
            return "cadastro2";
        }

    
    @PostMapping("/cadastrar/persist")
    @Transactional
    public String registerUser(@ModelAttribute User user) {
    	System.out.println(user.getConfirmSenha()+ user.getDataNascimento()+ user.getEmail()+ user.getFreqRemidi()+ user.getPrimeiroNome()+ user.getSobrenome()+ user.getSenha());
        userService.save(user);
        return "redirect:/index"; // Redirecionar para uma página de sucesso ou outra página
    }
    
    @PostMapping("/index/auth")
    public String loginUser(@RequestParam String email, @RequestParam String senha, Model model) {
        User user = userService.findByEmailAndPassword(email, senha);
        if (user != null) {
            // Credenciais válidas
            return "redirect:/home"; // Redirecionar para a página inicial ou outra página segura
        } else {
            // Credenciais inválidas
            model.addAttribute("error", "Credenciais inválidas");
            return "index"; // Retornar para a página de login com mensagem de erro
        }
    }
    

}
