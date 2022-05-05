package com.foo.repository;

import com.foo.dao.FooDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface FooRepository extends JpaRepository<FooDao, UUID> {}
