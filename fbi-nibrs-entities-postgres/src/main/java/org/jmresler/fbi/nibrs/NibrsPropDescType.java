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
@Table(name = "nibrs_prop_desc_type", catalog = "nibrs", schema = "public")
public class NibrsPropDescType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "prop_desc_id", nullable = false)
    private Short propDescId;
    @Column(name = "prop_desc_name", length = 100)
    private String propDescName;
    @Column(name = "prop_desc_code", length = 2)
    private String propDescCode;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsPropDescType")
    private List<NibrsPropertyDesc> nibrsPropertyDescList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsPropDescType{");
        sb.append("propDescCode='").append(propDescCode).append('\'');
        sb.append(", propDescId=").append(propDescId);
        sb.append(", propDescName='").append(propDescName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
