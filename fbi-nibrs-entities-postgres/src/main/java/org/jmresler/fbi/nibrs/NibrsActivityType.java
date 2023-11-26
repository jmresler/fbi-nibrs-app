package org.jmresler.fbi.nibrs;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import lombok.Data;

/**
 *
 * @author johnm
 */
@Data
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
    @OneToMany(mappedBy = "activityTypeId")
    private Collection<NibrsVictim> nibrsVictimCollection;
}
