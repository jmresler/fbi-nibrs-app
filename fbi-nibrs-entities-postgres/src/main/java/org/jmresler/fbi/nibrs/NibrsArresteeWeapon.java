package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;
import lombok.Data;

/**
 *
 * @author johnm
 */
@Data
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
}