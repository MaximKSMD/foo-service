package com.foo.service;

import com.foo.dao.FooDao;
import com.foo.repository.FooRepository;
import com.foo.response.FooResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;

@AllArgsConstructor
@Service
public class FooServiceImpl implements FooService {

  private final FooRepository repository;

  @Override
  public FooResponse getFooById(UUID id) {
    FooDao foo = null;
    try {
      foo = repository.getById(id);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return new FooResponse(foo.getId(), foo.getName());
  }

  @Override
  public FooResponse postFoo(FooDao foo) {
    FooDao saved = repository.save(foo);
    return new FooResponse(saved.getId(), saved.getName());
  }

  @Override
  public void deleteFoo(UUID id) {
    repository.deleteById(id);
  }
}
