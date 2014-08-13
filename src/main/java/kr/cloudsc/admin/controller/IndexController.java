package kr.cloudsc.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
@Controller
public class IndexController {

	public IndexController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value={"/","/index"})
	public String index(Model model){
		return "index";
	}

}
