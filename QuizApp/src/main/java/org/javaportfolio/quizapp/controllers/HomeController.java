package org.javaportfolio.quizapp.controllers;

import org.javaportfolio.quizapp.models.Teacher;
import org.javaportfolio.quizapp.models.data.StudentRepository;
import org.javaportfolio.quizapp.models.data.TeacherRepository;
import org.javaportfolio.quizapp.models.dto.RegisterFormDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static org.javaportfolio.quizapp.controllers.TeacherSignupController.setUserInSession;

@Controller
public class HomeController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("")
    public String index(Model model) {
        return "home";
    }


    @GetMapping("login")
    public String displayLogInForm(Model model) {
        model.addAttribute("title", "Log In");
        model.addAttribute("heading", "Log In");
        model.addAttribute("signuptext", "If you don't have an account, click ");
        model.addAttribute("signuplink", "here.");
        model.addAttribute("email", "Email Address");
        model.addAttribute("password", "Password");
        model.addAttribute("button", "Log In");
        return "login";
    }

    @PostMapping("login")
    public String processLogInForm() {
        return "home";
    }
}