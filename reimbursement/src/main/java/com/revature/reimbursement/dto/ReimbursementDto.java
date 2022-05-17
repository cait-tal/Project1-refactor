package com.revature.reimbursement.dto;

import com.revature.reimbursement.model.ReimbursementStatus;
import com.revature.reimbursement.model.ReimbursementType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReimbursementDto {

    private Double amount;

    private Timestamp submitDate;
    private Timestamp resolveDate;
    private String description;
    private String receiptUrl;
    private UserDto author;
    private UserDto resolver;
    private ReimbursementStatus status;
    private ReimbursementType type;

}
