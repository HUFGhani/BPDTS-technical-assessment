package io.github.hufghani.bpdts.service;

import io.github.hufghani.bpdts.enity.User;
import io.github.hufghani.bpdts.feign.Client;
import io.github.hufghani.bpdts.util.Utilities;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService{

  @Autowired
  private Client bpdtsClient;

  @Override
  public List<User> getAllUsers() {
    return bpdtsClient.retrieveAllUsers();
  }

  @Override
  public List<User> getUserFromLondon() {
    return bpdtsClient.retrieveLondonUsers();
  }

  @Override
  public List<User> getLondonUsersByDistance(double distance) {
    List<User> allUsers = bpdtsClient.retrieveAllUsers();
    List<User> result = new ArrayList<>();

    allUsers.forEach(user -> {
      double distanceMiles = Utilities.distanceCal(user.getLatitude(),user.getLongitude());
      if (distanceMiles <= distance) result.add(user);
    });

    return result;
  }

  @Override
  public User getUserById(int id) {
    return bpdtsClient.retrieveUsersById(id);
  }
}
