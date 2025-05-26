package org.yourssu.festa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yourssu.festa.domain.entity.BoothImageEntity;
import org.yourssu.festa.repository.BoothImageRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BoothImageSaver {

    private final BoothImageRepository boothImageRepository;

    public void saveAll(List<BoothImageEntity> boothImageEntities) {
        boothImageRepository.saveAll(boothImageEntities);
    }
}