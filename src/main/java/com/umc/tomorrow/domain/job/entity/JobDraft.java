package com.umc.tomorrow.domain.job.entity;

import com.umc.tomorrow.domain.job.dto.request.JobRequestDTO;
import com.umc.tomorrow.domain.job.enums.*;
import com.umc.tomorrow.domain.member.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobDraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;


    private String title;

    private Boolean isActive = true;

    private String jobDescription;

    @Enumerated(EnumType.STRING)
    private JobCategory jobCategory;

    @Enumerated(EnumType.STRING)
    private WorkPeriod workPeriod;

    private Boolean isPeriodNegotiable = false;

    private LocalTime workStart;

    private LocalTime workEnd;

    private Boolean isTimeNegotiable = false;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    private Integer salary;

    private Boolean isSalaryNegotiable = false;

    private String jobImageUrl;

    private String companyName;

    private Integer recruitmentLimit;

    @Enumerated(EnumType.STRING)
    private RegistrantType registrantType;

    private LocalDateTime deadline;

    @Lob
    private String preferredQualifications;

    @Column(precision = 10, scale = 7)
    private BigDecimal latitude; //위도

    @Column(precision = 10, scale = 7)
    private BigDecimal longitude; //경도


    private String location;//위도, 경도를 받아서 location에 저장

    private Boolean alwaysHiring = false;

    private LocalDateTime expiresAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DraftStatus draftStatus = DraftStatus.DRAFT;

    private boolean draftIsActive = false;


    public static JobDraft create(User user, JobRequestDTO dto, String jobAddress){
        JobDraft draft = new JobDraft();
        draft.user = user;
        draft.title = dto.getTitle();
        draft.jobDescription = dto.getJobDescription();
        draft.jobCategory = dto.getJobCategory();
        draft.workPeriod = dto.getWorkPeriod();
        draft.isActive = dto.getIsActive();
        draft.workStart = dto.getWorkStart();
        draft.workEnd = dto.getWorkEnd();
        draft.isTimeNegotiable = dto.getIsTimeNegotiable();
        draft.isPeriodNegotiable = dto.getIsPeriodNegotiable();
        draft.jobImageUrl = dto.getJobImageUrl();
        draft.companyName = dto.getCompanyName();
        draft.recruitmentLimit = dto.getRecruitmentLimit();
        draft.registrantType = dto.getRegistrantType();
        draft.deadline = dto.getDeadline();
        draft.preferredQualifications = dto.getPreferredQualifications();
        draft.latitude = dto.getLatitude();
        draft.longitude = dto.getLongitude();
        draft.location = jobAddress;
        draft.alwaysHiring = dto.getAlwaysHiring();
        draft.draftStatus = DraftStatus.DRAFT;
        draft.expiresAt = LocalDateTime.now().plusMinutes(30);
        draft.draftIsActive = true;
        return draft;
    }


    public void changeLocation(String jobAddress) {
        this.location = jobAddress;
    }

    public void markCompleted() {
        this.draftStatus = DraftStatus.COMPLETED;
    }

    public void changeDiscardedStatus() {
        this.draftStatus = DraftStatus.DISCARDED;
    }
}
