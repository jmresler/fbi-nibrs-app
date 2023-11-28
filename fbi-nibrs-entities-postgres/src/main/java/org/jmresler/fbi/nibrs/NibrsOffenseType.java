package org.jmresler.fbi.nibrs;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import lombok.Data;

/**
 *
 * @author johnm
 */
@Data
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offenseCode")
    private Collection<NibrsArrestee> nibrsArresteeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offenseCode", fetch = FetchType.LAZY)
    private Collection<NibrsOffense> nibrsOffenseCollection;
}
