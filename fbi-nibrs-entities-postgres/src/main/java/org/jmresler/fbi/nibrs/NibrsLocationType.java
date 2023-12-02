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
@Table(name = "nibrs_location_type", catalog = "nibrs", schema = "public")
public class NibrsLocationType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "location_id", nullable = false)
    private Long locationId;
    @Column(name = "location_code", length = 2)
    private String locationCode;
    @Column(name = "location_name", length = 100)
    private String locationName;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
    private Collection<NibrsOffense> nibrsOffenseCollection;
}
