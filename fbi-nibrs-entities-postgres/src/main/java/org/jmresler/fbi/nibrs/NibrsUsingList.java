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
@Table(name = "nibrs_using_list", catalog = "nibrs", schema = "public")
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
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsUsingList")
    private List<NibrsSuspectUsing> nibrsSuspectUsingList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsUsingList{");
        sb.append("suspectUsingCode=").append(suspectUsingCode);
        sb.append(", suspectUsingId=").append(suspectUsingId);
        sb.append(", suspectUsingName='").append(suspectUsingName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
