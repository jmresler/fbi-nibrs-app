package org.jmresler.fbi.nibrs;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ref_state", catalog = "nibrs", schema = "public")
public class RefState implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "state_id", nullable = false)
    private Short stateId;
    @Basic(optional = false)
    @Column(name = "division_id", nullable = false)
    private short divisionId;
    @Column(name = "state_name", length = 100)
    private String stateName;
    @Column(name = "state_code", length = 2)
    private String stateCode;
    @Column(name = "state_abbr", length = 2)
    private String stateAbbr;
    @Column(name = "state_postal_abbr", length = 2)
    private String statePostalAbbr;
    @Column(name = "state_fips_code", length = 2)
    private String stateFipsCode;
    @Column(name = "state_pub_freq_months")
    private Short statePubFreqMonths;
    @Column(name = "change_user", length = 100)
    private String changeUser;


}
