package org.jmresler.fbi.nibrs;

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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "est_drug_qty", precision = 17, scale = 17)
    private Double estDrugQty;
    @Id
    @Basic(optional = false)
    @Column(name = "nibrs_suspected_drug_id", nullable = false)
    private Long nibrsSuspectedDrugId;
    @JoinColumn(name = "drug_measure_type_id", referencedColumnName = "drug_measure_type_id")
    @ManyToOne
    private NibrsDrugMeasureType drugMeasureTypeId;
    @JoinColumn(name = "property_id", referencedColumnName = "property_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsProperty propertyId;
    @JoinColumn(name = "suspected_drug_type_id", referencedColumnName = "suspected_drug_type_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsSuspectedDrugType suspectedDrugTypeId;
}