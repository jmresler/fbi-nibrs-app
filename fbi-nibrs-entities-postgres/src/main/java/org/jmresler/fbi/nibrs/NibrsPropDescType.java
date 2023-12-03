package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_prop_desc_type", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "propDescId")
public class NibrsPropDescType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "prop_desc_id", nullable = false)
    private Short propDescId;
    @Column(name = "prop_desc_name", length = 100)
    private String propDescName;
    @Column(name = "prop_desc_code", length = 2)
    private String propDescCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsPropDescType")
    private List<NibrsPropertyDesc> nibrsPropertyDescList;
}
