package org.jmresler.fbi.nibrs;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author johnm
 */
@Data
@Embeddable
public class NibrsVictimInjuryPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "victim_id", nullable = false)
    private long victimId;
    @Basic(optional = false)
    @Column(name = "injury_id", nullable = false)
    private short injuryId;
}