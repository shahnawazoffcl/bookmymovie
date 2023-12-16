package com.bookmyshowbyshah.bookmyshow.services;

import com.bookmyshowbyshah.bookmyshow.models.User;

public interface UserService {

    User login(String email, String password);
    User SignUp(String name, String email, String password);

}
