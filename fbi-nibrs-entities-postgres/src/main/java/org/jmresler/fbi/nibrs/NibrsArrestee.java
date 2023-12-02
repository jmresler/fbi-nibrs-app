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
import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "nibrs_arrestee", catalog = "nibrs", schema = "public")
public class NibrsArrestee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "data_year")
    private Integer dataYear;
    @Id
    @Basic(optional = false)
    @Column(name = "arrestee_id", nullable = false)
    private Long arresteeId;
    @Column(name = "arrestee_seq_num")
    private BigInteger arresteeSeqNum;
    @Column(name = "arrest_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrestDate;
    @Column(name = "multiple_indicator")
    private Character multipleIndicator;
    @Column(name = "age_num")
    private Short ageNum;
    @Column(name = "sex_code")
    private Character sexCode;
    @Column(name = "resident_code")
    private Character residentCode;
    @Column(name = "under_18_disposition_code")
    private Character under18DispositionCode;
    @Column(name = "clearance_ind")
    private Character clearanceInd;
    @Column(name = "age_range_low_num")
    private Short ageRangeLowNum;
    @Column(name = "age_range_high_num")
    private Short ageRangeHighNum;
    @JsonBackReference
    @JoinColumn(name = "age_id", referencedColumnName = "age_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsAge ageId;
    @JsonBackReference
    @JoinColumn(name = "arrest_type_id", referencedColumnName = "arrest_type_id")
    @ManyToOne
    private NibrsArrestType arrestTypeId;
    @JsonBackReference
    @JoinColumn(name = "ethnicity_id", referencedColumnName = "ethnicity_id")
    @ManyToOne
    private NibrsEthnicity ethnicityId;
    @JsonBackReference
    @JoinColumn(name = "incident_id", referencedColumnName = "incident_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsIncident incidentId;
    @JsonBackReference
    @JoinColumn(name = "offense_code", referencedColumnName = "offense_code", nullable = false)
    @ManyToOne(optional = false)
    private NibrsOffenseType offenseCode;
    @JsonBackReference
    @JoinColumn(name = "race_id", referencedColumnName = "race_id", nullable = false)
    @ManyToOne(optional = false)
    private RefRace raceId;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsArrestee")
    private List<NibrsArresteeWeapon> nibrsArresteeWeaponList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsArrestee{");
        sb.append("ageId=").append(ageId);
        sb.append(", ageNum=").append(ageNum);
        sb.append(", ageRangeHighNum=").append(ageRangeHighNum);
        sb.append(", ageRangeLowNum=").append(ageRangeLowNum);
        sb.append(", arrestDate=").append(arrestDate);
        sb.append(", arresteeId=").append(arresteeId);
        sb.append(", arresteeSeqNum=").append(arresteeSeqNum);
        sb.append(", arrestTypeId=").append(arrestTypeId);
        sb.append(", clearanceInd=").append(clearanceInd);
        sb.append(", dataYear=").append(dataYear);
        sb.append(", ethnicityId=").append(ethnicityId);
        sb.append(", incidentId=").append(incidentId);
        sb.append(", multipleIndicator=").append(multipleIndicator);
        sb.append(", offenseCode=").append(offenseCode);
        sb.append(", raceId=").append(raceId);
        sb.append(", residentCode=").append(residentCode);
        sb.append(", sexCode=").append(sexCode);
        sb.append(", under18DispositionCode=").append(under18DispositionCode);
        sb.append('}');
        return sb.toString();
    }
}
