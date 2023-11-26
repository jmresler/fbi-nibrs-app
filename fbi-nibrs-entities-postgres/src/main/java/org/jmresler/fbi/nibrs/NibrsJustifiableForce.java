package org.jmresler.fbi.nibrs;

import jakarta.persistence.Basic;
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
@Table(name = "nibrs_justifiable_force", catalog = "nibrs", schema = "public")
public class NibrsJustifiableForce implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "justifiable_force_id", nullable = false)
    private Short justifiableForceId;
    @Column(name = "justifiable_force_code")
    private Character justifiableForceCode;
    @Column(name = "justifiable_force_name", length = 100)
    private String justifiableForceName;
    @OneToMany(mappedBy = "justifiableForceId")
    private Collection<NibrsVictimCircumstances> nibrsVictimCircumstancesCollection;
}
