package ma.oncf.rexbackend.services.Imp;

import ma.oncf.rexbackend.models.Status;
import ma.oncf.rexbackend.models.User;
import ma.oncf.rexbackend.repositories.UserRepository;
import ma.oncf.rexbackend.services.MailSenderService;
import ma.oncf.rexbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private PasswordEncoder passwordEncoder ;
    @Autowired
    private MailSenderService mailSenderService ;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll() ;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User addUser(User user) {
        mailSenderService.sendMail(user.getEmail() , "rex application registration" , "votre login est " + user.getEmail()+ " votre mot de passe est " + user.getPassword());
        System.out.println("mail sent");
        System.out.println("before");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("after");
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User oldUser = userRepository.findById(id).orElseThrow();
        oldUser.setFirstname(user.getFirstname());
        oldUser.setLastname(user.getLastname());
        oldUser.setEmail(user.getEmail());
        oldUser.setJob(user.getJob());
        oldUser.setRole(user.getRole());


        return userRepository.save(oldUser);
    }

    @Override
    public void deleteUser(Long id) {
         userRepository.deleteById(id);
    }

    @Override
    public User validUser(Long id) {
        User oldUser = userRepository.findById(id).orElseThrow();
        oldUser.setStatus(Status.VALID);
        return userRepository.save(oldUser);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> getUserByFirstname(String firstname) {
        return userRepository.findByFirstname(firstname);
    }
}
