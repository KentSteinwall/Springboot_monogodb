package com.example.spring_mongodb.Controller;

import com.example.spring_mongodb.Dao.UserRepository;
import com.example.spring_mongodb.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/addUser")
    public String saveUser(@RequestBody User user){
        repository.save(user);
        return "Added user with id: " + user.getId();
    }

    @GetMapping("/findAll")
    public List<User> getUsers(){
        return repository.findAll();
    }

    @GetMapping("/findUser/{id}")
    public Optional<User> getUser(@PathVariable int id){
        return repository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        repository.deleteById(id);
        return "user deleted with id:" +id;
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable int id,@RequestBody User user){
        user.setId(id);
        repository.save(user);
        return "user update with id:" +id;
    }

    @GetMapping("/findrole/{nic}")
    public String findroleBynic(@PathVariable String nic)
    {
       User user =  repository.findroleBynic(nic);
       return "user role:"+ user.getRoleType();

    }

    @GetMapping("/findAllroles/{organization}/{nic}")
    public List<User> findroles(@PathVariable String organization,@PathVariable String nic)
    {   System.out.println("organization: "+organization + " nic :" +nic);
        System.out.println("sssssss"+repository.findroleByorganizationroletype(organization,nic));
        List<User> users= new ArrayList<>();
       /* users = repository.findroleByorganizationroletype(organization,nic);
        for(User user : users) {
            System.out.println("user nic"+user.getNicNo());
        }*/
       return repository.findroleByorganizationroletype(organization,nic);



    }

}
