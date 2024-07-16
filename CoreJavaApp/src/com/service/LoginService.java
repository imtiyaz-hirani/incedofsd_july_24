package com.service;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class LoginService {
	Map<String, String> map = new LinkedHashMap<>();
	
	{
		map.put("harry@gmail.com", "potter@123"); 
		map.put("ronald@gmail.com", "weasley@123"); 
		map.put("hermione@gmail.com", "granger@123"); 
	}

	public boolean validateCredentials(String username, String password) {
		//check if username-key is present in Map? 
		
		if(map.containsKey(username)) {
			//fetch the password: value on the basis of username: key 
			String passValue = map.get(username);
			if(passValue.equals(password))
				return true; 
		}
		return false;
	}
	
	
}
