package com.rs.app.util;

import com.rs.app.bean.EmailJSON;
import com.rs.app.bean.User;

public class EmailJSONUtil {
	
	public static EmailJSON setJSON(User user) {
		EmailJSON object = new EmailJSON();
		object.setUsername(user.getUsername());
		object.setEmail(user.getEmail());
		if(!user.getId().isEmpty()) 
			object.setUserId(user.getId());
		else object.setUserId("");
		object.setBody("");
		object.setSubject("");
		
		return object;
	}
}
