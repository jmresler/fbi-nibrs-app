package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
@Table(name = "nibrs_property_desc", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nibrsPropertyDescPK")
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
    @JoinColumn(name = "prop_desc_id", referencedColumnName = "prop_desc_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsPropDescType nibrsPropDescType;
    @JoinColumn(name = "property_id", referencedColumnName = "property_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsProperty nibrsProperty;
}
