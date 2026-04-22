package org.example.session13_b3.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prescriptions")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patientName;
    @OneToMany(
            mappedBy = "prescription",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<PrescriptionDetail> details = new ArrayList<>();

    public void addDetail(PrescriptionDetail detail) {
        details.add(detail);
        detail.setPrescription(this);
    }

    public void removeDetail(PrescriptionDetail detail){
        details.remove(detail);
        detail.setPrescription(null);
    }
}
