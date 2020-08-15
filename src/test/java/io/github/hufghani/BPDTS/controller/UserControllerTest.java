package io.github.hufghani.bpdts.controller;


import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.github.hufghani.bpdts.enity.User;
import io.github.hufghani.bpdts.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  UserService userService;

  @Test
  void testGetAllUsers() throws Exception {
    List<User> users = new ArrayList<>();
    users.add(new User(1, "Bob", "Smith", "bob.smith@test.com", "192.57.232.111", 51.509865,
        -0.118092));
    users.add(new User(2, "James", "Smith", "James.smith@test.com", "192.57.50.111", 34.001135,
        -117.722861));
    users.add(new User(3, "will", "Smith", "will.smith@test.com", "192.57.50.11", 51.509865,
        -0.118092));
    String expected =
        "[{\"id\":1,\"first_name\":\"Bob\",\"last_name\":\"Smith\",\"email\":\"bob.smith@test.com\",\"ip_address\":\"192.57.232.111\",\"latitude\":51.509865,\"longitude\":-0.118092},"
            + "{\"id\":2,\"first_name\":\"James\",\"last_name\":\"Smith\",\"email\":\"James.smith@test.com\",\"ip_address\":\"192.57.50.111\",\"latitude\":34.001135,\"longitude\":-117.722861},"
            + "{\"id\":3,\"first_name\":\"will\",\"last_name\":\"Smith\",\"email\":\"will.smith@test.com\",\"ip_address\":\"192.57.50.11\",\"latitude\":51.509865,\"longitude\":-0.118092}]";

    when(userService.getAllUsers()).thenReturn(users);
    this.mockMvc.perform(MockMvcRequestBuilders.get("/users")).andExpect(status().isOk())
        .andExpect(content().string(containsString(expected)));
  }
  @Test
  void testGetAllLondonUsers() throws Exception {
    List<User> users = new ArrayList<>();
    users.add(new User(1, "Bob", "Smith", "bob.smith@test.com", "192.57.232.111", 51.509865,
        -0.118092));
    users.add(new User(2, "will", "Smith", "will.smith@test.com", "192.57.50.11", 51.509865,
        -0.118092));
    String expected = "[{\"id\":1,\"first_name\":\"Bob\",\"last_name\":\"Smith\",\"email\":\"bob.smith@test.com\",\"ip_address\":\"192.57.232.111\",\"latitude\":51.509865,\"longitude\":-0.118092},"
        + "{\"id\":2,\"first_name\":\"will\",\"last_name\":\"Smith\",\"email\":\"will.smith@test.com\",\"ip_address\":\"192.57.50.11\",\"latitude\":51.509865,\"longitude\":-0.118092}]";

    when(userService.getUserFromLondon()).thenReturn(users);
    this.mockMvc.perform(MockMvcRequestBuilders.get("/london/users")).andExpect(status().isOk()).andExpect(content().string(containsString(expected)));
  }

  @Test
  void testGetAllLondonUsersByDistance() throws Exception {
    List<User> users = new ArrayList<>();
    users.add(new User(1, "Bob", "Smith", "bob.smith@test.com", "192.57.232.111", 51.509865,
        -0.118092));
    users.add(new User(3, "will", "Smith", "will.smith@test.com", "192.57.50.11", 51.509865,
        -0.118092));

    String expected = "[{\"id\":1,\"first_name\":\"Bob\",\"last_name\":\"Smith\",\"email\":\"bob.smith@test.com\",\"ip_address\":\"192.57.232.111\",\"latitude\":51.509865,\"longitude\":-0.118092},"
        + "{\"id\":3,\"first_name\":\"will\",\"last_name\":\"Smith\",\"email\":\"will.smith@test.com\",\"ip_address\":\"192.57.50.11\",\"latitude\":51.509865,\"longitude\":-0.118092}]";

    when(userService.getLondonUsersByDistance(1)).thenReturn(users);
    this.mockMvc.perform(MockMvcRequestBuilders.get("/london/users/distance/1")).andExpect(status().isOk()).andExpect(content().string(containsString(expected)));
  }

  @Test
  void testGetUserById() throws Exception{
    User user = new User(1, "Bob", "Smith", "bob.smith@test.com", "192.57.232.111", 51.509865,
        -0.118092);
    String expected = "{\"id\":1,\"first_name\":\"Bob\",\"last_name\":\"Smith\",\"email\":\"bob.smith@test.com\",\"ip_address\":\"192.57.232.111\",\"latitude\":51.509865,\"longitude\":-0.118092}";

    when(userService.getUserById(1)).thenReturn(user);
    this.mockMvc.perform(MockMvcRequestBuilders.get("/user/1")).andExpect(status().isOk()).andExpect(content().string(containsString(expected)));

  }
}