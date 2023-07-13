package com.example.chap2p;

import org.springframework.data.repository.Repository;

public interface UserRepository extends
        Repository<UserAccount, Long> {
    UserAccount findByUsername(String username);
}