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
@Table(name = "nibrs_bias_list", catalog = "nibrs", schema = "public")
public class NibrsBiasList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "bias_id", nullable = false)
    private Short biasId;
    @Column(name = "bias_code", length = 2)
    private String biasCode;
    @Column(name = "bias_name", length = 100)
    private String biasName;
    @Column(name = "bias_desc", length = 100)
    private String biasDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsBiasList")
    private Collection<NibrsBiasMotivation> nibrsBiasMotivationCollection;
}
