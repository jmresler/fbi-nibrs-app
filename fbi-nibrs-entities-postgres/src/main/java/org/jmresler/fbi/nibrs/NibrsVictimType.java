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
@Table(name = "nibrs_victim_type", catalog = "nibrs", schema = "public")
public class NibrsVictimType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "victim_type_id", nullable = false)
    private Short victimTypeId;
    @Column(name = "victim_type_code")
    private Character victimTypeCode;
    @Column(name = "victim_type_name", length = 100)
    private String victimTypeName;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "victimTypeId")
    private List<NibrsVictim> nibrsVictimList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsVictimType{");
        sb.append("victimTypeCode=").append(victimTypeCode);
        sb.append(", victimTypeId=").append(victimTypeId);
        sb.append(", victimTypeName='").append(victimTypeName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
