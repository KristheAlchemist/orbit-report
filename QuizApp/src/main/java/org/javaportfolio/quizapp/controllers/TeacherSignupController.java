package org.javaportfolio.quizapp.controllers;

import org.javaportfolio.quizapp.models.Teacher;
import org.javaportfolio.quizapp.models.data.TeacherRepository;
import org.javaportfolio.quizapp.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class TeacherSignupController {

    @Autowired
    TeacherRepository teacherRepository;

    private static final String userSessionKey = "teacher";

    @GetMapping("/signup")
    public String displaySignUpForm(Model model) {
        model.addAttribute("title", "Sign Up");
        model.addAttribute("heading", "Registration");
        model.addAttribute(new RegisterFormDTO());
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignUpForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO, Errors errors, HttpServletRequest request, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Sign Up");
            model.addAttribute("heading", "Registration");
            return "signup";
        }

        Teacher existingTeacher = teacherRepository.findByEmail(registerFormDTO.getEmail());

        if (existingTeacher != null) {
            errors.rejectValue("email", "email.alreadyexists", "A user with that email address already exists");
            model.addAttribute("title", "Sign Up");
            model.addAttribute("heading", "Registration");
            return "signup";
        }

        String password = registerFormDTO.getPassword();
        String verifyPassword = registerFormDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("verifyPassword", "passwords.mismatch", "Passwords do not match");
            model.addAttribute("title", "Sign Up");
            model.addAttribute("heading", "Registration");
            return "signup";
        }

        Teacher newTeacher = new Teacher(registerFormDTO.getFirstName(), registerFormDTO.getLastName(), registerFormDTO.getEmail(), registerFormDTO.getPassword());
        teacherRepository.save(newTeacher);
        setUserInSession(request.getSession(), newTeacher);

        return "redirect:";
    }

    public Teacher getUserFromSession(HttpSession session) {
        Integer teacherId = (Integer) session.getAttribute(userSessionKey);
        if (teacherId == null) {
            return null;
        }

        Optional<Teacher> teacher = teacherRepository.findById(teacherId);

        if (teacher.isEmpty()) {
            return null;
        }

        return teacher.get();
    }

    protected static void setUserInSession(HttpSession session, Teacher teacher) {
        session.setAttribute(userSessionKey, teacher.getUserId());
    }

}
