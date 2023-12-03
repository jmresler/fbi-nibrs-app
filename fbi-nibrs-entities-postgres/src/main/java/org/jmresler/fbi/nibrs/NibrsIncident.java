package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_incident", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "incidentId")
public class NibrsIncident implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "incident_id", nullable = false)
    private Long incidentId;
    @Column(name = "data_year")
    private Integer dataYear;
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
    private List<NibrsArrestee> nibrsArresteeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private List<NibrsOffense> nibrsOffenseList;
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
    private List<NibrsOffender> nibrsOffenderList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private List<NibrsProperty> nibrsPropertyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private List<NibrsVictim> nibrsVictimList;

}
