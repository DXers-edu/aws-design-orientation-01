package com.dxers.web.service.implement;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dxers.web.dto.request.auth.SignUpRequestDto;
import com.dxers.web.dto.response.ResponseCode;
import com.dxers.web.entity.UserEntity;
import com.dxers.web.repository.UserRepository;
import com.dxers.web.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String signUp(SignUpRequestDto dto) {
        
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();

        try {

            boolean isExistUserEmail = userRepository.existsByUserEmail(userEmail);
            if (isExistUserEmail) return ResponseCode.DUPLICATED_EMAIL;

            String encodedPassword = passwordEncoder.encode(userPassword);
            dto.setUserPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseCode.DATABASE_ERROR;
        }

        return ResponseCode.SUCCESS;

    }
    
}
