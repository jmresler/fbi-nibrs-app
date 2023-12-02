package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "nibrs_criminal_act", catalog = "nibrs", schema = "public")
public class NibrsCriminalAct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsCriminalActPK nibrsCriminalActPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @JsonBackReference
    @JoinColumn(name = "criminal_act_id", referencedColumnName = "criminal_act_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsCriminalActType nibrsCriminalActType;
    @JsonBackReference
    @JoinColumn(name = "offense_id", referencedColumnName = "offense_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsOffense nibrsOffense;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsCriminalAct{");
        sb.append("dataYear=").append(dataYear);
        sb.append(", nibrsCriminalActPK=").append(nibrsCriminalActPK);
        sb.append(", nibrsCriminalActType=").append(nibrsCriminalActType);
        sb.append(", nibrsOffense=").append(nibrsOffense);
        sb.append('}');
        return sb.toString();
    }
}
