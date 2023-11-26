package org.jmresler.fbi.nibrs;

import jakarta.persistence.Basic;
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
@Table(name = "nibrs_arrest_type", catalog = "nibrs", schema = "public")
public class NibrsArrestType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "arrest_type_id", nullable = false)
    private Short arrestTypeId;
    @Column(name = "arrest_type_code")
    private Character arrestTypeCode;
    @Column(name = "arrest_type_name", length = 100)
    private String arrestTypeName;
    @OneToMany(mappedBy = "arrestTypeId")
    private Collection<NibrsArrestee> nibrsArresteeCollection;
}