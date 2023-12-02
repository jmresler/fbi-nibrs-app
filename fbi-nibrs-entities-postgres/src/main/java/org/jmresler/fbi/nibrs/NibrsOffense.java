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
    private List<NibrsVictimOffense> nibrsVictimOffenseList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private List<NibrsWeapon> nibrsWeaponList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private List<NibrsCriminalAct> nibrsCriminalActList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private List<NibrsBiasMotivation> nibrsBiasMotivationList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private List<NibrsSuspectUsing> nibrsSuspectUsingList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsOffense{");
        sb.append("attemptCompleteFlag=").append(attemptCompleteFlag);
        sb.append(", dataYear=").append(dataYear);
        sb.append(", incidentId=").append(incidentId);
        sb.append(", locationId=").append(locationId);
        sb.append(", methodEntryCode=").append(methodEntryCode);
        sb.append(", numPremisesEntered=").append(numPremisesEntered);
        sb.append(", offenseCode=").append(offenseCode);
        sb.append(", offenseId=").append(offenseId);
        sb.append('}');
        return sb.toString();
    }
}
