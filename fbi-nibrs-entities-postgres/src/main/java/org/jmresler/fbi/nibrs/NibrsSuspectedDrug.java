package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "nibrs_suspected_drug", catalog = "nibrs", schema = "public")
public class NibrsSuspectedDrug implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "est_drug_qty", precision = 17)
    private Double estDrugQty;
    @Id
    @Basic(optional = false)
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsSuspectedDrug{");
        sb.append("dataYear=").append(dataYear);
        sb.append(", drugMeasureTypeId=").append(drugMeasureTypeId);
        sb.append(", estDrugQty=").append(estDrugQty);
        sb.append(", nibrsSuspectedDrugId=").append(nibrsSuspectedDrugId);
        sb.append(", propertyId=").append(propertyId);
        sb.append(", suspectedDrugTypeId=").append(suspectedDrugTypeId);
        sb.append('}');
        return sb.toString();
    }
}
