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
@Table(name = "nibrs_cleared_except", catalog = "nibrs", schema = "public")
public class NibrsClearedExcept implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cleared_except_id", nullable = false)
    private Short clearedExceptId;
    @Column(name = "cleared_except_code")
    private Character clearedExceptCode;
    @Column(name = "cleared_except_name", length = 100)
    private String clearedExceptName;
    @Column(name = "cleared_except_desc", length = 300)
    private String clearedExceptDesc;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clearedExceptId")
    private List<NibrsIncident> nibrsIncidentList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsClearedExcept{");
        sb.append("clearedExceptCode=").append(clearedExceptCode);
        sb.append(", clearedExceptDesc='").append(clearedExceptDesc).append('\'');
        sb.append(", clearedExceptId=").append(clearedExceptId);
        sb.append(", clearedExceptName='").append(clearedExceptName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
