package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_criminal_act_type", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "criminalActId")
public class NibrsCriminalActType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "criminal_act_id", nullable = false)
    private Short criminalActId;
    @Column(name = "criminal_act_code")
    private Character criminalActCode;
    @Column(name = "criminal_act_name", length = 100)
    private String criminalActName;
    @Column(name = "criminal_act_desc", length = 300)
    private String criminalActDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsCriminalActType")
    private List<NibrsCriminalAct> nibrsCriminalActList;

}
