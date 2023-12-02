package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "nibrs_victim_circumstances", catalog = "nibrs", schema = "public")
public class NibrsVictimCircumstances implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsVictimCircumstancesPK nibrsVictimCircumstancesPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @JsonBackReference
    @JoinColumn(name = "circumstances_id", referencedColumnName = "circumstances_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsCircumstances nibrsCircumstances;
    @JsonBackReference
    @JoinColumn(name = "justifiable_force_id", referencedColumnName = "justifiable_force_id")
    @ManyToOne
    private NibrsJustifiableForce justifiableForceId;
    @JsonBackReference
    @JoinColumn(name = "victim_id", referencedColumnName = "victim_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsVictim nibrsVictim;


}
