package com.example.demo.database;

import org.jnosql.artemis.Repository;

import com.example.demo.model.User;

public interface UserRepository extends Repository<User, String> {

}
