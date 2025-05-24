package org.yourssu.festa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yourssu.festa.common.code.AuthErrorCode;
import org.yourssu.festa.common.code.BoothErrorCode;
import org.yourssu.festa.domain.Booth;
import org.yourssu.festa.domain.BoothEntity;
import org.yourssu.festa.exception.CustomException;
import org.yourssu.festa.repository.BoothRepository;

@Component
@RequiredArgsConstructor
public class BoothReader {
    private final BoothRepository boothRepository;

    public BoothEntity findBySerialNumAndBoothNum(int serialNum, int boothNum){
        return boothRepository.findBySerialNumAndBoothNum(serialNum, boothNum)
                .orElseThrow(() -> new CustomException(AuthErrorCode.USER_NOT_REGISTERED));
    }

    public BoothEntity findById(Long id){
        return boothRepository.findById(id)
                .orElseThrow(() -> new CustomException(BoothErrorCode.BOOTH_NOT_FOUND));
    }
}
