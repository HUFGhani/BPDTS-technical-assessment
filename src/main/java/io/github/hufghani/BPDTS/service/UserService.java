package io.github.hufghani.bpdts.service;

import io.github.hufghani.bpdts.enity.User;
import java.util.List;

public interface UserService {
  List<User> getAllUsers();

  List<User> getUserFromLondon();

  List<User> getLondonUsersByDistance(double distance);

  User getUserById(int i);
}
