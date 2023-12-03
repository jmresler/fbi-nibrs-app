package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_prop_loss_type", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "propLossId")
public class NibrsPropLossType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "prop_loss_id", nullable = false)
    private Short propLossId;
    @Column(name = "prop_loss_name", length = 100)
    private String propLossName;
    @Column(name = "prop_loss_desc", length = 250)
    private String propLossDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propLossId")
    private List<NibrsProperty> nibrsPropertyList;

}
