package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;
import lombok.Data;

/**
 *
 * @author johnm
 */
@Data
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
}
