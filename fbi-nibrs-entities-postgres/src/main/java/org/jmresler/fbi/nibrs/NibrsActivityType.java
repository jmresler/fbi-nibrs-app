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
@Table(name = "nibrs_activity_type", catalog = "nibrs", schema = "public")
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
    @JsonManagedReference
    @OneToMany(mappedBy = "activityTypeId")
    private List<NibrsVictim> nibrsVictimList;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsActivityType{");
        sb.append("activityTypeCode='").append(activityTypeCode).append('\'');
        sb.append(", activityTypeId=").append(activityTypeId);
        sb.append(", activityTypeName='").append(activityTypeName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
