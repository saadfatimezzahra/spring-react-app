package ma.oncf.rexbackend.controllers;

import ma.oncf.rexbackend.dto.UserDto;
import ma.oncf.rexbackend.models.Status;
import ma.oncf.rexbackend.models.User;
import ma.oncf.rexbackend.services.MailSenderService;
import ma.oncf.rexbackend.services.Imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserServiceImp userServiceImp ;



    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userServiceImp.getAllUsers() ;
    }
    @GetMapping("/all/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return userServiceImp.getUserById(id) ;
    }
    @PostMapping("/add")
    public User addUser(@RequestBody UserDto userDto){
        User user = new User() ;
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setJob(userDto.getJob());
        user.setRole(userDto.getRole());
        user.setPassword(userDto.getPassword());
        user.setStatus(Status.INVALID);
        return  userServiceImp.addUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
         userServiceImp.deleteUser(id);
    }

    @PutMapping("/validUser/{id}")
    public User validUser(@PathVariable Long id){

        return userServiceImp.validUser(id ) ;
    }


}
