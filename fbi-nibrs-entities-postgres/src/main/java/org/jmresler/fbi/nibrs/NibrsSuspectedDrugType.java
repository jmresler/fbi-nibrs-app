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
@Table(name = "nibrs_suspected_drug_type", catalog = "nibrs", schema = "public")
public class NibrsSuspectedDrugType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "suspected_drug_type_id", nullable = false)
    private Short suspectedDrugTypeId;
    @Column(name = "suspected_drug_code")
    private Character suspectedDrugCode;
    @Column(name = "suspected_drug_name", length = 100)
    private String suspectedDrugName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suspectedDrugTypeId")
    private Collection<NibrsSuspectedDrug> nibrsSuspectedDrugCollection;
}
