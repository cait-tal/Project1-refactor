package com.revature.reimbursement.unit.Dao;

import com.revature.reimbursement.dao.UserRoleRepository;
import com.revature.reimbursement.model.UserRole;
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
class UserRoleDaoTest {

    private UserRole role1;
    private UserRole role2;
    private UserRole role3;
    private UserRole role4;
    private UserRole role5;
    private UserRole role6;
    private UserRole role7;

    @Autowired
    UserRoleRepository userRoleRepo;

    @BeforeAll
    void init() {
        role1 = new UserRole(1, "Management");
        role2 = new UserRole(2, "Finance");
        role3 = new UserRole(3, "HR");
        role4 = new UserRole(4, "IT");
        role5 = new UserRole(5, "Marketing");
        role6 = new UserRole(6, "Sales");
        role7 = new UserRole(7, "Quality Assurance");
    }

    @Test
    void test_getAllUserRoles_positive() {
        List<UserRole> roles = userRoleRepo.findAll();

        assertThat(roles).hasSize(7)
                .contains(role1)
                .contains(role2)
                .contains(role3)
                .contains(role4)
                .contains(role5)
                .contains(role6)
                .contains(role7);
    }

    @Test
    void test_getNonExistentRole_negative() {
        Optional<UserRole> role = userRoleRepo.findById(500);

        assertThat(role).isNotPresent();
    }


}
