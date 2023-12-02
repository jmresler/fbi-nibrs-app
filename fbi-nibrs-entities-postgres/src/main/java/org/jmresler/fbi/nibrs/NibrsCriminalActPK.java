package org.jmresler.fbi.nibrs;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author johnm
 */
@Data
@Embeddable
public class NibrsCriminalActPK implements Serializable {

    @Column(name = "criminal_act_id", nullable = false)
    private short criminalActId;
    @Column(name = "offense_id", nullable = false)
    private long offenseId;
}
