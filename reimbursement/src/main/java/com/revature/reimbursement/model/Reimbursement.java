package com.revature.reimbursement.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="reimbursements")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Reimbursement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @JoinColumn(name="reimb_author_id")
    @ManyToOne
    private User author;

    @JoinColumn(name="reimb_resolver_id")
    @ManyToOne
    private User resolver;

    @JoinColumn(name="reimb_status_id")
    @ColumnDefault("202")
    @ManyToOne
    private ReimbursementStatus status;

    @JoinColumn(name="reimb_type_id")
    @ManyToOne
    private ReimbursementType type;
}
