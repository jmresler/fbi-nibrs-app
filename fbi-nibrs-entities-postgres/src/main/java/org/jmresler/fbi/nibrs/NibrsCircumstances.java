package org.jmresler.fbi.nibrs;

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
@Table(name = "nibrs_circumstances", catalog = "nibrs", schema = "public")
public class NibrsCircumstances implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "circumstances_id", nullable = false)
    private Short circumstancesId;
    @Column(name = "circumstances_type")
    private Character circumstancesType;
    @Column(name = "circumstances_code")
    private Short circumstancesCode;
    @Column(name = "circumstances_name", length = 100)
    private String circumstancesName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsCircumstances")
    private List<NibrsVictimCircumstances> nibrsVictimCircumstancesList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NibrsCircumstances{");
        sb.append("circumstancesCode=").append(circumstancesCode);
        sb.append(", circumstancesId=").append(circumstancesId);
        sb.append(", circumstancesName='").append(circumstancesName).append('\'');
        sb.append(", circumstancesType=").append(circumstancesType);
        sb.append('}');
        return sb.toString();
    }
}
