package uz.kucharov.apibank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.kucharov.apibank.entity.User;
import uz.kucharov.apibank.payload.ApiResponse;
import uz.kucharov.apibank.payload.UserDto;
import uz.kucharov.apibank.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;

    public ApiResponse getUserName(Integer id){
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) return new ApiResponse("User not found!", false);
        String username = user.get().getUsername();
        return new ApiResponse("User found!", true, username);
    }
    public ApiResponse addUser(UserDto userDto){
        Optional<User> byPassportSerial = userRepository.findByPassportSerial(userDto.getPassportSerial());
        if (byPassportSerial.isPresent()) return new ApiResponse("User with this passport serial is already exists", false);
        Optional<User> byUsername = userRepository.findByUsername(userDto.getUsername());
        if (byUsername.isPresent()) return new ApiResponse("User with this username is already exists. Please try another", false);

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setPassportSerial(userDto.getPassportSerial());
        userRepository.save(user);
        return new ApiResponse("User added successfully", true, user);
    }
}
