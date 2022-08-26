package com.prueba.prueba.Controller;

import com.prueba.prueba.Controller.dto.UserDto;
import com.prueba.prueba.Sevices.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegisterUserController {
    private UserService userService;
    public RegisterUserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("usuario")
    public UserDto retornarNuevoUsuarioRegistroDTO() {
        return new UserDto();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UserDto userDtoDTO) {
        userService.save(userDtoDTO);
        return "redirect:/registro?exito";
    }
}