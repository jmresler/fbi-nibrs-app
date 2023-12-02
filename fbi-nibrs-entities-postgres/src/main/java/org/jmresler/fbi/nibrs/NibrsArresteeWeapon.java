package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "nibrs_arrestee_weapon", catalog = "nibrs", schema = "public")
public class NibrsArresteeWeapon implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsArresteeWeaponPK nibrsArresteeWeaponPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "nibrs_arrestee_weapon_id")
    private BigInteger nibrsArresteeWeaponId;
    @JsonBackReference
    @JoinColumn(name = "arrestee_id", referencedColumnName = "arrestee_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsArrestee nibrsArrestee;
    @JsonBackReference
    @JoinColumn(name = "weapon_id", referencedColumnName = "weapon_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsWeaponType nibrsWeaponType;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsArresteeWeapon{");
        sb.append("dataYear=").append(dataYear);
        sb.append(", nibrsArrestee=").append(nibrsArrestee);
        sb.append(", nibrsArresteeWeaponId=").append(nibrsArresteeWeaponId);
        sb.append(", nibrsArresteeWeaponPK=").append(nibrsArresteeWeaponPK);
        sb.append(", nibrsWeaponType=").append(nibrsWeaponType);
        sb.append('}');
        return sb.toString();
    }
}
