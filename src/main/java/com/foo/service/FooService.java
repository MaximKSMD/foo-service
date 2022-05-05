package com.foo.service;

import com.foo.dao.FooDao;
import com.foo.response.FooResponse;
import java.util.UUID;

public interface FooService {

  FooResponse getFooById(UUID id);

  FooResponse postFoo(FooDao foo);

  void deleteFoo(UUID id);
}
