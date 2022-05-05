package com.foo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class FooResponse implements Serializable {

  @JsonProperty("id")
  private UUID id;

  @JsonProperty("name")
  private String name;
}
