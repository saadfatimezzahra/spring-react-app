package ma.oncf.rexbackend.services;

import ma.oncf.rexbackend.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getAllUsers()  ;
    public Optional<User> getUserById(Long id ) ;
    public User addUser(User user) ;
    public User updateUser(Long id , User user) ;
    public void deleteUser(Long id ) ;
    public User validUser(Long id) ;
    public Optional<User> getUserByEmail(String email) ;
    public Optional<User> getUserByFirstname(String email) ;
}
