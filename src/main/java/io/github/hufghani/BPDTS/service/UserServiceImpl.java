package io.github.hufghani.bpdts.service;

import io.github.hufghani.bpdts.enity.User;
import io.github.hufghani.bpdts.feign.Client;
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
}
