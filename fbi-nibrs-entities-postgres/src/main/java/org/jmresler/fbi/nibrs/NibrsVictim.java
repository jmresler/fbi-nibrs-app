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
import java.math.BigInteger;
import java.util.Collection;
import lombok.Data;

/**
 *
 * @author johnm
 */
@Data
@Entity
@Table(name = "nibrs_victim", catalog = "nibrs", schema = "public")
public class NibrsVictim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "data_year")
    private Integer dataYear;
    @Id
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
    private Collection<NibrsVictimOffense> nibrsVictimOffenseCollection;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsVictim")
    private Collection<NibrsVictimCircumstances> nibrsVictimCircumstancesCollection;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsVictim")
    private Collection<NibrsVictimInjury> nibrsVictimInjuryCollection;
    @JsonBackReference
    @JoinColumn(name = "activity_type_id", referencedColumnName = "activity_type_id")
    @ManyToOne
    private NibrsActivityType activityTypeId;
    @JsonBackReference
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
    private Collection<NibrsVictimOffenderRel> nibrsVictimOffenderRelCollection;
}
