package com.umc.tomorrow.domain.job.service.command;

import com.umc.tomorrow.domain.job.dto.request.BusinessRequestDTO;
import com.umc.tomorrow.domain.job.dto.request.JobRequestDTO;
import com.umc.tomorrow.domain.job.dto.request.PersonalRequestDTO;
import com.umc.tomorrow.domain.job.dto.response.JobCreateResponseDTO;
import com.umc.tomorrow.domain.job.dto.response.JobDraftCreateResponseDTO;
import com.umc.tomorrow.domain.job.dto.response.JobStepResponseDTO;
import com.umc.tomorrow.domain.searchAndFilter.dto.response.JobResponseDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.transaction.annotation.Transactional;

public interface JobCommandService {

    // 기본 일자리 정보 폼 저장 (드래프트 엔티티에 저장)
    JobDraftCreateResponseDTO saveInitialJobStep(Long userId, JobRequestDTO requestDTO);

    //일자리 초안이 있는지 확인하고 있다면 반환
    JobDraftCreateResponseDTO existDraftCheck(Long userId);

    // 개인 등록 시 Personal 정보 저장 + Job 생성
    JobCreateResponseDTO savePersonalRegistration(Long userId, PersonalRequestDTO requestDTO, Long draftId);

    // 사업자 등록이 이미 되어있는 경우 바로 Job 생성
    JobCreateResponseDTO createJobWithExistingBusiness(Long userId, HttpSession session);

    // 사업자 등록이 안 되어 있는 경우 step 반환 (사업자 등록 페이지 이동)
    JobStepResponseDTO determineJobStep(Long userId, HttpSession session);

    // 사업자 등록
    void saveBusinessVerification(Long userId, BusinessRequestDTO requestDTO);

    // PATCH 공고 모집완료/모집전 처리
    @Transactional
    void updateJobStatus(Long userId, Long jobId, String status);
}
