package org.jmresler.fbi.nibrs;

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
    @Basic(optional = false)
    @Column(name = "offense_id", nullable = false)
    private Long offenseId;
    @Column(name = "attempt_complete_flag")
    private Character attemptCompleteFlag;
    @Column(name = "num_premises_entered")
    private Short numPremisesEntered;
    @Column(name = "method_entry_code")
    private Character methodEntryCode;
    @JoinColumn(name = "incident_id", referencedColumnName = "incident_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsIncident incidentId;
    @JoinColumn(name = "location_id", referencedColumnName = "location_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsLocationType locationId;
    @JoinColumn(name = "offense_code", referencedColumnName = "offense_code", nullable = false)
    @ManyToOne(optional = false)
    private NibrsOffenseType offenseCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private Collection<NibrsVictimOffense> nibrsVictimOffenseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private Collection<NibrsWeapon> nibrsWeaponCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private Collection<NibrsCriminalAct> nibrsCriminalActCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private Collection<NibrsBiasMotivation> nibrsBiasMotivationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private Collection<NibrsSuspectUsing> nibrsSuspectUsingCollection;
}
