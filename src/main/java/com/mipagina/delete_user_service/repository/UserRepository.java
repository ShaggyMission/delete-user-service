package com.mipagina.delete_user_service.repository;

import com.mipagina.delete_user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
