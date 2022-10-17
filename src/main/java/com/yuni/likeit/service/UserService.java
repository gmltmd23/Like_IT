package com.yuni.likeit.service;

import com.yuni.likeit.dto.UserDTO;
import com.yuni.likeit.entities.UserEntity;
import com.yuni.likeit.repository.UserRepository;
import com.yuni.likeit.util.Encryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Encryptor encryptor;

    public boolean signUp(UserDTO userDTO) {
        UserEntity userEntity = UserEntity.builder()
                .email(userDTO.getEmail())
                .password(encryptor.passwordToSha256(userDTO.getPassword()))
                .name(userDTO.getName())
                .build();

        userRepository.save(userEntity);
        return true;
    }

    public boolean login(UserDTO userDTO) {
        UserEntity foundUser = userRepository.findUserByEmail(userDTO.getEmail());
        if(foundUser != null) {
            String digest = encryptor.passwordToSha256(userDTO.getPassword());
            if(digest.equals(foundUser.getPassword()))
                return true;
            else
                return false;
        }
        else {
            return false;
        }
    }
    public UserDTO findUserByEmail() {
        UserEntity userEntity = userRepository.findUserByEmail("rkskek23@naver.com");
        return (userEntity == null) ? null : new UserDTO(userEntity.getEmail(), userEntity.getPassword(), userEntity.getName());
    }
}
