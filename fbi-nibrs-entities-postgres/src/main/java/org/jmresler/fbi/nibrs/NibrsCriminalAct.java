package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Data
@Entity
@Table(name = "nibrs_criminal_act", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nibrsCriminalActPK")
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
