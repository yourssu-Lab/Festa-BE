package org.yourssu.festa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yourssu.festa.domain.entity.BoothImageEntity;
import org.yourssu.festa.repository.BoothImageRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BoothImageReader {

    private final BoothImageRepository boothImageRepository;

    public List<BoothImageEntity> getAllByBoothId(Long boothId){
        return boothImageRepository.findAllByBoothId(boothId);
    }

    public BoothImageEntity getFirstByBoothId(Long boothId) {
        return boothImageRepository.findFirstByBoothIdOrderByIdAsc(boothId)
                .orElse(null);
    }
}
