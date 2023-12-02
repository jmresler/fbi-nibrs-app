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

    @Column(name = "property_id", nullable = false)
    private long propertyId;
    @Column(name = "prop_desc_id", nullable = false)
    private short propDescId;
}
