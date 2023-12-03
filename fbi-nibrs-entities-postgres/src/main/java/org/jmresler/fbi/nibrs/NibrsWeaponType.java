package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_weapon_type", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "weaponId")
public class NibrsWeaponType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "weapon_id", nullable = false)
    private Short weaponId;
    @Column(name = "weapon_code", length = 3)
    private String weaponCode;
    @Column(name = "weapon_name", length = 100)
    private String weaponName;
    @Column(name = "shr_flag")
    private Character shrFlag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsWeaponType")
    private List<NibrsArresteeWeapon> nibrsArresteeWeaponList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsWeaponType")
    private List<NibrsWeapon> nibrsWeaponList;
}
