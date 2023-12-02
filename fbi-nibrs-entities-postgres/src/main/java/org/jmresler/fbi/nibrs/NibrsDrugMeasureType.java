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
@Table(name = "nibrs_drug_measure_type", catalog = "nibrs", schema = "public")
public class NibrsDrugMeasureType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "drug_measure_type_id", nullable = false)
    private Short drugMeasureTypeId;
    @Column(name = "drug_measure_code", length = 2)
    private String drugMeasureCode;
    @Column(name = "drug_measure_name", length = 100)
    private String drugMeasureName;
    @JsonManagedReference
    @OneToMany(mappedBy = "drugMeasureTypeId")
    private List<NibrsSuspectedDrug> nibrsSuspectedDrugList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsDrugMeasureType{");
        sb.append("drugMeasureCode='").append(drugMeasureCode).append('\'');
        sb.append(", drugMeasureName='").append(drugMeasureName).append('\'');
        sb.append(", drugMeasureTypeId=").append(drugMeasureTypeId);
        sb.append('}');
        return sb.toString();
    }
}
