package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserAccountServiceImpl(UserAccountRepository userRepo,
                                  PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setStatus(status);
        return userRepo.save(user);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserAccount findByUsername(String username) {
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}

// package com.example.demo.service.impl;

// import com.example.demo.entity.UserAccount;
// import com.example.demo.repository.UserAccountRepository;
// import com.example.demo.service.UserAccountService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class UserAccountServiceImpl implements UserAccountService {

//     private final UserAccountRepository repo;
//     private final PasswordEncoder encoder;

//     public UserAccountServiceImpl(UserAccountRepository repo, PasswordEncoder encoder) {
//         this.repo = repo;
//         this.encoder = encoder;
//     }

//     public UserAccount createUser(UserAccount user) {
//         user.setPassword(encoder.encode(user.getPassword()));
//         return repo.save(user);
//     }

//     public UserAccount getUserById(Long id) {
//         return repo.findById(id).orElse(null);
//     }

//     public UserAccount updateUserStatus(Long id, String status) {
//         UserAccount u = repo.findById(id).orElseThrow();
//         u.setStatus(status);
//         return repo.save(u);
//     }

//     public List<UserAccount> getAllUsers() {
//         return repo.findAll();
//     }
//     public UserAccount findByUsername(String username){
//     return repo.findByUsername(username);
//     }
// }

