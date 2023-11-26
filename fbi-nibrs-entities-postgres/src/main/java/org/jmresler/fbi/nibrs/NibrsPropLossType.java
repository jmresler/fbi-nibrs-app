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
@Table(name = "nibrs_prop_loss_type", catalog = "nibrs", schema = "public")
public class NibrsPropLossType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "prop_loss_id", nullable = false)
    private Short propLossId;
    @Column(name = "prop_loss_name", length = 100)
    private String propLossName;
    @Column(name = "prop_loss_desc", length = 250)
    private String propLossDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propLossId")
    private Collection<NibrsProperty> nibrsPropertyCollection;
}
