package com.example.chap2p;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManagementRepository extends
        JpaRepository<UserAccount, Long> {
}