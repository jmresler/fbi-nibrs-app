package org.jmresler.fbi.nibrs;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class NibrsArresteeWeaponPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "arrestee_id", nullable = false)
    private long arresteeId;
    @Basic(optional = false)
    @Column(name = "weapon_id", nullable = false)
    private short weaponId;

}
