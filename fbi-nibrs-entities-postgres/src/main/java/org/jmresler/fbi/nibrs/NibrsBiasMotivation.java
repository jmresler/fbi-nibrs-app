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
@Table(name = "nibrs_bias_motivation", catalog = "nibrs", schema = "public")
public class NibrsBiasMotivation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsBiasMotivationPK nibrsBiasMotivationPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @JoinColumn(name = "bias_id", referencedColumnName = "bias_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsBiasList nibrsBiasList;
    @JoinColumn(name = "offense_id", referencedColumnName = "offense_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsOffense nibrsOffense;
}
