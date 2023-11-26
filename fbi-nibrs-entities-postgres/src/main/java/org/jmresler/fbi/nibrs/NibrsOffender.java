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
    @JoinColumn(name = "age_id", referencedColumnName = "age_id")
    @ManyToOne
    private NibrsAge ageId;
    @JoinColumn(name = "ethnicity_id", referencedColumnName = "ethnicity_id")
    @ManyToOne
    private NibrsEthnicity ethnicityId;
    @JoinColumn(name = "incident_id", referencedColumnName = "incident_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsIncident incidentId;
    @JoinColumn(name = "race_id", referencedColumnName = "race_id")
    @ManyToOne
    private RefRace raceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffender")
    private Collection<NibrsVictimOffenderRel> nibrsVictimOffenderRelCollection;
}
