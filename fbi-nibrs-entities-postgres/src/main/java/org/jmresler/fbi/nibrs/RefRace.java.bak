package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "ref_race", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "raceId")
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
    private List<NibrsArrestee> nibrsArresteeList;
    @OneToMany(mappedBy = "raceId")
    private List<NibrsOffender> nibrsOffenderList;
    @OneToMany(mappedBy = "raceId")
    private List<NibrsVictim> nibrsVictimList;

}
