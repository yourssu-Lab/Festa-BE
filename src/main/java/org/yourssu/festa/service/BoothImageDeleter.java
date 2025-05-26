package org.yourssu.festa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yourssu.festa.repository.BoothImageRepository;

@Component
@RequiredArgsConstructor
public class BoothImageDeleter {
    private final BoothImageRepository boothImageRepository;

    public void deleteAllByBoothId(Long boothId) {
        boothImageRepository.deleteAllByBoothId(boothId);
    }
}
