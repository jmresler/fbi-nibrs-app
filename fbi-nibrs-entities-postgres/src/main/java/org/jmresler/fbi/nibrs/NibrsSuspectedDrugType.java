package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_suspected_drug_type", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "suspectedDrugTypeId")
public class NibrsSuspectedDrugType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "suspected_drug_type_id", nullable = false)
    private Short suspectedDrugTypeId;
    @Column(name = "suspected_drug_code")
    private Character suspectedDrugCode;
    @Column(name = "suspected_drug_name", length = 100)
    private String suspectedDrugName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suspectedDrugTypeId")
    private List<NibrsSuspectedDrug> nibrsSuspectedDrugList;
}
