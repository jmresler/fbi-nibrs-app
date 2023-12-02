package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author johnm
 */
@Data
@Entity
@Table(name = "nibrs_suspected_drug", catalog = "nibrs", schema = "public")
public class NibrsSuspectedDrug implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "est_drug_qty", precision = 17)
    private Double estDrugQty;
    @Id
    @Column(name = "nibrs_suspected_drug_id", nullable = false)
    private Long nibrsSuspectedDrugId;
    @JsonBackReference
    @JoinColumn(name = "drug_measure_type_id", referencedColumnName = "drug_measure_type_id")
    @ManyToOne
    private NibrsDrugMeasureType drugMeasureTypeId;
    @JsonBackReference
    @JoinColumn(name = "property_id", referencedColumnName = "property_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsProperty propertyId;
    @JsonBackReference
    @JoinColumn(name = "suspected_drug_type_id", referencedColumnName = "suspected_drug_type_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsSuspectedDrugType suspectedDrugTypeId;
}
