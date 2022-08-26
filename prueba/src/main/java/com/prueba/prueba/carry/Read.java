package com.prueba.prueba.carry;


import com.prueba.prueba.Controller.dto.UserDto;
import com.prueba.prueba.Repository.UserRepository;
import com.prueba.prueba.Sevices.UserService;
import com.prueba.prueba.Sevices.UserServiceImple;
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


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class Read  {
    private FileReader archivo;
    private BufferedReader lector;
    private UserRepository userRepository;
    private UserDto userDto;
    private UserServiceImple userServiceImple = new UserServiceImple();
    public void leer(){
        try{
            archivo = new FileReader("C:\\Users\\JuanSuarez\\Desktop\\Desarrollo\\Prueba\\carga.txt");
            if (archivo.ready()){
                lector= new BufferedReader(archivo);
                String line="";
                int numLine=0;
                while ((line= lector.readLine())!= null){
                    numLine++;
                    String[] parts =line.split(",");
                    userDto= new UserDto(parts[0],Long.parseLong(parts[1]),parts[2],parts[3],parts[4]);
                    userServiceImple.save(userDto);
                }
            }else{
                System.out.println("no esta listo para ser leido");
            }

        }catch(Exception e){
            System.out.println("Error: "+ e.getMessage());}
    }


}
