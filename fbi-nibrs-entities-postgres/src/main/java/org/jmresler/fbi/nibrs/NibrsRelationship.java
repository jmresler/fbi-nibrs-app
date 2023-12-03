package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_relationship", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "propLossId")
public class NibrsRelationship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "relationship_id", nullable = false)
    private Short relationshipId;
    @Column(name = "relationship_code", length = 2)
    private String relationshipCode;
    @Column(name = "relationship_name", length = 100)
    private String relationshipName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relationshipId")
    private List<NibrsVictimOffenderRel> nibrsVictimOffenderRelList;
}
