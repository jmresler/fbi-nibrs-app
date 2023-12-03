package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "nibrs_arrestee_weapon", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nibrsArresteeWeaponPK")
public class NibrsArresteeWeapon implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsArresteeWeaponPK nibrsArresteeWeaponPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "nibrs_arrestee_weapon_id")
    private BigInteger nibrsArresteeWeaponId;
    @JoinColumn(name = "arrestee_id", referencedColumnName = "arrestee_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsArrestee nibrsArrestee;
    @JoinColumn(name = "weapon_id", referencedColumnName = "weapon_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsWeaponType nibrsWeaponType;
}
