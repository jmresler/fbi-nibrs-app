package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "nibrs_property", catalog = "nibrs", schema = "public")
public class NibrsProperty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "data_year")
    private Integer dataYear;
    @Id
    @Basic(optional = false)
    @Column(name = "property_id", nullable = false)
    private Long propertyId;
    @Column(name = "stolen_count")
    private Short stolenCount;
    @Column(name = "recovered_count")
    private Short recoveredCount;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsProperty")
    private List<NibrsPropertyDesc> nibrsPropertyDescList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyId")
    private List<NibrsSuspectedDrug> nibrsSuspectedDrugList;
    @JsonBackReference
    @JoinColumn(name = "incident_id", referencedColumnName = "incident_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsIncident incidentId;
    @JsonBackReference
    @JoinColumn(name = "prop_loss_id", referencedColumnName = "prop_loss_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsPropLossType propLossId;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsProperty{");
        sb.append("dataYear=").append(dataYear);
        sb.append(", incidentId=").append(incidentId);
        sb.append(", propertyId=").append(propertyId);
        sb.append(", propLossId=").append(propLossId);
        sb.append(", recoveredCount=").append(recoveredCount);
        sb.append(", stolenCount=").append(stolenCount);
        sb.append('}');
        return sb.toString();
    }
}
