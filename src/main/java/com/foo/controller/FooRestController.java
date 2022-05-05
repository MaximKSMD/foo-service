package com.foo.controller;

import com.foo.dao.FooDao;
import com.foo.response.FooResponse;
import com.foo.service.FooService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api")
public class FooRestController {

  private final FooService fooService;

  @GetMapping(
      path = "/foo/{id}",
      produces = {"application/json"})
  public ResponseEntity<FooResponse> getFooById(@PathVariable UUID id) {
    try {
      FooResponse response = fooService.getFooById(id);
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity("resource not found", HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping(path = "/foo", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<FooResponse> addFoo(@RequestBody FooDao foo) {
    FooResponse response = fooService.postFoo(foo);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/foo/{id}")
  public ResponseEntity<String> deleteFoo(@PathVariable UUID id) {
    try {
      fooService.deleteFoo(id);
      return new ResponseEntity<String>("Deleted Foo by id: " + id, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity("resource not found", HttpStatus.NOT_FOUND);
    }
  }
}
