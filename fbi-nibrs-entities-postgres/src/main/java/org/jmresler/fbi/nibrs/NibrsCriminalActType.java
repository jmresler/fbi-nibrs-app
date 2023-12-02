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
@Table(name = "nibrs_criminal_act_type", catalog = "nibrs", schema = "public")
public class NibrsCriminalActType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "criminal_act_id", nullable = false)
    private Short criminalActId;
    @Column(name = "criminal_act_code")
    private Character criminalActCode;
    @Column(name = "criminal_act_name", length = 100)
    private String criminalActName;
    @Column(name = "criminal_act_desc", length = 300)
    private String criminalActDesc;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsCriminalActType")
    private List<NibrsCriminalAct> nibrsCriminalActList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsCriminalActType{");
        sb.append("criminalActCode=").append(criminalActCode);
        sb.append(", criminalActDesc='").append(criminalActDesc).append('\'');
        sb.append(", criminalActId=").append(criminalActId);
        sb.append(", criminalActName='").append(criminalActName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
