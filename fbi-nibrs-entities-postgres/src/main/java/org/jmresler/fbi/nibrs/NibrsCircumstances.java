package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_circumstances", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "circumstancesId")
public class NibrsCircumstances implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "circumstances_id", nullable = false)
    private Short circumstancesId;
    @Column(name = "circumstances_type")
    private Character circumstancesType;
    @Column(name = "circumstances_code")
    private Short circumstancesCode;
    @Column(name = "circumstances_name", length = 100)
    private String circumstancesName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsCircumstances")
    private List<NibrsVictimCircumstances> nibrsVictimCircumstancesList;
}
