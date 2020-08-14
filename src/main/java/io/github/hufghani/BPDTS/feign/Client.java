package io.github.hufghani.bpdts.feign;

import io.github.hufghani.bpdts.enity.User;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bpdts", url = "https://bpdts-test-app-v4.herokuapp.com")
public interface Client {
  @GetMapping(value = "/users")
  List<User> retrieveAllUsers();

  @GetMapping(value = "/city/London/users")
  List<User> retrieveLondonUsers();

  @GetMapping(value = "/user/{id}")
  User retrieveUsersById(@PathVariable("id") Integer id);
}
