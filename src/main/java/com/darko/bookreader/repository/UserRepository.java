package com.darko.bookreader.repository;

import org.springframework.data.repository.CrudRepository;

import com.darko.bookreader.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
