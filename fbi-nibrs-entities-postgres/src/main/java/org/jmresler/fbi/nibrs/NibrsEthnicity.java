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
@Table(name = "nibrs_ethnicity", catalog = "nibrs", schema = "public")
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
    @JsonManagedReference
    @OneToMany(mappedBy = "ethnicityId")
    private List<NibrsArrestee> nibrsArresteeList;
    @JsonManagedReference
    @OneToMany(mappedBy = "ethnicityId")
    private List<NibrsOffender> nibrsOffenderList;
    @JsonManagedReference
    @OneToMany(mappedBy = "ethnicityId")
    private List<NibrsVictim> nibrsVictimList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsEthnicity{");
        sb.append("ethnicityCode=").append(ethnicityCode);
        sb.append(", ethnicityId=").append(ethnicityId);
        sb.append(", ethnicityName='").append(ethnicityName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
