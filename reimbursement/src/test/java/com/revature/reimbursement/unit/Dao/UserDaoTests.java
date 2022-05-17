package com.revature.reimbursement.unit.Dao;

import com.revature.reimbursement.dao.UserRepository;
import com.revature.reimbursement.model.User;
import com.revature.reimbursement.model.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserDaoTests {

    @Autowired
    private UserRepository userRepo;

    @Test
    void test_findAllUsers_TestDataIsBeingLoaded() {
        List<User> users = userRepo.findAll();
        for(User user: users) {
            System.out.println(user);
        }

        assertThat(users).hasSize(3);
    }

    @Test
    void test_findByUsernameAndPasswordPositive() {
        Optional<User> actual = userRepo.findByUsernameAndPassword("CatMom1", "ilovemycats!");

        UserRole expectedRole = new UserRole(2, "Finance");

        User expected = new User(1, "CatMom1", "ilovemycats!", "Angela", "Martin", "angela_martin1@dundermifflen.net", expectedRole);
        User userActual = actual.get();
        assertThat(userActual).isEqualTo(expected);
        assertThat(actual).isPresent();
    }

    @Test
    void test_findByInvalidUsernameAndPasswordNegative() {
        assertThat(userRepo.findByUsernameAndPassword("CatMom1", "badPassword")).isNotPresent();
    }
}
