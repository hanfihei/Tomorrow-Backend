package com.umc.tomorrow.domain.job.repository;

import com.umc.tomorrow.domain.job.entity.JobDraft;
import com.umc.tomorrow.domain.job.enums.DraftStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobDraftRepository extends JpaRepository<JobDraft, Long> {
    Optional<JobDraft> findByIdAndUser_Id(Long draftId, Long userId);

    Optional<JobDraft> findByUserIdAndDraftStatus(Long userId, DraftStatus draftStatus);

}
