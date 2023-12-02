package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "nibrs_victim", catalog = "nibrs", schema = "public")
public class NibrsVictim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "data_year")
    private Integer dataYear;
    @Id
    @Basic(optional = false)
    @Column(name = "victim_id", nullable = false)
    private Long victimId;
    @Column(name = "victim_seq_num")
    private Short victimSeqNum;
    @Column(name = "outside_agency_id")
    private BigInteger outsideAgencyId;
    @Column(name = "age_num", length = 2)
    private String ageNum;
    @Column(name = "sex_code")
    private Character sexCode;
    @Column(name = "resident_status_code")
    private Character residentStatusCode;
    @Column(name = "age_range_low_num")
    private Short ageRangeLowNum;
    @Column(name = "age_range_high_num")
    private Short ageRangeHighNum;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsVictim")
    private List<NibrsVictimOffense> nibrsVictimOffenseList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsVictim")
    private List<NibrsVictimCircumstances> nibrsVictimCircumstancesList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsVictim")
    private List<NibrsVictimInjury> nibrsVictimInjuryList;
    @JsonManagedReference
    @JoinColumn(name = "activity_type_id", referencedColumnName = "activity_type_id")
    @ManyToOne
    private NibrsActivityType activityTypeId;
    @JsonManagedReference
    @JoinColumn(name = "age_id", referencedColumnName = "age_id")
    @ManyToOne
    private NibrsAge ageId;
    @JsonBackReference
    @JoinColumn(name = "assignment_type_id", referencedColumnName = "assignment_type_id")
    @ManyToOne
    private NibrsAssignmentType assignmentTypeId;
    @JsonBackReference
    @JoinColumn(name = "ethnicity_id", referencedColumnName = "ethnicity_id")
    @ManyToOne
    private NibrsEthnicity ethnicityId;
    @JsonBackReference
    @JoinColumn(name = "incident_id", referencedColumnName = "incident_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsIncident incidentId;
    @JsonBackReference
    @JoinColumn(name = "victim_type_id", referencedColumnName = "victim_type_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsVictimType victimTypeId;
    @JsonBackReference
    @JoinColumn(name = "race_id", referencedColumnName = "race_id")
    @ManyToOne
    private RefRace raceId;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsVictim")
    private List<NibrsVictimOffenderRel> nibrsVictimOffenderRelList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsVictim{");
        sb.append("activityTypeId=").append(activityTypeId);
        sb.append(", ageId=").append(ageId);
        sb.append(", ageNum='").append(ageNum).append('\'');
        sb.append(", ageRangeHighNum=").append(ageRangeHighNum);
        sb.append(", ageRangeLowNum=").append(ageRangeLowNum);
        sb.append(", assignmentTypeId=").append(assignmentTypeId);
        sb.append(", dataYear=").append(dataYear);
        sb.append(", ethnicityId=").append(ethnicityId);
        sb.append(", incidentId=").append(incidentId);
        sb.append(", outsideAgencyId=").append(outsideAgencyId);
        sb.append(", raceId=").append(raceId);
        sb.append(", residentStatusCode=").append(residentStatusCode);
        sb.append(", sexCode=").append(sexCode);
        sb.append(", victimId=").append(victimId);
        sb.append(", victimSeqNum=").append(victimSeqNum);
        sb.append(", victimTypeId=").append(victimTypeId);
        sb.append('}');
        return sb.toString();
    }
}
