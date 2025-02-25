package com.example.ContactManagementApp.Repository;

import com.example.ContactManagementApp.Models.Contacts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository <Contacts,Long> {

    @Modifying
    @Transactional
    @Query(value="UPDATE `contacts` SET `email`=?2,`name`=?3 WHERE `phone_no`=?1", nativeQuery = true)
    public void updateUser(String phoneNo,String email,String name);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM `contacts` WHERE `email` = ?1", nativeQuery = true)
    public void deleteUser(String email);
}
