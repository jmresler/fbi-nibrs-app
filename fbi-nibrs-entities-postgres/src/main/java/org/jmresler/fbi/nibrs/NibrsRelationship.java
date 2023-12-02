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
@Table(name = "nibrs_relationship", catalog = "nibrs", schema = "public")
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
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relationshipId")
    private List<NibrsVictimOffenderRel> nibrsVictimOffenderRelList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsRelationship{");
        sb.append("relationshipCode='").append(relationshipCode).append('\'');
        sb.append(", relationshipId=").append(relationshipId);
        sb.append(", relationshipName='").append(relationshipName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
