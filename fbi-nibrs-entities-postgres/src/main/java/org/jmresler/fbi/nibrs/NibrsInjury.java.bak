package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_injury", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "injuryId")
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsInjury")
    private List<NibrsVictimInjury> nibrsVictimInjuryList;
}
