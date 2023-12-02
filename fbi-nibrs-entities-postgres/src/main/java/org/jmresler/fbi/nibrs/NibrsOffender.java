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
@Table(name = "nibrs_offender", catalog = "nibrs", schema = "public")
public class NibrsOffender implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "data_year")
    private Integer dataYear;
    @Id
    @Basic(optional = false)
    @Column(name = "offender_id", nullable = false)
    private Long offenderId;
    @Column(name = "offender_seq_num")
    private Short offenderSeqNum;
    @Column(name = "age_num", length = 3)
    private String ageNum;
    @Column(name = "sex_code")
    private Character sexCode;
    @Column(name = "age_range_low_num")
    private Short ageRangeLowNum;
    @Column(name = "age_range_high_num")
    private Short ageRangeHighNum;
    @JsonBackReference
    @JoinColumn(name = "age_id", referencedColumnName = "age_id")
    @ManyToOne
    private NibrsAge ageId;
    @JsonBackReference
    @JoinColumn(name = "ethnicity_id", referencedColumnName = "ethnicity_id")
    @ManyToOne
    private NibrsEthnicity ethnicityId;
    @JsonBackReference
    @JoinColumn(name = "incident_id", referencedColumnName = "incident_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsIncident incidentId;
    @JsonBackReference
    @JoinColumn(name = "race_id", referencedColumnName = "race_id")
    @ManyToOne
    private RefRace raceId;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffender")
    private List<NibrsVictimOffenderRel> nibrsVictimOffenderRelList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsOffender{");
        sb.append("ageId=").append(ageId);
        sb.append(", ageNum='").append(ageNum).append('\'');
        sb.append(", ageRangeHighNum=").append(ageRangeHighNum);
        sb.append(", ageRangeLowNum=").append(ageRangeLowNum);
        sb.append(", dataYear=").append(dataYear);
        sb.append(", ethnicityId=").append(ethnicityId);
        sb.append(", incidentId=").append(incidentId);
        sb.append(", offenderId=").append(offenderId);
        sb.append(", offenderSeqNum=").append(offenderSeqNum);
        sb.append(", raceId=").append(raceId);
        sb.append(", sexCode=").append(sexCode);
        sb.append('}');
        return sb.toString();
    }
}
