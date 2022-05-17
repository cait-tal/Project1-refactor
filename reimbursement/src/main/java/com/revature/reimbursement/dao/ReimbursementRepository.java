package com.revature.reimbursement.dao;

import com.revature.reimbursement.model.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReimbursementRepository extends JpaRepository<Reimbursement, Integer> {

    List<Reimbursement> findByAuthorId(int id);

    List<Reimbursement> findByStatusId(int id);

    List<Reimbursement> findByTypeId(int id);
}
