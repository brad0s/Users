package com.brados.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.brados.model.Answer;
import com.brados.model.Quiz;
import com.brados.model.User;
import com.brados.service.QuizService;
import com.brados.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("userManager")
	private UserService userService;
	
	@Autowired
	@Qualifier("quizManager")
	private QuizService quizService;
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		String formattedDate = dateFormat.format(date);
		List<User> users = userService.getAllUsers();
		for (User user : users) {
			logger.info(user.getUser_name());
		}
		model.addAttribute("userList", users);
//		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	/**
	 * Form used to create a new user to add into the db
	 * @param model adds a new user object to the model
	 * @return addUser.jsp
	 */
	@RequestMapping(value="/addUser", method =  RequestMethod.GET)
	public String getAddUser(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	}
	
	/**
	 * Adds user object into db
	 * @param user passes user object from view to controller to add the user into the db
	 * @param model ?
	 * @return redirect to homepage
	 */
	@RequestMapping(value="/addUser", method = RequestMethod.POST)
	public String postGetUser (@ModelAttribute("user")User user, Model model){
		userService.addUser(user);
		return "redirect:/";
	}
	
	/**
	 * Delete user from database by their unique id
	 * @param userId unique id of user
	 * @return redirect to homepage
	 */
	@RequestMapping(value="/deleteUser/{userId}", method = RequestMethod.GET)
	public String getDeleteUser(@PathVariable int userId) {
		userService.deleteUser(userId);
		return "redirect:/";
	}
	
	/**
	 * Form used to edit a user
	 * @param userId unique id of user
	 * @param model user object to be used on view
	 * @return editUser.jsp
	 */
	@RequestMapping(value="/editUser/{userId}", method = RequestMethod.GET)
	public String editUser(@PathVariable int userId, Model model) {
		//System.out.println("userId: " + userId);
		User user = userService.getUserById(userId);
		model.addAttribute("user", user);
		return "editUser";
	}
	
	/**
	 * Updates the user in the db
	 * @param newUser edited user objet to be updated in the db
	 * @param model ?
	 * @return redirect to homepage
	 */
	@RequestMapping(value="/editUser/{userId}", method=RequestMethod.POST)
	public String editUserSubmit(@ModelAttribute("user") User newUser, Model model) {
		userService.updateUser(newUser);
		return "redirect:/";
	}
	
	/**
	 * Form to create a new quiz
	 * @param model adds user to view
	 * @param name is the name of the user
	 * @return
	 */
	@RequestMapping(value = "/createQuiz", method = RequestMethod.GET)
	public String getCreateQuiz(Model model, @RequestParam("name") String name) {
		User user = new User();
		user.setUser_name(name);
		//userService.save(user);
		model.addAttribute("user", user);
		model.addAttribute("quiz", new Quiz());
		return "createQuiz";
	}
	
	@RequestMapping(value = "/createQuiz", method =RequestMethod.POST)
	public String postCreateQuiz(@ModelAttribute("quiz") Quiz quiz, Model model) {
		System.out.println(quiz.toString());
		quizService.addQuiz(quiz);
//		for (Answer answer : quiz.getAnswers()) {
//		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(Model model) {
		return "login";
	}
	
	@RequestMapping(value ="/register", method = RequestMethod.GET)
	public String getRegisterPage(Model model) {
		return "register";
	}
	
}
