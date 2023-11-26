package org.jmresler.fbi.nibrs;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author johnm
 */
@Data
@Entity
@Table(name = "nibrs_criminal_act", catalog = "nibrs", schema = "public")
public class NibrsCriminalAct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsCriminalActPK nibrsCriminalActPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @JoinColumn(name = "criminal_act_id", referencedColumnName = "criminal_act_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsCriminalActType nibrsCriminalActType;
    @JoinColumn(name = "offense_id", referencedColumnName = "offense_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsOffense nibrsOffense;
}
