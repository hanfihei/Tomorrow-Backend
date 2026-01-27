package com.umc.tomorrow.domain.job.dto.response;

import com.umc.tomorrow.domain.job.entity.JobDraft;
import com.umc.tomorrow.domain.job.enums.*;
import lombok.*;

@Getter
@Builder
public class JobDraftCreateResponseDTO {

    private Long id;
    private DraftStatus draftStatus;
    private RegistrantType registrantType;

    public static JobDraftCreateResponseDTO from(JobDraft draft) {
        return JobDraftCreateResponseDTO.builder()
                .id(draft.getId())
                .draftStatus(draft.getDraftStatus())
                .registrantType(draft.getRegistrantType())
                .build();
    }

}
