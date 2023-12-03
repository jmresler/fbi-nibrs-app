package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_victim_type", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "victimTypeId")
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "victimTypeId")
    private List<NibrsVictim> nibrsVictimList;

}
