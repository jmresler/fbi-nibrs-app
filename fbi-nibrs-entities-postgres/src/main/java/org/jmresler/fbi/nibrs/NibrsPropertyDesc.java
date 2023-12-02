package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author johnm
 */
@Data
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
}
