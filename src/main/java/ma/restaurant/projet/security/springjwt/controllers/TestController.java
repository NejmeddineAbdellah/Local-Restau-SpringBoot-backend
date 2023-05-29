package ma.restaurant.projet.security.springjwt.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.restaurant.projet.security.springjwt.models.User;
import ma.restaurant.projet.security.springjwt.security.jwt.services.UserDetailsServiceImpl;
import ma.restaurant.projet.security.springjwt.security.jwt.services.UserService;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    private UserDetailsServiceImpl userService;
    private UserService userService2;


  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

 
  
  @GetMapping("/userss")
  public List<User> findAll(){
      return userService2.findAll();
  }
  
  @GetMapping("/username/{username}")
  @PreAuthorize("hasRole('ADMIN')")
  public UserDetails findByUsername(@PathVariable String username){
      return userService.loadUserByUsername(username);
  }
  
  
  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }
}
