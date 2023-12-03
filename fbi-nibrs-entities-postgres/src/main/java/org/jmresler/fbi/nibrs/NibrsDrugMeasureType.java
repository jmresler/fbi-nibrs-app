package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_drug_measure_type", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "drugMeasureTypeId")
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
    @OneToMany(mappedBy = "drugMeasureTypeId")
    private List<NibrsSuspectedDrug> nibrsSuspectedDrugList;
}
