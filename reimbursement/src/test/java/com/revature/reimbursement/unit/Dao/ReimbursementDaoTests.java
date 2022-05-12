package com.revature.reimbursement.unit.Dao;

import com.revature.reimbursement.dao.ReimbursementRepository;
import com.revature.reimbursement.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ReimbursementDaoTests {

    @Autowired
    private ReimbursementRepository reimbRepo;

    @Test
    void test_findAllReimbursements_positive() {
        List<Reimbursement> reimbursements = reimbRepo.findAll();

        assertThat(reimbursements.size()).isEqualTo(4);
    }

    @Test
    void test_findReimbursementById_positive() {
        Optional<Reimbursement> optional = reimbRepo.findById(1);

        Reimbursement actual = optional.get();

        Timestamp submit = Timestamp.valueOf("2022-05-12 15:18:20.693");

        ReimbursementStatus status = new ReimbursementStatus(1, "Approved");
        ReimbursementType type = new ReimbursementType(4, "Other");


        UserRole newRole = new UserRole(2, "Finance");
        User newUser = new User(1, "CatMom1", "ilovemycats!", "Angela", "Martin", "angela_martin1@dundermifflen.net", newRole);

        Reimbursement expected = new Reimbursement(1, 1007.67, submit, null, "Sales training bootcamp","https://storage.googleapis.com/reimb-receipt-images/sample_receipt_1.png", newUser, null, status, type);

        actual.setSubmitDate(submit);

        assertThat(optional.isPresent()).isTrue();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void test_findByReimbursementById_negative() {
        Optional<Reimbursement> optional = reimbRepo.findById(500);

        assertThat(optional.isPresent()).isFalse();
    }

    @Test
    void test_findReimbursementByName_positive() {
        List<Reimbursement> actual = reimbRepo.findByUserFirstNameAndLastName("Angela", "Martin");

        assertThat(actual.size()).isEqualTo(3);
    }

    @Test
    void test_findReimbursementByName_negative() {
        List<Reimbursement> actual = reimbRepo.findByUserFirstNameAndLastName("firstName", "lastName");

        assertThat(actual.size()).isEqualTo(0);
    }
}
