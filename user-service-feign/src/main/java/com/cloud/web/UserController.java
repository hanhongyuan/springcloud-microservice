package com.cloud.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.model.User;
import com.cloud.service.IUserService;

@RestController
@RequestMapping("/")
public class UserController {

    private final Logger logger = Logger.getLogger(getClass());

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
    	
    	String r = userService.add(a,b);
        return "From UserService, Result is " + r;
    }
    
    
    @Autowired
	IUserService userService;
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<User> readUserInfo(){
		List<User> ls=userService.searchAll();
		return ls;
	}

}