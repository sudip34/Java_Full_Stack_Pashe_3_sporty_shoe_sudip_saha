package com.phase3.sportyshoes.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phase3.sportyshoes.entity.Shoes;
import com.phase3.sportyshoes.entity.Users;
import com.phase3.sportyshoes.service.ProductsService;
import com.phase3.sportyshoes.service.ShoesService;
import com.phase3.sportyshoes.service.UsersService;


@Controller
@RequestMapping("/user")
public class SprotshoeController {
	
	@Autowired
	private ShoesService shoesService;
	
	@Autowired
	private ProductsService productsServcie;
	
	@Autowired
	private UsersService usersService;

	
	// =============================MVC Methods==========================

		// add Mapping for Get/Users
		@GetMapping("/list")
		public String listUsers(Model theModel) {
			//get the user list
			List<Users> listUsers = usersService.findAll();
			
			//add list to the model
			theModel.addAttribute("userList", listUsers);

			return "users/usersHtml";
		}
		
		
		// add Mapping for search Users
		@GetMapping("/searchUser")
		public String sreachByUsername(@RequestParam("username") String username, Model theModel) {
			List<Users> users=usersService.sreachByUsername(username);
			theModel.addAttribute("userList", users);
			return "users/usersHtml";
		}
		
		// add Mapping for Get/Shoes
		
		@GetMapping("/shoes")
		public String listShoes(Model theModel){
			
			List<Shoes> listShoes= shoesService.findAll();

			//add list to the model
			theModel.addAttribute("shoeList", listShoes);

			return "users/shoesHtml";
		}
		
	
	@GetMapping("/search")
	public String purchaseDetailsByDate(@RequestParam("date") String date, Model theModel){
	
		List<Object> objects = usersService.findUsersAndShoesByDate(date);
	
		
		theModel.addAttribute("purchaseDeatails",objects);
		
		return "users/purchaseDetails";
	}
	
	@GetMapping("/searchByCategory")
	public String purchaseDetailsByCategory(@RequestParam("category") String category, Model theModel){
	
		List<Object> objects = usersService.searchByCategory(category);
	
		
		theModel.addAttribute("purchaseDeatails2",objects);
		
		return "users/purchaseDetails2";
	}
	

	
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// now as we want to add an Shoe so we have to instantiate an Shoe object
		
		Shoes theShoe = new Shoes();
		
		// add the Shoe obj to the Model obj
		
		theModel.addAttribute("shoe", theShoe);
		
		return "users/addShoes-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("shoesId") int theId, Model theModel) {
		
		// get the shoe form the service
		Shoes theShoe = shoesService.findById(theId);
		
		//set the shoe as a model attribute to pre-populate the form
		theModel.addAttribute("shoe", theShoe);
		
		//send over to addShoe-form
		return "users/addShoes-form";

	}
	
	
	@PostMapping("/save")
	public String saveShoe(@ModelAttribute("shoe") Shoes theShoe) {
		
		
		// save the shoe
		shoesService.save(theShoe);
		
		// use a redirect to prevent a duplicate submission
		return "redirect:/user/shoes";
	}
	
	@GetMapping("/delete")
	public String deleteShoe(@RequestParam("shoesId") int theId) {
		
		shoesService.deleteById(theId);
		
		
		return "redirect:/user/shoes";
	}
	
	
	
	
	
	
	
	
	@GetMapping("/home")
	public String home() {
		return "users/homepage";
	}
	@GetMapping("/manager")
	public String admin() {
		return "This age is for manager";
	}
	

	

	
	
	
	
}

	
	
	

