package org.jmresler.fbi.nibrs;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@Table(name = "nibrs_injury", catalog = "nibrs", schema = "public")
public class NibrsInjury implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "injury_id", nullable = false)
    private Short injuryId;
    @Column(name = "injury_code")
    private Character injuryCode;
    @Column(name = "injury_name", length = 100)
    private String injuryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsInjury")
    private Collection<NibrsVictimInjury> nibrsVictimInjuryCollection;
}
