package com.univ;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.univ.user.model.User;

@Controller
public class MainController {

	@GetMapping("/")
	public String redirectToUniv() {
		return "redirect:/univ";
	}

	@GetMapping("/univ")
	public String showMainView(Model model, HttpSession session) {

		User user = (User) session.getAttribute("user");

//		if (user == null) {
//			return "redirect:/univ/user/sign_in";
//		}

		if (user.getType().equals("student")) {
			model.addAttribute("view", "main/main");
		} else if (user.getType().equals("professor")) {
			model.addAttribute("view", "main/profMain");
		}

		model.addAttribute("user", user);

		return "template/layout";
	}

	@GetMapping("/univ/admin")
	public String adminView(Model model) {
		model.addAttribute("view", "admin/main");
		model.addAttribute("type", "admin");

		return "template/layout";
	}

	@GetMapping("/univ/admin/add_course")
	public String addCourseView(Model model) {
		model.addAttribute("view", "admin/addCourse");
		model.addAttribute("type", "admin");

		return "template/layout";
	}

	@GetMapping("/univ/citations")
	public String citationsView(Model model) {
		model.addAttribute("view", "main/citation");
		return "template/layout";
	}

}
