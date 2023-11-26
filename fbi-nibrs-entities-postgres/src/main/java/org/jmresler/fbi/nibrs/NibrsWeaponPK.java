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
public class NibrsWeaponPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "weapon_id", nullable = false)
    private short weaponId;
    @Basic(optional = false)
    @Column(name = "offense_id", nullable = false)
    private long offenseId;
}