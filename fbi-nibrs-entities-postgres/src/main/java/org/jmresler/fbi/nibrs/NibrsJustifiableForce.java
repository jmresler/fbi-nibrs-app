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
@Table(name = "nibrs_justifiable_force", catalog = "nibrs", schema = "public")
public class NibrsJustifiableForce implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "justifiable_force_id", nullable = false)
    private Short justifiableForceId;
    @Column(name = "justifiable_force_code")
    private Character justifiableForceCode;
    @Column(name = "justifiable_force_name", length = 100)
    private String justifiableForceName;
    @JsonManagedReference
    @OneToMany(mappedBy = "justifiableForceId")
    private List<NibrsVictimCircumstances> nibrsVictimCircumstancesList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsJustifiableForce{");
        sb.append("justifiableForceCode=").append(justifiableForceCode);
        sb.append(", justifiableForceId=").append(justifiableForceId);
        sb.append(", justifiableForceName='").append(justifiableForceName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
