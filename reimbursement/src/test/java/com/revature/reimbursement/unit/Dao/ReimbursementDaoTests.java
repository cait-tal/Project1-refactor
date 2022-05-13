package com.revature.reimbursement.unit.Dao;

import com.revature.reimbursement.dao.ReimbursementRepository;
import com.revature.reimbursement.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReimbursementDaoTests {

    private Timestamp submit;
    private Timestamp resolved;
    private ReimbursementStatus status;
    private ReimbursementType type;

    private UserRole role;
    private User user;

    private Reimbursement reimbursement;

    @Autowired
    private ReimbursementRepository reimbRepo;


    @BeforeAll
    void init() {
        submit = Timestamp.valueOf("2022-05-12 15:18:20.693");

        status = new ReimbursementStatus(2, "Pending");
        type = new ReimbursementType(4, "Other");


        role = new UserRole(2, "Finance");
        user = new User(1, "CatMom1", "ilovemycats!", "Angela", "Martin", "angela_martin1@dundermifflen.net", role);

        reimbursement = new Reimbursement(1, 1007.67, submit, null, "Sales training bootcamp","https://storage.googleapis.com/reimb-receipt-images/sample_receipt_1.png", user, null, status, type);

    }

    @Test
    void test_findAllReimbursements_positive() {
        List<Reimbursement> reimbursements = reimbRepo.findAll();

        assertThat(reimbursements.size()).isEqualTo(4);
    }

    @Test
    void test_findReimbursementById_positive() {
        Optional<Reimbursement> optional = reimbRepo.findById(1);

        Reimbursement actual = optional.get();

        assertThat(optional.isPresent()).isTrue();
        assertThat(actual).isEqualTo(reimbursement);
    }

    @Test
    void test_findByReimbursementById_negative() {
        Optional<Reimbursement> optional = reimbRepo.findById(500);

        assertThat(optional.isPresent()).isFalse();
    }

    @Test
    void test_findReimbursementByAuthorId_positive() {
        List<Reimbursement> actual = reimbRepo.findByAuthorId(1);

        assertThat(actual.size()).isEqualTo(1);
        assertThat(actual.get(0)).isEqualTo(reimbursement);
    }

    @Test
    void test_findReimbursementByAuthorId_negative() {
        List<Reimbursement> actual = reimbRepo.findByAuthorId(500);

        assertThat(actual.size()).isEqualTo(0);
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(()-> {
            actual.get(0);
        });
    }

    @Test
    void test_findReimbursementByTypeId_positive() {
        List<Reimbursement> actual = reimbRepo.findByTypeId(3);

        assertThat(actual.size()).isEqualTo(2);
        assertThat(actual.get(0)).isNotEqualTo(reimbursement);
        assertThat(actual.get(1)).isNotEqualTo(reimbursement);

        List<Reimbursement> actual2 = reimbRepo.findByTypeId(4);

        assertThat(actual2.size()).isEqualTo(1);
        assertThat(actual2.get(0)).isEqualTo(reimbursement);
    }

    @Test
    void test_findReimbursementByTypeId_negative() {
        List<Reimbursement> actual = reimbRepo.findByTypeId(500);

        assertThat(actual.size()).isEqualTo(0);
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(()-> {
            actual.get(0);
        });
    }

    @Test
    void test_findByReimbursementStatusIdPending_positive() {
        List<Reimbursement> actual = reimbRepo.findByStatusId(2);

        assertThat(actual.size()).isEqualTo(3);
        assertThat(actual.get(0)).isEqualTo(reimbursement);
    }

    @Test
    void test_findByReimbursementStatusIdRejected_positive() {
        List<Reimbursement> actual = reimbRepo.findByStatusId(3);

        assertThat(actual.size()).isEqualTo(1);
        assertThat(actual.get(0)).isNotEqualTo(reimbursement);
    }

    @Test
    void test_findByReimbursementStatusId_negative() {
        List<Reimbursement> actual = reimbRepo.findByStatusId(500);

        assertThat(actual.size()).isEqualTo(0);
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(()-> {
            actual.get(0);
        });
    }
}
