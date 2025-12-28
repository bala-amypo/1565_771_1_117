// package com.example.demo.service.impl;

// import org.springframework.http.ResponseEntity;

// import com.example.demo.entity.UserAccount;
// import com.example.demo.repository.UserAccountRepository;
// import com.example.demo.service.UserAccountService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// public class UserAccountServiceImpl implements UserAccountService {

//     private final UserAccountRepository repo;
//     private final PasswordEncoder encoder;

//     public UserAccountServiceImpl(UserAccountRepository repo, PasswordEncoder encoder) {
//         this.repo = repo;
//         this.encoder = encoder;
//     }

//     @Override
//     public UserAccount createUser(UserAccount user) {
//         user.setPassword(encoder.encode(user.getPassword()));
//         user.setCreatedAt(LocalDateTime.now());
//         if (user.getStatus() == null) {
//             user.setStatus("ACTIVE");
//         }
//         return repo.save(user);
//     }

//     @Override
//     public UserAccount getUserById(Long id) {
//         return repo.findById(id).orElse(null);
//     }

//     @Override
//     public UserAccount updateUserStatus(Long id, String status) {
//         UserAccount user = repo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("User not found"));

//         user.setStatus(status);
//         return repo.save(user);
//     }


//     @Override
//     public List<UserAccount> getAllUsers() {
//         return repo.findAll();
//     }

//     @Override
//     public UserAccount findByUsername(String username) {
//         return repo.findByUsername(username).orElse(null);
//     }
//}
package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;
    private final PasswordEncoder encoder;

    public UserAccountServiceImpl(UserAccountRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public UserAccount createUser(UserAccount user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public UserAccount getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount u = repo.findById(id).orElseThrow();
        u.setStatus(status);
        return repo.save(u);
    }

    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }
    public UserAccount findByUsername(String username){
    return repo.
    }
}

