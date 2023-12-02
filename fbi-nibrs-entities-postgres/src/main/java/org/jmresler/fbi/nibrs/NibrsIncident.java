package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
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
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private List<NibrsArrestee> nibrsArresteeList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private List<NibrsOffense> nibrsOffenseList;
    @JsonBackReference
    @JoinColumn(name = "agency_id", referencedColumnName = "agency_id", nullable = false)
    @ManyToOne(optional = false)
    private Agencies agencyId;
    @JsonBackReference
    @JoinColumn(name = "cleared_except_id", referencedColumnName = "cleared_except_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsClearedExcept clearedExceptId;
    @JsonBackReference
    @JoinColumn(name = "did", referencedColumnName = "did")
    @ManyToOne
    private NibrsMonth did;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private List<NibrsOffender> nibrsOffenderList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private List<NibrsProperty> nibrsPropertyList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private List<NibrsVictim> nibrsVictimList;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsIncident{");
        sb.append("agencyId=").append(agencyId);
        sb.append(", cargoTheftFlag=").append(cargoTheftFlag);
        sb.append(", clearedExceptDate=").append(clearedExceptDate);
        sb.append(", clearedExceptId=").append(clearedExceptId);
        sb.append(", dataHome=").append(dataHome);
        sb.append(", dataYear=").append(dataYear);
        sb.append(", did=").append(did);
        sb.append(", incidentDate=").append(incidentDate);
        sb.append(", incidentHour=").append(incidentHour);
        sb.append(", incidentId=").append(incidentId);
        sb.append(", incidentStatus='").append(incidentStatus).append('\'');
        sb.append(", nibrsMonthId=").append(nibrsMonthId);
        sb.append(", origFormat=").append(origFormat);
        sb.append(", reportDateFlag=").append(reportDateFlag);
        sb.append(", submissionDate=").append(submissionDate);
        sb.append('}');
        return sb.toString();
    }
}
