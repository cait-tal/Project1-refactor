package com.revature.reimbursement.unit.Dao;

import com.revature.reimbursement.dao.ReimbursementTypeRepository;
import com.revature.reimbursement.model.ReimbursementType;
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
class ReimbursementTypeDaoTest {

    private ReimbursementType lodging;
    private ReimbursementType travel;
    private ReimbursementType food;
    private ReimbursementType other;

    @Autowired
    ReimbursementTypeRepository reimbTypeRepo;

    @BeforeAll
    void init() {
        lodging = new ReimbursementType(1, "Lodging");
        travel = new ReimbursementType(2, "Travel");
        food = new ReimbursementType(3, "Food");
        other = new ReimbursementType(4, "Other");
    }

    @Test
    void test_getAllReimbType_positive() {
        List<ReimbursementType> types = reimbTypeRepo.findAll();

        assertThat(types).hasSize(4)
                .contains(lodging)
                .contains(food)
                .contains(travel)
                .contains(other);
    }

    @Test
    void test_getNonExistentReimbursementType_negative() {
        Optional<ReimbursementType> type = reimbTypeRepo.findById(5);

        assertThat(type).isNotPresent();
    }

}
