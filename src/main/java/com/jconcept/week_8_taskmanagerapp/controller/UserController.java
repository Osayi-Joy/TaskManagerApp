package com.example.ToDoList.controller;

import com.example.ToDoList.entity.User;
import com.example.ToDoList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import java.util.logging.Logger;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Controller
public class UserController {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private UserService userService;

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/signup")
	public String showSignUpForm(Model model) {

		model.addAttribute("user", new User());

		return "signup_form";
	}

	@PostMapping("/process_signup")
	public String processRegistration(@Validated User user, Model model, HttpServletRequest request) throws Exception {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = user.getPassword();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		if (userService.findUserByEmail(user.getEmail()) != null) {
			model.addAttribute("registrationError", "User with this e-mail already exists.");
			return "/signup_form";
		}

		else {
			userService.save(user);
			try {
				request.login(user.getEmail(), password);
			} catch (ServletException e) {
				LOGGER.error("Error while login ", e);
			}
			return "redirect:/list";
		}
	}
}
