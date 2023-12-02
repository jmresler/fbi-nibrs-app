package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "nibrs_victim_offender_rel", catalog = "nibrs", schema = "public")
public class NibrsVictimOffenderRel implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsVictimOffenderRelPK nibrsVictimOffenderRelPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "nibrs_victim_offender_id")
    private BigInteger nibrsVictimOffenderId;
    @JsonBackReference
    @JoinColumn(name = "offender_id", referencedColumnName = "offender_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsOffender nibrsOffender;
    @JsonBackReference
    @JoinColumn(name = "relationship_id", referencedColumnName = "relationship_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsRelationship relationshipId;
    @JsonBackReference
    @JoinColumn(name = "victim_id", referencedColumnName = "victim_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsVictim nibrsVictim;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsVictimOffenderRel{");
        sb.append("dataYear=").append(dataYear);
        sb.append(", nibrsOffender=").append(nibrsOffender);
        sb.append(", nibrsVictim=").append(nibrsVictim);
        sb.append(", nibrsVictimOffenderId=").append(nibrsVictimOffenderId);
        sb.append(", nibrsVictimOffenderRelPK=").append(nibrsVictimOffenderRelPK);
        sb.append(", relationshipId=").append(relationshipId);
        sb.append('}');
        return sb.toString();
    }
}
