package org.jmresler.fbi.nibrs;

import jakarta.persistence.Basic;
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
import java.util.Collection;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author johnm
 */
@Data
@Entity
@Table(name = "nibrs_month", catalog = "nibrs", schema = "public")
public class NibrsMonth implements Serializable {

    private static final long serialVersionUID = 1L;
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
    @Id
    @Basic(optional = false)
    @Column(name = "did", nullable = false)
    private Long did;
    @Column(name = "month_pub_status")
    private Integer monthPubStatus;
    @JoinColumn(name = "agency_id", referencedColumnName = "agency_id", nullable = false)
    @ManyToOne(optional = false)
    private Agencies agencyId;
    @OneToMany(mappedBy = "did")
    private Collection<NibrsIncident> nibrsIncidentCollection;
}
