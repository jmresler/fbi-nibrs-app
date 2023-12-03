package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_arrest_type", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "arrestTypeId")
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
    @OneToMany(mappedBy = "arrestTypeId")
    private List<NibrsArrestee> nibrsArresteeList;

}
