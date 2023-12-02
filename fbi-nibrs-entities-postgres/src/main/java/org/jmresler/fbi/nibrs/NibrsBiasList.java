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
@Table(name = "nibrs_bias_list", catalog = "nibrs", schema = "public")
public class NibrsBiasList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "bias_id", nullable = false)
    private Short biasId;
    @Column(name = "bias_code", length = 2)
    private String biasCode;
    @Column(name = "bias_name", length = 100)
    private String biasName;
    @Column(name = "bias_desc", length = 100)
    private String biasDesc;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsBiasList")
    private List<NibrsBiasMotivation> nibrsBiasMotivationList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsBiasList{");
        sb.append("biasCode='").append(biasCode).append('\'');
        sb.append(", biasDesc='").append(biasDesc).append('\'');
        sb.append(", biasId=").append(biasId);
        sb.append(", biasName='").append(biasName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
