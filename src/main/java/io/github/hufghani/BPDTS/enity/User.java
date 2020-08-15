package io.github.hufghani.bpdts.enity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class User {
  @ApiModelProperty(position = 1, notes = "User Id",name="id",example="1")
  @JsonProperty("id")
  private Integer id;
  @ApiModelProperty(position = 2, notes = "User First Name" ,name="first_name",example="Hamza")
  @JsonProperty("first_name")
  private String firstName;
  @ApiModelProperty(position = 3, notes = "User Last Name" ,name="last_name",example="Ghani")
  @JsonProperty("last_name")
  private String lastName;
  @ApiModelProperty(position = 4, notes = "User Email" ,name="email",example="email@eamil.com")
  @JsonProperty("email")
  private String email;
  @ApiModelProperty(position = 5, notes = "User ip address" ,name="ip_address",example="11.11.11.11")
  @JsonProperty("ip_address")
  private String ipAddress;
  @ApiModelProperty(position = 6, notes = "User location in latitude" ,name="latitude",example="51.509865")
  @JsonProperty("latitude")
  private Double latitude;
  @ApiModelProperty(position = 7, notes = "User location in longitude" ,name="longitude",example="-0.118092")
  @JsonProperty("longitude")
  private Double longitude;
}