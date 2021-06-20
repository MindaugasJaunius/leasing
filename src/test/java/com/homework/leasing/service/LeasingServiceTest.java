package com.homework.leasing.service;

import com.homework.leasing.api.model.request.LeasingApplicationRequest;
import com.homework.leasing.api.model.response.SubmitApplicationResponse;
import com.homework.leasing.repository.LeasingRepository;
import com.homework.leasing.repository.entity.Lease;
import com.homework.leasing.repository.entity.LeaseStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LeasingServiceTest {

    @InjectMocks
    private LeasingService service;

    @Mock
    private LeasingRepository repository;

    @Captor
    private ArgumentCaptor<Lease> leaseCaptor;

    @Test
    public void submit_leasing_application_calls_repository_once() {
        Lease mockedLease = new Lease();
        mockedLease.setId(UUID.fromString("df99580a-4f06-47c9-aa47-2e546f7ad17f"));
        mockedLease.setStatus(LeaseStatus.PENDING);
        when(repository.save(any(Lease.class))).thenReturn(mockedLease);

        service.submit(new LeasingApplicationRequest());

        verify(repository, times(1)).save(any(Lease.class));
    }

    @Test
    public void submit_leasing_application_successful_save() {
        Lease mockedLease = new Lease();
        mockedLease.setId(UUID.fromString("df99580a-4f06-47c9-aa47-2e546f7ad17f"));
        mockedLease.setStatus(LeaseStatus.PENDING);
        when(repository.save(any(Lease.class))).thenReturn(mockedLease);

        SubmitApplicationResponse response = service.submit(new LeasingApplicationRequest());

        assertEquals(mockedLease.getId().toString(), response.getApplicationId());
        assertEquals(mockedLease.getStatus().name(), response.getStatus());
    }

    @Test
    public void submit_leasing_application_parameters_remapped() {
        Lease mockedLease = new Lease();
        mockedLease.setId(UUID.fromString("df99580a-4f06-47c9-aa47-2e546f7ad17f"));
        mockedLease.setStatus(LeaseStatus.PENDING);
        when(repository.save(any(Lease.class))).thenReturn(mockedLease);

        LeasingApplicationRequest request = new LeasingApplicationRequest();
        request.setApplicantsEmail("value@domain.lt");
        request.setApplicantsPhone("+37000000000");
        request.setApplicantsPersonalNumber("0123456789");
        request.setApplicantsSalary(new BigDecimal("111.11"));
        request.setCoApplicantsPersonalNumber("9876543210");
        request.setCoApplicantsSalary(new BigDecimal("222.22"));
        request.setCarVinNumber("123123123");
        request.setRequestedAmount(new BigDecimal("333.33"));

        service.submit(request);

        verify(repository).save(leaseCaptor.capture());

        assertTrue(leaseCaptor.getValue().getSubmissionDate().isBefore(LocalDateTime.now()));
        assertEquals(request.getApplicantsEmail(), leaseCaptor.getValue().getApplicantsEmail());
        assertEquals(request.getApplicantsPhone(), leaseCaptor.getValue().getApplicantsPhone());
        assertEquals(request.getApplicantsPersonalNumber(), leaseCaptor.getValue().getApplicantsPersonalNumber());
        assertEquals(request.getApplicantsSalary(), leaseCaptor.getValue().getApplicantsSalary());
        assertEquals(request.getCoApplicantsPersonalNumber(), leaseCaptor.getValue().getCoApplicantsPersonalNumber());
        assertEquals(request.getCoApplicantsSalary(), leaseCaptor.getValue().getCoApplicantsSalary());
        assertEquals(request.getCarVinNumber(), leaseCaptor.getValue().getCarVinNumber());
        assertEquals(request.getRequestedAmount(), leaseCaptor.getValue().getRequestedAmount());
        assertTrue(leaseCaptor.getValue().getStatus().equals(LeaseStatus.PENDING));
    }
}
