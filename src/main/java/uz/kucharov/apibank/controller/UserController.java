package uz.kucharov.apibank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.kucharov.apibank.payload.ApiResponse;
import uz.kucharov.apibank.payload.UserDto;
import uz.kucharov.apibank.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public HttpEntity<?> getUser(@PathVariable Integer id){
        ApiResponse userName = userService.getUserName(id);
        return ResponseEntity.status(userName.isSuccess()?200:404).body(userName.getObject());
    }

    @PostMapping("/register")
    public HttpEntity<?> addUser(@RequestBody UserDto userDto){
        ApiResponse apiResponse = userService.addUser(userDto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

}
