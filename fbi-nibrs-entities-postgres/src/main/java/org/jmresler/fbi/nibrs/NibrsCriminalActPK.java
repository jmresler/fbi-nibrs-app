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
public class NibrsCriminalActPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "criminal_act_id", nullable = false)
    private short criminalActId;
    @Basic(optional = false)
    @Column(name = "offense_id", nullable = false)
    private long offenseId;
}
