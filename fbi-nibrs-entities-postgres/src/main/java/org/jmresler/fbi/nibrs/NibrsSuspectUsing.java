package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@Table(name = "nibrs_suspect_using", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nibrsSuspectUsingPK")
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
