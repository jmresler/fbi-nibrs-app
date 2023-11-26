package org.jmresler.fbi.nibrs;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author johnm
 */
@Data
@Embeddable
public class NibrsPropertyDescPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "property_id", nullable = false)
    private long propertyId;
    @Basic(optional = false)
    @Column(name = "prop_desc_id", nullable = false)
    private short propDescId;
}
