package com.springapp.mvc.controllers;



import com.springapp.mvc.classes.User;
import com.springapp.mvc.data.DAO.HibernateDAO.HibernateUserDAO;
import com.springapp.mvc.data.service.InrerfaceService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String showMain(ModelMap model, @RequestParam(required = false) Integer page) {

		model.addAttribute("newUser", new User());
		HibernateUserDAO.Pages pages=userService.getUsersList(page == null ? 0 : page);


		model.addAttribute("users", pages.getUsers());
		model.addAttribute("pagesCount", pages.getPageCount());
		return "home";
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updatePage(@PathVariable long id){

		userService.deleteUser(id);
		return "redirect:/";
	}

	@RequestMapping(value = "addUser",method = RequestMethod.POST)
	public String addUser(@Valid User newUser, BindingResult bindingResult, ModelMap model, HttpServletResponse httpServletResponse){


		model.addAttribute("newUser", new User());
		if (bindingResult.hasErrors()){
			return "redirect:/";
		}

		newUser.setCreatedDate(new Date());
		userService.saveUser(newUser);
		return "redirect:/";
	}

	@RequestMapping(value = "updateUser", method = RequestMethod.GET, headers="Accept=application/json")
	public String updateUser(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer age, @RequestParam String isAdmin, @RequestParam String crDate, ModelMap model, HttpServletResponse httpServletResponse){
		httpServletResponse.setCharacterEncoding("UTF-8");

		model.addAttribute("newUser", new User());

		Date date=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		try {
			date=dateFormat.parse(crDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		boolean admin= isAdmin.equals("true");

		User user=new User();
		System.out.println(name);


		user.setId(id);
		user.setName(name);
		user.setAge(age);
		user.setIsAdmin(admin);
		user.setCreatedDate(date);

		System.out.println(user.getId() + " " + user.getName() + " " + user.getAge() + " " + user.getIsAdmin());
		userService.updateUser(user);
		return "redirect:/";
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String findUsers(@RequestParam(required = false)Integer page, @RequestParam String name, ModelMap modelMap, HttpServletResponse response) throws UnsupportedEncodingException {
		response.setCharacterEncoding("UTF-8");

		HibernateUserDAO.Pages pages=userService.findUsers(name, page==null?0:page);
		modelMap.addAttribute("name", name);
		modelMap.addAttribute("foundedUsers", pages.getUsers());
		modelMap.addAttribute("pageCount", pages.getPageCount());

		modelMap.addAttribute("newUser", new User());
		return "findPage";
	}

}