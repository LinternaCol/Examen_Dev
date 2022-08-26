package com.prueba.prueba.Sevices;

import com.prueba.prueba.Controller.dto.UserDto;
import com.prueba.prueba.Repository.UserRepository;
import com.prueba.prueba.model.Rol;
import com.prueba.prueba.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImple implements UserService {
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImple(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public UserServiceImple() {
    }

    @Override
    public UserModel save(UserDto registroDTO) {
        UserModel usuario = new UserModel(registroDTO.getNombre(),
                registroDTO.getCedula(),registroDTO.getEmail(),registroDTO.getCelular(),
                passwordEncoder.encode(registroDTO.getPassword()),Arrays.asList(new Rol("ROLE_USER")));
        return userRepository.save(usuario);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel usuario = userRepository.findByEmail(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getEmail(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }
    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }
    @Override
    public List<UserModel> listUsers() {
        return userRepository.findAll();
    }

}
