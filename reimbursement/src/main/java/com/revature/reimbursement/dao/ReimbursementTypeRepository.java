package com.revature.reimbursement.dao;

import com.revature.reimbursement.model.ReimbursementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbursementTypeRepository extends JpaRepository<ReimbursementType, Integer> {
}
