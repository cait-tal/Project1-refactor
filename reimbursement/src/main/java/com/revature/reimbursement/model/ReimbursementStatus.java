package com.revature.reimbursement.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="reimbursement_status")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ReimbursementStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="reimb_status")
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementStatus that = (ReimbursementStatus) o;
        return id == that.id && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }

    @Override
    public String toString() {
        return "ReimbursementStatus{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
