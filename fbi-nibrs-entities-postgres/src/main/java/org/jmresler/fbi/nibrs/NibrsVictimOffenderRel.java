package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "nibrs_victim_offender_rel", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nibrsVictimOffenderRelPK")
public class NibrsVictimOffenderRel implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsVictimOffenderRelPK nibrsVictimOffenderRelPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "nibrs_victim_offender_id")
    private BigInteger nibrsVictimOffenderId;
    @JoinColumn(name = "offender_id", referencedColumnName = "offender_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsOffender nibrsOffender;
    @JoinColumn(name = "relationship_id", referencedColumnName = "relationship_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsRelationship relationshipId;
    @JoinColumn(name = "victim_id", referencedColumnName = "victim_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsVictim nibrsVictim;
}
