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
public class NibrsBiasMotivationPK implements Serializable {

    @Column(name = "bias_id", nullable = false)
    private short biasId;
    @Column(name = "offense_id", nullable = false)
    private long offenseId;
}
