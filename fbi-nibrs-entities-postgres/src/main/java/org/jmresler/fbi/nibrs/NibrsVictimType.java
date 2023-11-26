package org.jmresler.fbi.nibrs;

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
@Table(name = "nibrs_victim_type", catalog = "nibrs", schema = "public")
public class NibrsVictimType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "victim_type_id", nullable = false)
    private Short victimTypeId;
    @Column(name = "victim_type_code")
    private Character victimTypeCode;
    @Column(name = "victim_type_name", length = 100)
    private String victimTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "victimTypeId")
    private Collection<NibrsVictim> nibrsVictimCollection;
}
