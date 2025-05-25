package org.yourssu.festa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yourssu.festa.domain.Booth;
import org.yourssu.festa.domain.entity.BoothEntity;
import org.yourssu.festa.dto.LoginRequest;
import org.yourssu.festa.dto.LoginResponse;
import org.yourssu.festa.utils.JwtUtil;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final BoothReader boothReader;
    private final JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest request){
        BoothEntity boothEntity = boothReader.findBySerialNumAndBoothNum(request.serialNumber(), request.boothNumber());
        Booth booth = Booth.toDomain(boothEntity);
        return jwtUtil.generateToken(booth.id());
    }
}
