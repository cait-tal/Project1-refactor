package com.revature.reimbursement.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="reimbursements")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Reimbursement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="reimb_amount")
    private Long amount;

    @Column(name="reimb_submitted")
    private Timestamp submitDate;

    @Column(name="reimb_resolved")
    private Timestamp resolveDate;

    @Column(name="reimb_description")
    private String description;

    @Column(name="reimb_receipt")
    private String receiptUrl;

    @ManyToOne
    @JoinColumn(name="reimb_author_id")
    private User author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="reimb_resolver_id", referencedColumnName = "id")
    private User resolver;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="reimb_status_id")
    private ReimbursementStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="reimb_type_id")
    private ReimbursementType type;
}
