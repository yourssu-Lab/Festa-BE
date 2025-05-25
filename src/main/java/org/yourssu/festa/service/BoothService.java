package org.yourssu.festa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yourssu.festa.domain.Booth;
import org.yourssu.festa.domain.BoothImage;
import org.yourssu.festa.domain.enums.DayPeriod;
import org.yourssu.festa.dto.BoothDetailResponse;
import org.yourssu.festa.dto.BoothPreviewResponse;
import org.yourssu.festa.reader.BoothImageReader;
import org.yourssu.festa.reader.BoothReader;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoothService {

    private final BoothReader boothReader;
    private final BoothImageReader boothImageReader;

    public BoothDetailResponse getBoothDetail(Long boothId){
        Booth booth = Booth.toDomain(
                boothReader.findById(boothId)
        );

        List<BoothImage> boothImageList =  boothImageReader.getAllByBoothId(boothId)
                .stream()
                .map(BoothImage::toDomain)
                .toList();

        return BoothDetailResponse.from(booth, boothImageList);
    }

    public BoothPreviewResponse getBoothPreview(int boothNum, int dayNum, DayPeriod dayPeriod){
        Booth booth = Booth.toDomain(
                boothReader.findByBoothNumAndDay(boothNum, dayNum, dayPeriod)
        );

        BoothImage boothImage =  BoothImage.toDomain(
                boothImageReader.getFirstByBoothId(booth.id())
        );

        return BoothPreviewResponse.from(booth, boothImage);
    }
}
