package com.mmsystem.property.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmsystem.property.model.User;
import com.mmsystem.property.service.MmsUserService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private MmsUserService mmsUserService;

	@GetMapping("test")
	public String test() {
		return "The result from Gosa";

	}

	/*
	 * @PostMapping("user-save") public boolean saveUser() { return
	 * true;//mmsUserService.saveUser(mmsUser);
	 * 
	 * }
	 */
	
	@PostMapping("user-save") 
	public boolean saveUser(@RequestBody User mmsUser){ 
		 return mmsUserService.saveUser(mmsUser);
	}
	
	@GetMapping("users-list")
	public List<User> allUsers() {
		return mmsUserService.getUsers();

	}

	@DeleteMapping("delete-user/{user_id}")
	public boolean deleteUser(@PathVariable("user_id") int user_id, User mmsUser) {
		mmsUser.setUserId(user_id);
		return mmsUserService.deleteUser(mmsUser);
	}

	@GetMapping("user/{user_id}")
	public User allUserByID(@PathVariable("user_id") int user_id, User mmsUser) {
		mmsUser.setUserId(user_id);
		return mmsUserService.getUserByID(mmsUser);

	}

	@PostMapping("update-user/{user_id}")
	public boolean updateUser(@RequestBody User user, @PathVariable("user_id") int user_id) {
		user.setUserId(user_id);
		return mmsUserService.updateUser(user);
	}
}
