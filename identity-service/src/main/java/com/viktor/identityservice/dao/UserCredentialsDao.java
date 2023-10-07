package com.viktor.identityservice.dao;

import com.viktor.identityservice.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsDao extends JpaRepository<UserCredentials,Integer> {
}
