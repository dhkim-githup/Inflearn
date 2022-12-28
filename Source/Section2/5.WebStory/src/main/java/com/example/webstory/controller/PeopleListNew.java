package com.example.webstory.controller;


import com.example.webstory.service.PeopleServiceNew;
import com.example.webstory.vo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServlet;
import java.util.List;


/**
 * Servlet implementation class PeopleList
 */
@Controller
public class PeopleListNew extends HttpServlet {


	 @GetMapping("/PeopleListNew")
     public String doList(Model model){

		 PeopleServiceNew serviceNew = new PeopleServiceNew();

		 List<People> list = serviceNew.doSelect();

		 model.addAttribute("list", list );

		 return "/list";
	 }

}