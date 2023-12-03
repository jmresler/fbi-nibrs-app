package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
@Entity
@Table(name = "nibrs_activity_type", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "activityTypeId")
public class NibrsActivityType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "activity_type_id", nullable = false)
    private Short activityTypeId;
    @Column(name = "activity_type_code", length = 2)
    private String activityTypeCode;
    @Column(name = "activity_type_name", length = 100)
    private String activityTypeName;
    @OneToMany(mappedBy = "activityTypeId")
    private List<NibrsVictim> nibrsVictimList;
}
