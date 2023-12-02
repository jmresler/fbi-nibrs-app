package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "nibrs_weapon_type", catalog = "nibrs", schema = "public")
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
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsWeaponType")
    private List<NibrsArresteeWeapon> nibrsArresteeWeaponList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsWeaponType")
    private List<NibrsWeapon> nibrsWeaponList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsWeaponType{");
        sb.append("shrFlag=").append(shrFlag);
        sb.append(", weaponCode='").append(weaponCode).append('\'');
        sb.append(", weaponId=").append(weaponId);
        sb.append(", weaponName='").append(weaponName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
