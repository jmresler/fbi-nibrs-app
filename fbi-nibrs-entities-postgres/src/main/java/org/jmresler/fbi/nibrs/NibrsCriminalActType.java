package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "nibrs_criminal_act_type", catalog = "nibrs", schema = "public")
public class NibrsCriminalActType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "criminal_act_id", nullable = false)
    private Short criminalActId;
    @Column(name = "criminal_act_code")
    private Character criminalActCode;
    @Column(name = "criminal_act_name", length = 100)
    private String criminalActName;
    @Column(name = "criminal_act_desc", length = 300)
    private String criminalActDesc;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsCriminalActType")
    private Collection<NibrsCriminalAct> nibrsCriminalActCollection;
}
