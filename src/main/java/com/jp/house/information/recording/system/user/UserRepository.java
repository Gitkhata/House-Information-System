package com.jp.house.information.recording.system.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Integer> {

   @Query("SELECT u FROM User u WHERE u.username = ?1")
   User findByUsername(String username);

}
