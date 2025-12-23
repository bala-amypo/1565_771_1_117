package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface UserAccountRepository {
    UserAccount save(UserAccount u);
    Optional<UserAccount> findById(Long id);
    List<UserAccount> findAll();
    Optional<UserAccount> findByUsername(String username);
}
