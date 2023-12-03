package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "nibrs_weapon", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nibrsWeaponPK")
public class NibrsWeapon implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsWeaponPK nibrsWeaponPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "nibrs_weapon_id")
    private BigInteger nibrsWeaponId;
    @JoinColumn(name = "offense_id", referencedColumnName = "offense_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsOffense nibrsOffense;
    @JoinColumn(name = "weapon_id", referencedColumnName = "weapon_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsWeaponType nibrsWeaponType;

}
