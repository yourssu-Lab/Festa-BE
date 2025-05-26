package org.yourssu.festa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yourssu.festa.domain.entity.BoothEntity;
import org.yourssu.festa.dto.BoothRequest;

@Component
@RequiredArgsConstructor
public class BoothUpdater {

    public void updateFromRequest(BoothEntity boothEntity, BoothRequest request) {
        boothEntity.update(
                request.name(),
                request.summary(),
                request.description(),
                request.status()
        );
    }
}
