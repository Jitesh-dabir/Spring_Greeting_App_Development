package com.bridgelabz.springgreetingapi.repository;

import com.bridgelabz.springgreetingapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
