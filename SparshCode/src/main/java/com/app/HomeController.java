package com.app;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
     
	 @RequestMapping("/test")
	 @ResponseBody
	 public HashMap<String, String> test() {
		 HashMap<String, String> ob = new HashMap<>();
		 ob.put("StudentName", "Rohit");
		 ob.put("StudentClass", "PGDAC");
		 ob.put("StudentRoll No", "194");
		 
		 System.out.println("In homeController");
		 return ob;
	 }
}
