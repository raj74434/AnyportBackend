package com.anyport.AnyPort.repository;

import com.anyport.AnyPort.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Integer, User> {



}
