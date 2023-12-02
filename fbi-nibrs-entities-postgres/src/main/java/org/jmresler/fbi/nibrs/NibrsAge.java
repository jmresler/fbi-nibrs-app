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
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ageId")
    private List<NibrsArrestee> nibrsArresteeList;
    @JsonManagedReference
    @OneToMany(mappedBy = "ageId")
    private List<NibrsOffender> nibrsOffenderList;
    @JsonManagedReference
    @OneToMany(mappedBy = "ageId")
    private List<NibrsVictim> nibrsVictimList;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsAge{");
        sb.append("ageCode='").append(ageCode).append('\'');
        sb.append(", ageId=").append(ageId);
        sb.append(", ageName='").append(ageName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
