package com.groupeisi.dao;


import com.groupeisi.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByEmail(String email);
}
