package com.umc.tomorrow.domain.job.repository;

import com.umc.tomorrow.domain.job.entity.JobDraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDraftRepository extends JpaRepository<JobDraft, Long> {
}
