package org.jmresler.fbi.nibrs;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
@Data
@Embeddable
public class NibrsVictimOffensePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "victim_id", nullable = false)
    private long victimId;
    @Basic(optional = false)
    @Column(name = "offense_id", nullable = false)
    private long offenseId;

}
