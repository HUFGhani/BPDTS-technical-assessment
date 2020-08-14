package io.github.hufghani.bpdts.controller;

import io.github.hufghani.bpdts.enity.User;
import io.github.hufghani.bpdts.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @Autowired
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/london/users")
  public List <User> getAllLondonUsers(){
    return userService.getUserFromLondon();
  }
}
