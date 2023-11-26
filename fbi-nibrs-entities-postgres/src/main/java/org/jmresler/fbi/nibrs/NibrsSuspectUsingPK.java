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
public class NibrsSuspectUsingPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "suspect_using_id", nullable = false)
    private short suspectUsingId;
    @Basic(optional = false)
    @Column(name = "offense_id", nullable = false)
    private long offenseId;
}
