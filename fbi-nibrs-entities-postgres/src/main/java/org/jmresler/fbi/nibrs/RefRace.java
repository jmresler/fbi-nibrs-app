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
import lombok.Data;

/**
 *
 * @author johnm
 */
@Data
@Entity
@Table(name = "ref_race", catalog = "nibrs", schema = "public")
public class RefRace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "race_id", nullable = false)
    private Short raceId;
    @Basic(optional = false)
    @Column(name = "race_code", nullable = false, length = 2)
    private String raceCode;
    @Basic(optional = false)
    @Column(name = "race_desc", nullable = false, length = 100)
    private String raceDesc;
    @Column(name = "sort_order")
    private Short sortOrder;
    @Column(name = "start_year")
    private Short startYear;
    @Column(name = "end_year")
    private Short endYear;
    @Column(name = "notes", length = 1000)
    private String notes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "raceId")
    private Collection<NibrsArrestee> nibrsArresteeCollection;
    @OneToMany(mappedBy = "raceId")
    private Collection<NibrsOffender> nibrsOffenderCollection;
    @OneToMany(mappedBy = "raceId")
    private Collection<NibrsVictim> nibrsVictimCollection;
}
