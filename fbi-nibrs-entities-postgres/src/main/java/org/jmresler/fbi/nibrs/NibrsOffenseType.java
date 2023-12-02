package org.jmresler.fbi.nibrs;

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
@Table(name = "nibrs_offense_type", catalog = "nibrs", schema = "public")
public class NibrsOffenseType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "offense_code", nullable = false, length = 5)
    private String offenseCode;
    @Column(name = "offense_name", length = 100)
    private String offenseName;
    @Column(name = "crime_against", length = 100)
    private String crimeAgainst;
    @Column(name = "ct_flag")
    private Character ctFlag;
    @Column(name = "hc_flag")
    private Character hcFlag;
    @Column(name = "hc_code", length = 5)
    private String hcCode;
    @Column(name = "offense_category_name", length = 100)
    private String offenseCategoryName;
    @Column(name = "offense_group", length = 5)
    private String offenseGroup;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offenseCode")
    private List<NibrsArrestee> nibrsArresteeList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offenseCode")
    private List<NibrsOffense> nibrsOffenseList;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsOffenseType{");
        sb.append("crimeAgainst='").append(crimeAgainst).append('\'');
        sb.append(", ctFlag=").append(ctFlag);
        sb.append(", hcCode='").append(hcCode).append('\'');
        sb.append(", hcFlag=").append(hcFlag);
        sb.append(", offenseCategoryName='").append(offenseCategoryName).append('\'');
        sb.append(", offenseCode='").append(offenseCode).append('\'');
        sb.append(", offenseGroup='").append(offenseGroup).append('\'');
        sb.append(", offenseName='").append(offenseName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
