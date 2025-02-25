package com.example.ContactManagementApp.Controllers;

import com.example.ContactManagementApp.Models.Contacts;
import com.example.ContactManagementApp.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ContactAppController {

    @Autowired
    private ContactRepository contactRepo;

    @PostMapping("/addUsers")
    public ResponseEntity<Map<String,String>> addUser(@RequestBody Contacts user){
        contactRepo.save(user);

        Map<String,String> response = new HashMap<>();
        response.put("Status","User added successfully");
        return ResponseEntity.ok(response);
    }
    @GetMapping("/viewAllUsers")
    public ResponseEntity<List<Contacts>> viewUsers(){
        List<Contacts> users = contactRepo.findAll();

        return ResponseEntity.ok(users);
    }
    @PostMapping("/updateUser")
    public ResponseEntity<Map<String,String>>  updateUser(@RequestBody Contacts contact){
        contactRepo.updateUser(contact.getPhoneNo(), contact.getEmail(),contact.getName());

        Map<String,String> response = new HashMap<>();
        response.put("Status","Update successful");

        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/deleteUser")
    public ResponseEntity<Map<String,String>> deleteUser(@RequestBody Contacts contact){
        contactRepo.deleteUser(contact.getEmail());

        Map<String,String> response = new HashMap<>();
        response.put("Status","Success");
        return ResponseEntity.ok(response);
    }
}
