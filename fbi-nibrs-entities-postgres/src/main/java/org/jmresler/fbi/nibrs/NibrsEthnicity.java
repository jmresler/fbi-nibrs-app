package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "nibrs_ethnicity", catalog = "nibrs", schema = "public")
public class NibrsEthnicity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ethnicity_id", nullable = false)
    private Short ethnicityId;
    @Column(name = "ethnicity_code")
    private Character ethnicityCode;
    @Column(name = "ethnicity_name", length = 100)
    private String ethnicityName;
    @JsonManagedReference
    @OneToMany(mappedBy = "ethnicityId")
    private Collection<NibrsArrestee> nibrsArresteeCollection;
    @JsonManagedReference
    @OneToMany(mappedBy = "ethnicityId")
    private Collection<NibrsOffender> nibrsOffenderCollection;
    @JsonManagedReference
    @OneToMany(mappedBy = "ethnicityId")
    private Collection<NibrsVictim> nibrsVictimCollection;
}
