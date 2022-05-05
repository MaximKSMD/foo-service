package com.foo.dao;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class FooDao implements Serializable {

  @Id
  //    @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private String name;
}
