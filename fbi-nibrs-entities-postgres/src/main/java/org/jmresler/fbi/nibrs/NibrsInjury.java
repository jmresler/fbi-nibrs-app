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
@Table(name = "nibrs_injury", catalog = "nibrs", schema = "public")
public class NibrsInjury implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "injury_id", nullable = false)
    private Short injuryId;
    @Column(name = "injury_code")
    private Character injuryCode;
    @Column(name = "injury_name", length = 100)
    private String injuryName;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsInjury")
    private List<NibrsVictimInjury> nibrsVictimInjuryList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsInjury{");
        sb.append("injuryCode=").append(injuryCode);
        sb.append(", injuryId=").append(injuryId);
        sb.append(", injuryName='").append(injuryName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
