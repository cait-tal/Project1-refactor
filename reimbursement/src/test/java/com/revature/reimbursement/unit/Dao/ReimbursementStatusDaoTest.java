package com.revature.reimbursement.unit.Dao;

import com.revature.reimbursement.dao.ReimbursementStatusRepository;
import com.revature.reimbursement.model.ReimbursementStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReimbursementStatusDaoTest {

    private ReimbursementStatus status1;
    private ReimbursementStatus status2;
    private ReimbursementStatus status3;

    @Autowired
    ReimbursementStatusRepository reimbStatRepo;

    @BeforeAll
    void init() {
        status1 = new ReimbursementStatus(1, "Approved");
        status2 = new ReimbursementStatus(2, "Pending");
        status3 = new ReimbursementStatus(3,"Rejected");
    }

    @Test
    void test_getAllRembursementStatuses_positive() {
        List<ReimbursementStatus> status = reimbStatRepo.findAll();

        assertThat(status).hasSize(3)
                .contains(status1)
                .contains(status2)
                .contains(status3);
    }

    @Test
    void test_getNonExistentStatus_negative() {
        Optional<ReimbursementStatus> status = reimbStatRepo.findById(500);

        assertThat(status).isNotPresent();
    }
}
