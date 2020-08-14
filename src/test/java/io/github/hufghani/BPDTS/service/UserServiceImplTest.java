package io.github.hufghani.bpdts.service;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import io.github.hufghani.bpdts.enity.User;
import io.github.hufghani.bpdts.feign.Client;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceImplTest {

  @Mock
  Client bpdtsClient;
  @InjectMocks
  UserServiceImpl userServiceImpl;


  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);

  }

  @Test
  void testGetAllUsers() {
    List<User> expected = new ArrayList<>();
    expected.add(new User(1, "Bob", "Smith", "bob.smith@test.com", "192.57.232.111", 51.509865,
        -0.118092));
    expected.add(new User(2, "James", "Smith", "James.smith@test.com", "192.57.50.111", 34.001135,
        -117.722861));
    expected.add(new User(3, "will", "Smith", "will.smith@test.com", "192.57.50.11", 51.509865,
        -0.118092));
    when(bpdtsClient.retrieveAllUsers()).thenReturn(expected);
    List<User> result = userServiceImpl.getAllUsers();
    System.out.println(result);
    Assertions.assertEquals(expected, result);
  }


  @Test
  void testGetUserFromLondon() {
    List<User> expected = new ArrayList<>();
    expected.add(new User(1, "Bob", "Smith", "bob.smith@test.com", "192.57.232.111", 51.509865,
        -0.118092));
    expected.add(new User(2, "will", "Smith", "will.smith@test.com", "192.57.50.11", 51.509865,
        -0.118092));
    when(bpdtsClient.retrieveLondonUsers()).thenReturn(expected);
    List<User> result = userServiceImpl.getUserFromLondon();
    System.out.println(result);
    Assertions.assertEquals(expected, result);
  }


  @Test
  void testGetLondonUsersByDistance() {
    List<User> expected = new ArrayList<>();
    expected.add(new User(1, "Bob", "Smith", "bob.smith@test.com", "192.57.232.111", 51.509865,
        -0.118092));
    expected.add(new User(2, "will", "Smith", "will.smith@test.com", "192.57.50.11", 51.509865,
        -0.118092));
    when(bpdtsClient.retrieveAllUsers()).thenReturn(expected);

    List<User> result = userServiceImpl.getLondonUsersByDistance(1);
    Assertions.assertEquals(expected, result);
    Assertions.assertEquals(expected.size(), result.size());
  }

  @Test
  void testGetUserById() {
    when(bpdtsClient.retrieveUsersById(anyInt())).thenReturn(
        new User(Integer.valueOf(0), "Bob", "Smith", "bob.smith@test.com", "192.57.232.111", 51.509865,
            -0.118092));

    User result = userServiceImpl.getUserById(Integer.valueOf(0));
    Assertions.assertEquals(
        new User(Integer.valueOf(0), "Bob", "Smith", "bob.smith@test.com", "192.57.232.111", 51.509865,
            -0.118092), result);
  }

}