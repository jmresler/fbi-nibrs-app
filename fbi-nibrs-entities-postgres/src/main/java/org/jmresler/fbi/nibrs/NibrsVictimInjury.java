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
@Table(name = "nibrs_victim_injury", catalog = "nibrs", schema = "public")
public class NibrsVictimInjury implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsVictimInjuryPK nibrsVictimInjuryPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @JsonBackReference
    @JoinColumn(name = "injury_id", referencedColumnName = "injury_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsInjury nibrsInjury;
    @JsonBackReference
    @JoinColumn(name = "victim_id", referencedColumnName = "victim_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsVictim nibrsVictim;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsVictimInjury{");
        sb.append("dataYear=").append(dataYear);
        sb.append(", nibrsInjury=").append(nibrsInjury);
        sb.append(", nibrsVictim=").append(nibrsVictim);
        sb.append(", nibrsVictimInjuryPK=").append(nibrsVictimInjuryPK);
        sb.append('}');
        return sb.toString();
    }
}
