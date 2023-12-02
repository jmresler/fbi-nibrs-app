package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
@Table(name = "agencies", catalog = "nibrs", schema = "public")
public class Agencies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "yearly_agency_id")
    private Integer yearlyAgencyId;
    @Id
    @Basic(optional = false)
    @Column(name = "agency_id", nullable = false)
    private Integer agencyId;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "ori", length = 25)
    private String ori;
    @Column(name = "legacy_ori", length = 25)
    private String legacyOri;
    @Column(name = "covered_by_legacy_ori", length = 25)
    private String coveredByLegacyOri;
    @Column(name = "direct_contributor_flag", length = 1)
    private String directContributorFlag;
    @Column(name = "dormant_flag", length = 1)
    private String dormantFlag;
    @Column(name = "dormant_year")
    private Integer dormantYear;
    @Column(name = "reporting_type", length = 1)
    private String reportingType;
    @Column(name = "ucr_agency_name", length = 100)
    private String ucrAgencyName;
    @Column(name = "ncic_agency_name", length = 100)
    private String ncicAgencyName;
    @Column(name = "pub_agency_name", length = 100)
    private String pubAgencyName;
    @Column(name = "pub_agency_unit", length = 100)
    private String pubAgencyUnit;
    @Column(name = "agency_status", length = 1)
    private String agencyStatus;
    @Column(name = "state_id")
    private Integer stateId;
    @Column(name = "state_name", length = 100)
    private String stateName;
    @Column(name = "state_abbr", length = 2)
    private String stateAbbr;
    @Column(name = "state_postal_abbr", length = 2)
    private String statePostalAbbr;
    @Column(name = "division_code")
    private Integer divisionCode;
    @Column(name = "division_name", length = 100)
    private String divisionName;
    @Column(name = "region_code")
    private Integer regionCode;
    @Column(name = "region_name", length = 100)
    private String regionName;
    @Column(name = "region_desc", length = 100)
    private String regionDesc;
    @Column(name = "agency_type_name", length = 100)
    private String agencyTypeName;
    @Column(name = "population")
    private Integer population;
    @Column(name = "submitting_agency_id")
    private Integer submittingAgencyId;
    @Column(name = "sai", length = 25)
    private String sai;
    @Column(name = "submitting_agency_name", length = 200)
    private String submittingAgencyName;
    @Column(name = "suburban_area_flag", length = 1)
    private String suburbanAreaFlag;
    @Column(name = "population_group_id")
    private Integer populationGroupId;
    @Column(name = "population_group_code", length = 2)
    private String populationGroupCode;
    @Column(name = "population_group_desc", length = 100)
    private String populationGroupDesc;
    @Column(name = "parent_pop_group_code")
    private Integer parentPopGroupCode;
    @Column(name = "parent_pop_group_desc", length = 100)
    private String parentPopGroupDesc;
    @Column(name = "mip_flag", length = 1)
    private String mipFlag;
    @Column(name = "pop_sort_order")
    private Integer popSortOrder;
    @Column(name = "summary_rape_def", length = 1)
    private String summaryRapeDef;
    @Column(name = "pe_reported_flag", length = 1)
    private String peReportedFlag;
    @Column(name = "male_officer")
    private Integer maleOfficer;
    @Column(name = "male_civilian")
    private Integer maleCivilian;
    @Column(name = "male_total")
    private Integer maleTotal;
    @Column(name = "female_officer")
    private Integer femaleOfficer;
    @Column(name = "female_civilian")
    private Integer femaleCivilian;
    @Column(name = "female_total")
    private Integer femaleTotal;
    @Column(name = "officer_rate")
    private BigDecimal officerRate;
    @Column(name = "employee_rate")
    private BigDecimal employeeRate;
    @Column(name = "nibrs_cert_date")
    @Temporal(TemporalType.DATE)
    private Date nibrsCertDate;
    @Column(name = "nibrs_start_date")
    @Temporal(TemporalType.DATE)
    private Date nibrsStartDate;
    @Column(name = "nibrs_leoka_start_date")
    @Temporal(TemporalType.DATE)
    private Date nibrsLeokaStartDate;
    @Column(name = "nibrs_ct_start_date")
    @Temporal(TemporalType.DATE)
    private Date nibrsCtStartDate;
    @Column(name = "nibrs_multi_bias_start_date")
    @Temporal(TemporalType.DATE)
    private Date nibrsMultiBiasStartDate;
    @Column(name = "nibrs_off_eth_start_date")
    @Temporal(TemporalType.DATE)
    private Date nibrsOffEthStartDate;
    @Column(name = "covered_flag", length = 1)
    private String coveredFlag;
    @Column(name = "county_name", length = 100)
    private String countyName;
    @Column(name = "msa_name", length = 100)
    private String msaName;
    @Column(name = "publishable_flag", length = 1)
    private String publishableFlag;
    @Column(name = "participated", length = 1)
    private String participated;
    @Column(name = "nibrs_participated", length = 1)
    private String nibrsParticipated;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agencyId")
    private List<NibrsMonth> nibrsMonthList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agencyId")
    private List<NibrsIncident> nibrsIncidentList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Agencies{");
        sb.append("agencyId=").append(agencyId);
        sb.append(", agencyStatus='").append(agencyStatus).append('\'');
        sb.append(", agencyTypeName='").append(agencyTypeName).append('\'');
        sb.append(", countyName='").append(countyName).append('\'');
        sb.append(", coveredByLegacyOri='").append(coveredByLegacyOri).append('\'');
        sb.append(", coveredFlag='").append(coveredFlag).append('\'');
        sb.append(", dataYear=").append(dataYear);
        sb.append(", directContributorFlag='").append(directContributorFlag).append('\'');
        sb.append(", divisionCode=").append(divisionCode);
        sb.append(", divisionName='").append(divisionName).append('\'');
        sb.append(", dormantFlag='").append(dormantFlag).append('\'');
        sb.append(", dormantYear=").append(dormantYear);
        sb.append(", employeeRate=").append(employeeRate);
        sb.append(", femaleCivilian=").append(femaleCivilian);
        sb.append(", femaleOfficer=").append(femaleOfficer);
        sb.append(", femaleTotal=").append(femaleTotal);
        sb.append(", legacyOri='").append(legacyOri).append('\'');
        sb.append(", maleCivilian=").append(maleCivilian);
        sb.append(", maleOfficer=").append(maleOfficer);
        sb.append(", maleTotal=").append(maleTotal);
        sb.append(", mipFlag='").append(mipFlag).append('\'');
        sb.append(", msaName='").append(msaName).append('\'');
        sb.append(", ncicAgencyName='").append(ncicAgencyName).append('\'');
        sb.append(", nibrsCertDate=").append(nibrsCertDate);
        sb.append(", nibrsCtStartDate=").append(nibrsCtStartDate);
        sb.append(", nibrsLeokaStartDate=").append(nibrsLeokaStartDate);
        sb.append(", nibrsMultiBiasStartDate=").append(nibrsMultiBiasStartDate);
        sb.append(", nibrsOffEthStartDate=").append(nibrsOffEthStartDate);
        sb.append(", nibrsParticipated='").append(nibrsParticipated).append('\'');
        sb.append(", nibrsStartDate=").append(nibrsStartDate);
        sb.append(", officerRate=").append(officerRate);
        sb.append(", ori='").append(ori).append('\'');
        sb.append(", parentPopGroupCode=").append(parentPopGroupCode);
        sb.append(", parentPopGroupDesc='").append(parentPopGroupDesc).append('\'');
        sb.append(", participated='").append(participated).append('\'');
        sb.append(", peReportedFlag='").append(peReportedFlag).append('\'');
        sb.append(", popSortOrder=").append(popSortOrder);
        sb.append(", population=").append(population);
        sb.append(", populationGroupCode='").append(populationGroupCode).append('\'');
        sb.append(", populationGroupDesc='").append(populationGroupDesc).append('\'');
        sb.append(", populationGroupId=").append(populationGroupId);
        sb.append(", pubAgencyName='").append(pubAgencyName).append('\'');
        sb.append(", pubAgencyUnit='").append(pubAgencyUnit).append('\'');
        sb.append(", publishableFlag='").append(publishableFlag).append('\'');
        sb.append(", regionCode=").append(regionCode);
        sb.append(", regionDesc='").append(regionDesc).append('\'');
        sb.append(", regionName='").append(regionName).append('\'');
        sb.append(", reportingType='").append(reportingType).append('\'');
        sb.append(", sai='").append(sai).append('\'');
        sb.append(", stateAbbr='").append(stateAbbr).append('\'');
        sb.append(", stateId=").append(stateId);
        sb.append(", stateName='").append(stateName).append('\'');
        sb.append(", statePostalAbbr='").append(statePostalAbbr).append('\'');
        sb.append(", submittingAgencyId=").append(submittingAgencyId);
        sb.append(", submittingAgencyName='").append(submittingAgencyName).append('\'');
        sb.append(", suburbanAreaFlag='").append(suburbanAreaFlag).append('\'');
        sb.append(", summaryRapeDef='").append(summaryRapeDef).append('\'');
        sb.append(", ucrAgencyName='").append(ucrAgencyName).append('\'');
        sb.append(", yearlyAgencyId=").append(yearlyAgencyId);
        sb.append('}');
        return sb.toString();
    }
}
