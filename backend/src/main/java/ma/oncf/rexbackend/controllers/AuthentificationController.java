package ma.oncf.rexbackend.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthentificationController {

    @PostMapping
    public void login(){

    }


    @PutMapping
    public void resetPassword(){

    }

    @GetMapping("/email")
    public void verifyEmailExistance(@RequestBody String email){

    }

    @GetMapping()
    public void disconnect(){

    }
}
