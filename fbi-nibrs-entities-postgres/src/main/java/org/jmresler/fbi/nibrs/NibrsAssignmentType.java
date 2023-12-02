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
@Table(name = "nibrs_assignment_type", catalog = "nibrs", schema = "public")
public class NibrsAssignmentType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "assignment_type_id", nullable = false)
    private Short assignmentTypeId;
    @Column(name = "assignment_type_code")
    private Character assignmentTypeCode;
    @Column(name = "assignment_type_name", length = 100)
    private String assignmentTypeName;
    @JsonManagedReference
    @OneToMany(mappedBy = "assignmentTypeId")
    private List<NibrsVictim> nibrsVictimList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsAssignmentType{");
        sb.append("assignmentTypeCode=").append(assignmentTypeCode);
        sb.append(", assignmentTypeId=").append(assignmentTypeId);
        sb.append(", assignmentTypeName='").append(assignmentTypeName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
