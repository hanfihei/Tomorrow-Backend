package com.umc.tomorrow.domain.job.dto.response;

import com.umc.tomorrow.domain.job.enums.*;
import lombok.*;

@Getter
@Builder
public class JobDraftCreateResponseDTO {

    private Long id;
    private DraftStatus draftStatus;
    private RegistrantType registrantType;
}
