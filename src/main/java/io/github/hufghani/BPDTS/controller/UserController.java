package io.github.hufghani.bpdts.controller;

import io.github.hufghani.bpdts.enity.User;
import io.github.hufghani.bpdts.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("/london/users/distance/{distance}")
  public List <User> getAllLondonUsersByDistance(@PathVariable double distance){
    return userService.getLondonUsersByDistance(distance);
  }
  @GetMapping("/user/{id}")
  public User getUserById(@PathVariable("id") Integer id){
    return userService.getUserById(id);
  }
}
