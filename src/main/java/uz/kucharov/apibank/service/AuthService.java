package uz.kucharov.apibank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.kucharov.apibank.entity.User;
import uz.kucharov.apibank.repository.UserRepository;

import java.util.Optional;
//
//@Service
//public class AuthService implements UserDetailsService {
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String passport) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByPassportSerial(passport);
//        if (user.isPresent()) return user.get();
//
//        throw new UsernameNotFoundException("User not found!");
//    }
//}
