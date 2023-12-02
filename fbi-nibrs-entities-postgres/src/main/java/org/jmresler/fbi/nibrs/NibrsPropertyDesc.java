package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "nibrs_property_desc", catalog = "nibrs", schema = "public")
public class NibrsPropertyDesc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsPropertyDescPK nibrsPropertyDescPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "property_value")
    private BigInteger propertyValue;
    @Column(name = "date_recovered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRecovered;
    @Column(name = "nibrs_prop_desc_id")
    private BigInteger nibrsPropDescId;
    @JsonBackReference
    @JoinColumn(name = "prop_desc_id", referencedColumnName = "prop_desc_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsPropDescType nibrsPropDescType;
    @JsonBackReference
    @JoinColumn(name = "property_id", referencedColumnName = "property_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsProperty nibrsProperty;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsPropertyDesc{");
        sb.append("dataYear=").append(dataYear);
        sb.append(", dateRecovered=").append(dateRecovered);
        sb.append(", nibrsPropDescId=").append(nibrsPropDescId);
        sb.append(", nibrsPropDescType=").append(nibrsPropDescType);
        sb.append(", nibrsProperty=").append(nibrsProperty);
        sb.append(", nibrsPropertyDescPK=").append(nibrsPropertyDescPK);
        sb.append(", propertyValue=").append(propertyValue);
        sb.append('}');
        return sb.toString();
    }
}
