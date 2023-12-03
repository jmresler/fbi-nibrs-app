package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_assignment_type", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "assignmentTypeId")
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
    @OneToMany(mappedBy = "assignmentTypeId")
    private List<NibrsVictim> nibrsVictimList;
}
