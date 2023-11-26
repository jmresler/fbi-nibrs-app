package org.jmresler.fbi.nibrs;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relationshipId")
    private Collection<NibrsVictimOffenderRel> nibrsVictimOffenderRelCollection;
}
