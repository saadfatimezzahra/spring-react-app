package ma.oncf.rexbackend.controllers;

import ma.oncf.rexbackend.dto.UserDto;
import ma.oncf.rexbackend.models.Rex;
import ma.oncf.rexbackend.models.Role;
import ma.oncf.rexbackend.models.Status;
import ma.oncf.rexbackend.models.User;
import ma.oncf.rexbackend.services.Imp.UserServiceImp;
import ma.oncf.rexbackend.services.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/responsible")
public class ResponsibleController {
    @Autowired
    private UserServiceImp userServiceImp ;



    @PostMapping("/add")
    public User addVisitor(@RequestBody UserDto userDto){
        User user = new User() ;
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setJob(userDto.getJob());
        user.setStatus(Status.INVALID);
        user.setRole(Role.VISITOR);
        user.setPassword(userDto.getPassword());
        return  userServiceImp.addUser(user);
    }

    @GetMapping("/check")
    public Optional<User> getUserByEmail(@RequestParam String email){
        Optional<User> user = userServiceImp.getUserByEmail(email) ;
        System.out.println(user);
        return user ;
    }
    @PostMapping("/checkfirstname")
    public Optional<User> getUserByFirstname(@RequestBody String firstname){
        Optional<User> user = userServiceImp.getUserByFirstname(firstname) ;
        System.out.println(user);
        return user ;
    }


}
