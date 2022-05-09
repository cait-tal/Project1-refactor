package com.revature.reimbursement.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="reimbursement_types")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ReimbursementType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="reimb_type")
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementType that = (ReimbursementType) o;
        return id == that.id && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return "ReimbursementType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
