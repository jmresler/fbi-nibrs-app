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
@Table(name = "nibrs_cleared_except", catalog = "nibrs", schema = "public")
public class NibrsClearedExcept implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cleared_except_id", nullable = false)
    private Short clearedExceptId;
    @Column(name = "cleared_except_code")
    private Character clearedExceptCode;
    @Column(name = "cleared_except_name", length = 100)
    private String clearedExceptName;
    @Column(name = "cleared_except_desc", length = 300)
    private String clearedExceptDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clearedExceptId")
    private Collection<NibrsIncident> nibrsIncidentCollection;
}
