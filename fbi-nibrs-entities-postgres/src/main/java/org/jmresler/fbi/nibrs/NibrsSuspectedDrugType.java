package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "nibrs_suspected_drug_type", catalog = "nibrs", schema = "public")
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
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suspectedDrugTypeId")
    private List<NibrsSuspectedDrug> nibrsSuspectedDrugList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsSuspectedDrugType{");
        sb.append("suspectedDrugCode=").append(suspectedDrugCode);
        sb.append(", suspectedDrugName='").append(suspectedDrugName).append('\'');
        sb.append(", suspectedDrugTypeId=").append(suspectedDrugTypeId);
        sb.append('}');
        return sb.toString();
    }
}
