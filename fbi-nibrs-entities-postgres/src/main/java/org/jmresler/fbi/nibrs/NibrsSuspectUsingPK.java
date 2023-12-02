package org.jmresler.fbi.nibrs;

import jakarta.persistence.Basic;
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
public class NibrsSuspectUsingPK implements Serializable {

    @Column(name = "suspect_using_id", nullable = false)
    private short suspectUsingId;
    @Column(name = "offense_id", nullable = false)
    private long offenseId;
}
