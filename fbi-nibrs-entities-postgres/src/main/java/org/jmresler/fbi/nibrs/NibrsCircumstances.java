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
@Table(name = "nibrs_circumstances", catalog = "nibrs", schema = "public")
public class NibrsCircumstances implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "circumstances_id", nullable = false)
    private Short circumstancesId;
    @Column(name = "circumstances_type")
    private Character circumstancesType;
    @Column(name = "circumstances_code")
    private Short circumstancesCode;
    @Column(name = "circumstances_name", length = 100)
    private String circumstancesName;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsCircumstances")
    private Collection<NibrsVictimCircumstances> nibrsVictimCircumstancesCollection;


}
