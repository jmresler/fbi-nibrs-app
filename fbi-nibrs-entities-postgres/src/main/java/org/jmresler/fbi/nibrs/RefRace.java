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
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "raceId")
    private List<NibrsArrestee> nibrsArresteeList;
    @JsonManagedReference
    @OneToMany(mappedBy = "raceId")
    private List<NibrsOffender> nibrsOffenderList;
    @JsonManagedReference
    @OneToMany(mappedBy = "raceId")
    private List<NibrsVictim> nibrsVictimList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RefRace{");
        sb.append("endYear=").append(endYear);
        sb.append(", notes='").append(notes).append('\'');
        sb.append(", raceCode='").append(raceCode).append('\'');
        sb.append(", raceDesc='").append(raceDesc).append('\'');
        sb.append(", raceId=").append(raceId);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", startYear=").append(startYear);
        sb.append('}');
        return sb.toString();
    }
}
