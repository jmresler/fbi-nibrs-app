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
@Table(name = "nibrs_month", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "did")
public class NibrsMonth implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "did", nullable = false)
    private Long did;
    @Column(name = "data_year")
    private Integer dataYear;
    @Basic(optional = false)
    @Column(name = "nibrs_month_id", nullable = false)
    private long nibrsMonthId;
    @Basic(optional = false)
    @Column(name = "month_num", nullable = false)
    private short monthNum;
    @Column(name = "inc_data_year")
    private Integer incDataYear;
    @Column(name = "reported_status", length = 10)
    private String reportedStatus;
    @Column(name = "report_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportDate;
    @Column(name = "update_flag")
    private Character updateFlag;
    @Basic(optional = false)
    @Column(name = "orig_format", nullable = false)
    private Character origFormat;
    @Column(name = "data_home", length = 10)
    private String dataHome;
    @Column(name = "ddocname", length = 50)
    private String ddocname;
    @Column(name = "month_pub_status")
    private Integer monthPubStatus;
    @JoinColumn(name = "agency_id", referencedColumnName = "agency_id", nullable = false)
    @ManyToOne(optional = false)
    private Agencies agencyId;
    @OneToMany(mappedBy = "did")
    private List<NibrsIncident> nibrsIncidentList;

}
