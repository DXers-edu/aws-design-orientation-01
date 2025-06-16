package com.dxers.web.service;

import com.dxers.web.dto.request.auth.SignUpRequestDto;

public interface AuthService {
    String signUp (SignUpRequestDto dto);
}
