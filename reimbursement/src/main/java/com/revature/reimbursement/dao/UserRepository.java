package com.revature.reimbursement.dao;

import com.revature.reimbursement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public abstract User findByUsernameAndPassword(String username, String password);
}
