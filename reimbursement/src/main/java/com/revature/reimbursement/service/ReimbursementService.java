package com.revature.reimbursement.service;

import com.revature.reimbursement.dao.ReimbursementRepository;
import com.revature.reimbursement.dto.ReimbursementDto;
import com.revature.reimbursement.model.Reimbursement;
import org.hibernate.annotations.NotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ReimbursementService {

    @Autowired
    private ReimbursementRepository reimbRepo;

    @Autowired
    private ModelMapper modelMapper;

    public ReimbursementDto findreimbursementById(int id) {
        Optional<Reimbursement> reimbursement = reimbRepo.findById(id);

        if(reimbursement.isPresent()) {
            return modelMapper.map(reimbursement.get(), ReimbursementDto.class);
        }

        throw new NoSuchElementException("A reimbursement with an id of " + id + " does not exist.");
    }

    public List<ReimbursementDto> findAllReimbursements() {
        List<Reimbursement> results = reimbRepo.findAll();
        List<ReimbursementDto> reimbursements = new ArrayList<>();
        for(Reimbursement reimbursement: results) {
            reimbursements.add(modelMapper.map(reimbursement, ReimbursementDto.class));
        }
        return reimbursements;
    }
}
