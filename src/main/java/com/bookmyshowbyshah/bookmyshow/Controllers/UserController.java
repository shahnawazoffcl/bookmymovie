package com.bookmyshowbyshah.bookmyshow.Controllers;


import com.bookmyshowbyshah.bookmyshow.Controllers.utils.UserControllerUtils;
import com.bookmyshowbyshah.bookmyshow.dto.UserSignUpRequestDTO;
import com.bookmyshowbyshah.bookmyshow.dto.UserSignUpResponseDTO;
import com.bookmyshowbyshah.bookmyshow.models.User;
import com.bookmyshowbyshah.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public ResponseEntity<UserSignUpResponseDTO> signUp(@RequestBody UserSignUpRequestDTO userSignUpRequestDTO){
        User user;
        UserSignUpResponseDTO responseDTO = new UserSignUpResponseDTO();
        try{
            UserControllerUtils.validateUser(userSignUpRequestDTO);
            user = userService.SignUp(userSignUpRequestDTO.getName(), userSignUpRequestDTO.getEmail(), userSignUpRequestDTO.getPassword());
            responseDTO = UserControllerUtils.convertUserToSignUpDTO(user);
        }
        catch (Exception e){
            responseDTO.setResponseCode(500);
            responseDTO.setResponseMessage("Internal Server Error");
        }
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/login")
    public ResponseEntity<UserSignUpResponseDTO> login(@RequestParam String email, @RequestParam String password){
        User user;
        UserSignUpResponseDTO responseDTO = new UserSignUpResponseDTO();
        try{
            user = userService.login(email, password);
            responseDTO = UserControllerUtils.convertUserToSignUpDTO(user);
        }
        catch (Exception e){
            responseDTO.setResponseCode(500);
            responseDTO.setResponseMessage("Internal Server Error");
        }
        return ResponseEntity.ok(responseDTO);
    }
}
