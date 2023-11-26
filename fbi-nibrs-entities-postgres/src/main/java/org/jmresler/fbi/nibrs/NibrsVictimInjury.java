package org.jmresler.fbi.nibrs;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author johnm
 */
@Data
@Entity
@Table(name = "nibrs_victim_injury", catalog = "nibrs", schema = "public")
public class NibrsVictimInjury implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsVictimInjuryPK nibrsVictimInjuryPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @JoinColumn(name = "injury_id", referencedColumnName = "injury_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsInjury nibrsInjury;
    @JoinColumn(name = "victim_id", referencedColumnName = "victim_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsVictim nibrsVictim;
}
