package org.jmresler.fbi.nibrs;

import jakarta.persistence.Basic;
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
    @OneToMany(mappedBy = "assignmentTypeId")
    private Collection<NibrsVictim> nibrsVictimCollection;
}
