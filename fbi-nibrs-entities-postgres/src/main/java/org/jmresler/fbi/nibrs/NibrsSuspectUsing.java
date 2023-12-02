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
@Table(name = "nibrs_suspect_using", catalog = "nibrs", schema = "public")
public class NibrsSuspectUsing implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsSuspectUsingPK nibrsSuspectUsingPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @JsonBackReference
    @JoinColumn(name = "offense_id", referencedColumnName = "offense_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsOffense nibrsOffense;
    @JsonBackReference
    @JoinColumn(name = "suspect_using_id", referencedColumnName = "suspect_using_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsUsingList nibrsUsingList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsSuspectUsing{");
        sb.append("dataYear=").append(dataYear);
        sb.append(", nibrsOffense=").append(nibrsOffense);
        sb.append(", nibrsSuspectUsingPK=").append(nibrsSuspectUsingPK);
        sb.append(", nibrsUsingList=").append(nibrsUsingList);
        sb.append('}');
        return sb.toString();
    }
}
