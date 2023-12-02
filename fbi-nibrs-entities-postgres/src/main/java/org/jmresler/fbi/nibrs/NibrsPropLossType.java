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
@Table(name = "nibrs_prop_loss_type", catalog = "nibrs", schema = "public")
public class NibrsPropLossType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "prop_loss_id", nullable = false)
    private Short propLossId;
    @Column(name = "prop_loss_name", length = 100)
    private String propLossName;
    @Column(name = "prop_loss_desc", length = 250)
    private String propLossDesc;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propLossId")
    private List<NibrsProperty> nibrsPropertyList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsPropLossType{");
        sb.append("propLossDesc='").append(propLossDesc).append('\'');
        sb.append(", propLossId=").append(propLossId);
        sb.append(", propLossName='").append(propLossName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
