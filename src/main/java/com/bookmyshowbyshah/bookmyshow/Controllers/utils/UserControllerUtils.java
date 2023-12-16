package com.bookmyshowbyshah.bookmyshow.Controllers.utils;

import com.bookmyshowbyshah.bookmyshow.dto.UserSignUpRequestDTO;
import com.bookmyshowbyshah.bookmyshow.dto.UserSignUpResponseDTO;
import com.bookmyshowbyshah.bookmyshow.models.User;

public class UserControllerUtils {
    public static void validateUser(UserSignUpRequestDTO userSignUpRequestDTO){
        //validate UserRequestDTO
        //else throw Exception
    }

    public static UserSignUpResponseDTO convertUserToSignUpDTO(User user){
        UserSignUpResponseDTO responseDTO = new UserSignUpResponseDTO();
        responseDTO.setResponseCode(200);
        responseDTO.setResponseMessage("SUCCESS");
        responseDTO.setTickets(user.getTickets());
        responseDTO.setName(user.getName());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setId(user.getId());
        return responseDTO;
    }
}
