package org.jmresler.fbi.nibrs;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author johnm
 */
@Data
@Entity
@Table(name = "nibrs_incident", catalog = "nibrs", schema = "public")
public class NibrsIncident implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "data_year")
    private Integer dataYear;
    @Id
    @Basic(optional = false)
    @Column(name = "incident_id", nullable = false)
    private Long incidentId;
    @Basic(optional = false)
    @Column(name = "nibrs_month_id", nullable = false)
    private long nibrsMonthId;
    @Column(name = "cargo_theft_flag")
    private Character cargoTheftFlag;
    @Column(name = "submission_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate;
    @Column(name = "incident_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date incidentDate;
    @Column(name = "report_date_flag")
    private Character reportDateFlag;
    @Column(name = "incident_hour")
    private Short incidentHour;
    @Column(name = "cleared_except_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date clearedExceptDate;
    @Column(name = "incident_status", length = 100)
    private String incidentStatus;
    @Column(name = "data_home")
    private Character dataHome;
    @Column(name = "orig_format")
    private Character origFormat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private Collection<NibrsArrestee> nibrsArresteeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private Collection<NibrsOffense> nibrsOffenseCollection;
    @JoinColumn(name = "agency_id", referencedColumnName = "agency_id", nullable = false)
    @ManyToOne(optional = false)
    private Agencies agencyId;
    @JoinColumn(name = "cleared_except_id", referencedColumnName = "cleared_except_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsClearedExcept clearedExceptId;
    @JoinColumn(name = "did", referencedColumnName = "did")
    @ManyToOne
    private NibrsMonth did;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private Collection<NibrsOffender> nibrsOffenderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private Collection<NibrsProperty> nibrsPropertyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private Collection<NibrsVictim> nibrsVictimCollection;
}
