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
@Table(name = "nibrs_arrest_type", catalog = "nibrs", schema = "public")
public class NibrsArrestType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "arrest_type_id", nullable = false)
    private Short arrestTypeId;
    @Column(name = "arrest_type_code")
    private Character arrestTypeCode;
    @Column(name = "arrest_type_name", length = 100)
    private String arrestTypeName;
    @JsonManagedReference
    @OneToMany(mappedBy = "arrestTypeId")
    private List<NibrsArrestee> nibrsArresteeList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsArrestType{");
        sb.append("arrestTypeCode=").append(arrestTypeCode);
        sb.append(", arrestTypeId=").append(arrestTypeId);
        sb.append(", arrestTypeName='").append(arrestTypeName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
