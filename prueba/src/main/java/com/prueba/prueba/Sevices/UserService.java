package com.prueba.prueba.Sevices;


import com.prueba.prueba.Controller.dto.UserDto;
import com.prueba.prueba.model.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public UserModel save(UserDto userDto);
    public List<UserModel> listUsers();
}
