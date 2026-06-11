package com.sistemas.app.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistemas.app.dto.LoginDTO;
import com.sistemas.app.dto.UsuarioRequestDTO;
import com.sistemas.app.dto.UsuarioResponseDTO;
import com.sistemas.app.mapper.Mapper;
import com.sistemas.app.model.Usuario;
import com.sistemas.app.repository.UsuarioRepository;
import com.sistemas.app.utils.JwtUtil;

@Service
public class LoginService implements ILoginService {

private final UsuarioRepository usuarioRepo;

    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public LoginService(UsuarioRepository usuarioRepo, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.usuarioRepo = usuarioRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String login(LoginDTO loginDTO) {
        Usuario usuario = usuarioRepo.findByUsername(loginDTO.getUsername())
                .orElseThrow(() -> new BadCredentialsException("Credenciales inválidas"));

        if (!passwordEncoder.matches(loginDTO.getPassword(), usuario.getPassword())) {
            throw new BadCredentialsException("Credenciales inválidas");
        }

        return jwtUtil.generateToken(usuario.getUsername(), usuario.getId());
    }

    //private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    @Override
    public UsuarioResponseDTO createUser(UsuarioRequestDTO usuarioDTO) {

        if (usuarioRepo.findByUsername(usuarioDTO.getUsername())
                .isPresent()) {
                
            throw new RuntimeException(
                    "El username ya existe");
        }
        
        Usuario newUser = Mapper.toUsuarioEntity(usuarioDTO);

        newUser.setPassword(
                passwordEncoder.encode(usuarioDTO.getPassword())
        );
        Usuario usuarioSaved = usuarioRepo.save(newUser);
        return Mapper.toUsuarioResponseDTO(usuarioSaved);
    }


}