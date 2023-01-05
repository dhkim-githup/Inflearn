package com.example.webstory.controller;

import com.example.webstory.service.PeopleService;
import com.example.webstory.vo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import javax.servlet.http.HttpServlet;


/**
 * Servlet implementation class PeopleList
 */
@Controller
public class PeopleList extends HttpServlet {

	@Autowired
	PeopleService peopleService;

	 @GetMapping("/PeopleList")
     public String doList(Model model){

		 List<People> list = peopleService.doSelect();

		 model.addAttribute("list", list );

		 return "/list";
	 }

}