package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import lombok.Data;

/**
 *
 * @author johnm
 */
@Data
@Entity
@Table(name = "nibrs_drug_measure_type", catalog = "nibrs", schema = "public")
public class NibrsDrugMeasureType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "drug_measure_type_id", nullable = false)
    private Short drugMeasureTypeId;
    @Column(name = "drug_measure_code", length = 2)
    private String drugMeasureCode;
    @Column(name = "drug_measure_name", length = 100)
    private String drugMeasureName;
    @JsonManagedReference
    @OneToMany(mappedBy = "drugMeasureTypeId")
    private Collection<NibrsSuspectedDrug> nibrsSuspectedDrugCollection;
}
