package com.estudos.estudos.service;

import com.estudos.estudos.domain.entity.DTO.CredenciaisDto;
import com.estudos.estudos.domain.entity.DTO.UserDto;
import com.estudos.estudos.domain.entity.User;
import com.estudos.estudos.domain.repository.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado"));
        return user;
    }

    public UserDto findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user != null){
            UserDto userDto = new UserDto(user);
             return userDto;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Email não encotrado");
//        try{
//            User user = userRepository.findByEmail(email);
//            UserDto userDto = new UserDto(user);
//            return userDto;
//        }catch (NullPointerException ex){
//            throw new NullPointerException(ex.getMessage()) ;
//        }
    }

    public void save(User user) {
        User existe = userRepository.findByEmail(user.getEmail());
        if(existe != null){
         throw new ResponseStatusException(HttpStatus.CONFLICT,"E-mail já cadastrado");
        }else{
            userRepository.save(user);
        }
    }

    public User delete(Long id) {
        return userRepository.findById(id).map(user ->{
            userRepository.delete(user);
            return user;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado"));
    }

    public User edit(Long id, User user) {
        return userRepository.findById(id).map(existe -> {
            user.setId(existe.getId());
            userRepository.save(user);
            return existe;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não ecnontrado"));
    }

    public void cadastroUser(User user) {
        User existe = userRepository.findByEmail(user.getEmail());
        if(existe != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"E-mail já cadastrado");
        }else{
            userRepository.save(user);
        }
    }

    public UserDto login(CredenciaisDto credenciaisDto) {

        User userOk = userRepository.findByEmail(credenciaisDto.getEmail());
        if(userOk != null){
            if(credenciaisDto.getPassword().equals(userOk.getPassword())){
                UserDto dto = new UserDto(userOk);
                return dto;
            }
            else{

                throw new RuntimeException(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha incorreto"));
            }
        }
        else{
            throw new RuntimeException(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email incorreto"));
        }
    }
}
