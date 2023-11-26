package org.jmresler.fbi.nibrs;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author johnm
 */
@Entity
@Table(name = "nibrs_age", catalog = "nibrs", schema = "public")
public class NibrsAge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "age_id", nullable = false)
    private Short ageId;
    @Column(name = "age_code", length = 2)
    private String ageCode;
    @Column(name = "age_name", length = 100)
    private String ageName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ageId")
    private Collection<NibrsArrestee> nibrsArresteeCollection;
    @OneToMany(mappedBy = "ageId")
    private Collection<NibrsOffender> nibrsOffenderCollection;
    @OneToMany(mappedBy = "ageId")
    private Collection<NibrsVictim> nibrsVictimCollection;
}
