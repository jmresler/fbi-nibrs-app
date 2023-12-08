package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_justifiable_force", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "justifiableForceId")
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
    @OneToMany(mappedBy = "justifiableForceId")
    private List<NibrsVictimCircumstances> nibrsVictimCircumstancesList;
}
