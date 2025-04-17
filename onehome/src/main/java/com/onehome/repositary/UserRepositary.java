package com.onehome.repositary;

import com.onehome.entity.OnehomeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositary extends JpaRepository<OnehomeUser, Long> {
    Optional<OnehomeUser> findByMobileNo(String mobileNo);
    Optional<OnehomeUser> findByMobileNoAndEmail(String mobileNo, String email);
}
