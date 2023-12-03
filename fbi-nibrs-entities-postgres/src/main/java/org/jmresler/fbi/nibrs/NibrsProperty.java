package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_property", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "propertyId")
public class NibrsProperty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "property_id", nullable = false)
    private Long propertyId;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "stolen_count")
    private Short stolenCount;
    @Column(name = "recovered_count")
    private Short recoveredCount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsProperty")
    private List<NibrsPropertyDesc> nibrsPropertyDescList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyId")
    private List<NibrsSuspectedDrug> nibrsSuspectedDrugList;
    @JoinColumn(name = "incident_id", referencedColumnName = "incident_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsIncident incidentId;
    @JoinColumn(name = "prop_loss_id", referencedColumnName = "prop_loss_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsPropLossType propLossId;
}
