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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author johnm
 */
@Data
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
    @JoinColumn(name = "age_id", referencedColumnName = "age_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsAge ageId;
    @JoinColumn(name = "arrest_type_id", referencedColumnName = "arrest_type_id")
    @ManyToOne
    private NibrsArrestType arrestTypeId;
    @JoinColumn(name = "ethnicity_id", referencedColumnName = "ethnicity_id")
    @ManyToOne
    private NibrsEthnicity ethnicityId;
    @JoinColumn(name = "incident_id", referencedColumnName = "incident_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsIncident incidentId;
    @JoinColumn(name = "offense_code", referencedColumnName = "offense_code", nullable = false)
    @ManyToOne(optional = false)
    private NibrsOffenseType offenseCode;
    @JoinColumn(name = "race_id", referencedColumnName = "race_id", nullable = false)
    @ManyToOne(optional = false)
    private RefRace raceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsArrestee")
    private Collection<NibrsArresteeWeapon> nibrsArresteeWeaponCollection;
}