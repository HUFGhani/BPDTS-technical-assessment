package io.github.hufghani.bpdts.feign;

import io.github.hufghani.bpdts.enity.User;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "bpdts", url = "https://bpdts-test-app-v4.herokuapp.com")
public interface Client {
  @GetMapping(value = "/users")
  List<User> retrieveAllUsers();
}