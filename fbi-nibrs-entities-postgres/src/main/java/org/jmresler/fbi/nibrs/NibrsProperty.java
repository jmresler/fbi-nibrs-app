package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "nibrs_property", catalog = "nibrs", schema = "public")
public class NibrsProperty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "data_year")
    private Integer dataYear;
    @Id
    @Column(name = "property_id", nullable = false)
    private Long propertyId;
    @Column(name = "stolen_count")
    private Short stolenCount;
    @Column(name = "recovered_count")
    private Short recoveredCount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsProperty")
    private Collection<NibrsPropertyDesc> nibrsPropertyDescCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyId")
    private Collection<NibrsSuspectedDrug> nibrsSuspectedDrugCollection;
    @JsonBackReference
    @JoinColumn(name = "incident_id", referencedColumnName = "incident_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsIncident incidentId;
    @JsonBackReference
    @JoinColumn(name = "prop_loss_id", referencedColumnName = "prop_loss_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsPropLossType propLossId;
}
