package com.revature.reimbursement.unit.Service;

import com.revature.reimbursement.dao.ReimbursementRepository;
import com.revature.reimbursement.dto.ReimbursementDto;
import com.revature.reimbursement.dto.UserDto;
import com.revature.reimbursement.model.*;
import com.revature.reimbursement.service.ReimbursementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.sql.Timestamp;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReimbursementServiceTests {

    private Reimbursement reimbursement;
    private User user;
    private UserRole userRole;
    private ReimbursementStatus status;
    private ReimbursementType type;

    private UserDto userDto;
    private ReimbursementDto reimbursementDto;

    private Timestamp currentTime;

    @Mock
    private ReimbursementRepository reimbRepo;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private ReimbursementService reimbService;

    @BeforeEach
    void init() {
        currentTime = new Timestamp(System.currentTimeMillis());
        userRole = new UserRole(1,"Management");
        user = new User(1, "username", "password", "first", "last", "email@email.com", userRole);
        status = new ReimbursementStatus(2, "Pending");
        type = new ReimbursementType(1, "Lodging");
        reimbursement = new Reimbursement(1, 100.00, currentTime, null, "description", "www.image.com", user, null, status, type);

        userDto = new UserDto("first", "last", "email@email.com", userRole);
        reimbursementDto = new ReimbursementDto(100.00, currentTime, null, "description", "www.image.com", userDto, null, status, type);
    }

    @Test
    void test_getReimbursementById_positive() {
        when(reimbRepo.findById(1)).thenReturn(Optional.of(reimbursement));

        ReimbursementDto actual = reimbService.findreimbursementById(1);

        assertThat(actual).isEqualTo(reimbursementDto);
    }

    @Test
    void test_getReimbursementByInvalidId_negative() {
        when(reimbRepo.findById(500)).thenReturn(Optional.empty());

        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> {
            reimbService.findreimbursementById(500);
        });
    }

    @Test
    void test_getAllReimbursements_positive() {
        List<Reimbursement> results = new ArrayList<>(Arrays.asList(reimbursement));
        when(reimbRepo.findAll()).thenReturn(results);

        List<ReimbursementDto> actual = reimbService.findAllReimbursements();

        assertThat(actual).hasSize(1).contains(reimbursementDto);
    }


}
