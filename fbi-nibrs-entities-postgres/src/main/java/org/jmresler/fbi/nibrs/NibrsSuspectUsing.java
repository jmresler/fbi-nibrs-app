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
@Table(name = "nibrs_suspect_using", catalog = "nibrs", schema = "public")
public class NibrsSuspectUsing implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsSuspectUsingPK nibrsSuspectUsingPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @JoinColumn(name = "offense_id", referencedColumnName = "offense_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsOffense nibrsOffense;
    @JoinColumn(name = "suspect_using_id", referencedColumnName = "suspect_using_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsUsingList nibrsUsingList;
}
