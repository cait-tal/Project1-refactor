package com.revature.reimbursement.dao;

import com.revature.reimbursement.model.ReimbursementStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbursementStatusRepository extends JpaRepository<ReimbursementStatus, Integer> {
}
