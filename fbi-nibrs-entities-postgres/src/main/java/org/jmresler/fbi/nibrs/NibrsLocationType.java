package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "nibrs_location_type", catalog = "nibrs", schema = "public")
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
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
    private List<NibrsOffense> nibrsOffenseList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsLocationType{");
        sb.append("locationCode='").append(locationCode).append('\'');
        sb.append(", locationId=").append(locationId);
        sb.append(", locationName='").append(locationName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
