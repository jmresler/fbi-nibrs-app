package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "nibrs_bias_motivation", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nibrsBiasMotivationPK")
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
