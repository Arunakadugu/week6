package me.aruna.week6.Controller;
import me.aruna.week6.Entities.BankUserData;

import me.aruna.week6.Repositories.RoleRepository;
import me.aruna.week6.Repositories.TransactionRepository;
import me.aruna.week6.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
//    private UserService userService;
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TransactionRepository transactionRepository;


    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegistrationPages(Model model){
        model.addAttribute("userData", new BankUserData());
        return "registration";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String processRegistrationPages(@Valid @ModelAttribute("userData") BankUserData userData, BindingResult result, Model model){
        model.addAttribute("userData", userData);
        System.out.println(result.toString());
        if(result.hasErrors()){
            return "registration";
        }
        else{
//            userService.saveUserData(userData);
            model.addAttribute("message", "User Account Successfully Created");
        }
        return "index";
    }
    @RequestMapping("/")
    public String showMainPage(Principal p) {

        return "index";
    }

    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }
    @RequestMapping("/deposit")
    public String showDeposit(Model model)
    {
        model.addAttribute("title","Name");
        model.addAttribute("L","1");
        return "pageone";
    }


//    @GetMapping("/register")
//    public String showRegistrationPage(Model model)
//    {
//        model.addAttribute("userData",new UserData());
//        return "register";
//    }

    //    @PostMapping("/register")
//    public String processRegistrationPage(@Valid @ModelAttribute("userData") UserData userData,
//                                          BindingResult bindingresult, Model model)
//    {
//        model.addAttribute("userData", userData);
//        System.out.println(bindingresult);
//        if(bindingresult.hasErrors()){
//            return "registration";
//        }
//        else{
//            userService.saveUser(userData);
//            model.addAttribute("message", "User Account Successfully Created");
//        }
//        return "index";
//    }
    @RequestMapping("/pagetwo")
    public String showPageTwo(Model model)
    {
        model.addAttribute("title","Second Page");
        model.addAttribute("pagenumber","2");
        return "pagetwo";
    }

    @RequestMapping("/pagethree")
    public String showPageThree(Model model)
    {
        model.addAttribute("title","Third Page");
        model.addAttribute("pagenumber","3");
        return "pagethree";
    }


}


