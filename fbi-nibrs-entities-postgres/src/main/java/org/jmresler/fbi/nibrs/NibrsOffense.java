package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "nibrs_offense", catalog = "nibrs", schema = "public")
public class NibrsOffense implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "data_year")
    private Integer dataYear;
    @Id
    @Column(name = "offense_id", nullable = false)
    private Long offenseId;
    @Column(name = "attempt_complete_flag")
    private Character attemptCompleteFlag;
    @Column(name = "num_premises_entered")
    private Short numPremisesEntered;
    @Column(name = "method_entry_code")
    private Character methodEntryCode;
    @JsonBackReference
    @JoinColumn(name = "incident_id", referencedColumnName = "incident_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsIncident incidentId;
    @JsonBackReference
    @JoinColumn(name = "location_id", referencedColumnName = "location_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsLocationType locationId;
    @JsonBackReference
    @JoinColumn(name = "offense_code", referencedColumnName = "offense_code", nullable = false)
    @ManyToOne(optional = false)
    private NibrsOffenseType offenseCode;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private Collection<NibrsVictimOffense> nibrsVictimOffenseCollection;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private Collection<NibrsWeapon> nibrsWeaponCollection;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private Collection<NibrsCriminalAct> nibrsCriminalActCollection;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private Collection<NibrsBiasMotivation> nibrsBiasMotivationCollection;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private Collection<NibrsSuspectUsing> nibrsSuspectUsingCollection;
}
