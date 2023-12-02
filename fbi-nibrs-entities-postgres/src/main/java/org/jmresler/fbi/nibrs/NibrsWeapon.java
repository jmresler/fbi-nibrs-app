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
@Table(name = "nibrs_weapon", catalog = "nibrs", schema = "public")
public class NibrsWeapon implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsWeaponPK nibrsWeaponPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "nibrs_weapon_id")
    private BigInteger nibrsWeaponId;
    @JsonBackReference
    @JoinColumn(name = "offense_id", referencedColumnName = "offense_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsOffense nibrsOffense;
    @JsonBackReference
    @JoinColumn(name = "weapon_id", referencedColumnName = "weapon_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsWeaponType nibrsWeaponType;
}
