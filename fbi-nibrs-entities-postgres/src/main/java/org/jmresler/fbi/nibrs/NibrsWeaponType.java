package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import lombok.Data;

/**
 *
 * @author johnm
 */
@Data
@Entity
@Table(name = "nibrs_weapon_type", catalog = "nibrs", schema = "public")
public class NibrsWeaponType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "weapon_id", nullable = false)
    private Short weaponId;
    @Column(name = "weapon_code", length = 3)
    private String weaponCode;
    @Column(name = "weapon_name", length = 100)
    private String weaponName;
    @Column(name = "shr_flag")
    private Character shrFlag;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsWeaponType")
    private Collection<NibrsArresteeWeapon> nibrsArresteeWeaponCollection;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsWeaponType")
    private Collection<NibrsWeapon> nibrsWeaponCollection;
}
