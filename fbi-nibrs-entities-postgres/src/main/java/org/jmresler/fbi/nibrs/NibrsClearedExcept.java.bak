package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_cleared_except", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "clearedExceptId")
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clearedExceptId")
    private List<NibrsIncident> nibrsIncidentList;
}
