package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_using_list", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "suspectUsingId")
public class NibrsUsingList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "suspect_using_id", nullable = false)
    private Short suspectUsingId;
    @Column(name = "suspect_using_code")
    private Character suspectUsingCode;
    @Column(name = "suspect_using_name", length = 100)
    private String suspectUsingName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsUsingList")
    private List<NibrsSuspectUsing> nibrsSuspectUsingList;
}
