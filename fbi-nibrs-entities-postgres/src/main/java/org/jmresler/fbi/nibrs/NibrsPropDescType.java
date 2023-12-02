package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "nibrs_prop_desc_type", catalog = "nibrs", schema = "public")
public class NibrsPropDescType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "prop_desc_id", nullable = false)
    private Short propDescId;
    @Column(name = "prop_desc_name", length = 100)
    private String propDescName;
    @Column(name = "prop_desc_code", length = 2)
    private String propDescCode;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsPropDescType")
    private Collection<NibrsPropertyDesc> nibrsPropertyDescCollection;
}
