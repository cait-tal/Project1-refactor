package com.revature.reimbursement.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name="reimbursements")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor  @RequiredArgsConstructor
public class Reimbursement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="reimb_amount")
    @NonNull
    private Double amount;

    @Column(name="reimb_submitted")
    @NonNull
    private Timestamp submitDate;

    @Column(name="reimb_resolved")
    private Timestamp resolveDate;

    @Column(name="reimb_description")
    @NonNull
    private String description;

    @Column(name="reimb_receipt")
    @NonNull
    private String receiptUrl;

    @ManyToOne
    @JoinColumn(name="reimb_author_id")
    @NonNull
    private User author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="reimb_resolver_id", referencedColumnName = "id")
    private User resolver;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="reimb_status_id")
    @NonNull
    private ReimbursementStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="reimb_type_id")
    @NonNull
    private ReimbursementType type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return id == that.id && Objects.equals(amount, that.amount) && Objects.equals(submitDate, that.submitDate) && Objects.equals(resolveDate, that.resolveDate) && Objects.equals(description, that.description) && Objects.equals(receiptUrl, that.receiptUrl) && Objects.equals(author, that.author) && Objects.equals(resolver, that.resolver) && Objects.equals(status, that.status) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, submitDate, resolveDate, description, receiptUrl, author, resolver, status, type);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", amount=" + amount +
                ", submitDate=" + submitDate +
                ", resolveDate=" + resolveDate +
                ", description='" + description + '\'' +
                ", receiptUrl='" + receiptUrl + '\'' +
                ", author=" + author +
                ", resolver=" + resolver +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
