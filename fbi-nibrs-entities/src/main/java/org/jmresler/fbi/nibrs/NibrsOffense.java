/*
 * Copyright 2023 jmres.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jmresler.fbi.nibrs;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author John M. Resler
 * @version 1.0.0
 */
@Data
@Entity
@Table(name = "nibrs_offense", catalog = "fbi_crime_stats", schema = "public")
public class NibrsOffense implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "data_year")
    private Integer dataYear;
    @Id
    @Column(name = "offense_id", nullable = false)
    private Long offenseId;
    @Column(name = "attempt_complete_flag")
    private Character attemptCompleteFlag;
    @Column(name = "num_premises_entered")
    private Short numPremisesEntered;
    @Column(name = "method_entry_code")
    private Character methodEntryCode;
    @JoinColumn(name = "incident_id", referencedColumnName = "incident_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsIncident incidentId;
    @JoinColumn(name = "location_id", referencedColumnName = "location_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsLocationType locationId;
    @JoinColumn(name = "offense_code", referencedColumnName = "offense_code", nullable = false)
    @ManyToOne(optional = false)
    private NibrsOffenseType offenseCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private Collection<NibrsVictimOffense> nibrsVictimOffenseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private Collection<NibrsWeapon> nibrsWeaponCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private Collection<NibrsCriminalAct> nibrsCriminalActCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private Collection<NibrsBiasMotivation> nibrsBiasMotivationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private Collection<NibrsSuspectUsing> nibrsSuspectUsingCollection;
}
