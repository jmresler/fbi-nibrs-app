package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_ethnicity", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ethnicityId")
public class NibrsEthnicity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ethnicity_id", nullable = false)
    private Short ethnicityId;
    @Column(name = "ethnicity_code")
    private Character ethnicityCode;
    @Column(name = "ethnicity_name", length = 100)
    private String ethnicityName;
    @OneToMany(mappedBy = "ethnicityId")
    private List<NibrsArrestee> nibrsArresteeList;
    @OneToMany(mappedBy = "ethnicityId")
    private List<NibrsOffender> nibrsOffenderList;
    @OneToMany(mappedBy = "ethnicityId")
    private List<NibrsVictim> nibrsVictimList;
}
