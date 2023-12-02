package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "nibrs_using_list", catalog = "nibrs", schema = "public")
public class NibrsUsingList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "suspect_using_id", nullable = false)
    private Short suspectUsingId;
    @Column(name = "suspect_using_code")
    private Character suspectUsingCode;
    @Column(name = "suspect_using_name", length = 100)
    private String suspectUsingName;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsUsingList")
    private Collection<NibrsSuspectUsing> nibrsSuspectUsingCollection;
}
