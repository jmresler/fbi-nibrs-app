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
@Table(name = "nibrs_bias_motivation", catalog = "nibrs", schema = "public")
public class NibrsBiasMotivation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsBiasMotivationPK nibrsBiasMotivationPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @JsonBackReference
    @JoinColumn(name = "bias_id", referencedColumnName = "bias_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsBiasList nibrsBiasList;
    @JsonBackReference
    @JoinColumn(name = "offense_id", referencedColumnName = "offense_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsOffense nibrsOffense;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsBiasMotivation{");
        sb.append("dataYear=").append(dataYear);
        sb.append(", nibrsBiasList=").append(nibrsBiasList);
        sb.append(", nibrsBiasMotivationPK=").append(nibrsBiasMotivationPK);
        sb.append(", nibrsOffense=").append(nibrsOffense);
        sb.append('}');
        return sb.toString();
    }
}
