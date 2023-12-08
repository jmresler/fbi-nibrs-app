package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_location_type", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "locationId")
public class NibrsLocationType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "location_id", nullable = false)
    private Long locationId;
    @Column(name = "location_code", length = 2)
    private String locationCode;
    @Column(name = "location_name", length = 100)
    private String locationName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
    private List<NibrsOffense> nibrsOffenseList;
}
