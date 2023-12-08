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
@Table(name = "ref_race")
public class RefRace implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "race_id", nullable = false)
    private Short raceId;
    @Column(name = "race_code", nullable = false, length = 2)
    private String raceCode;
    @Column(name = "race_desc", nullable = false, length = 100)
    private String raceDesc;
    @Column(name = "sort_order")
    private Short sortOrder;
    @Column(name = "start_year")
    private Short startYear;
    @Column(name = "end_year")
    private Short endYear;
    @Column(name = "notes", length = 1000)
    private String notes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "raceId")
    private Collection<NibrsArrestee> nibrsArresteeCollection;
    @OneToMany(mappedBy = "raceId")
    private Collection<NibrsOffender> nibrsOffenderCollection;
    @OneToMany(mappedBy = "raceId")
    private Collection<NibrsVictim> nibrsVictimCollection;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.RefRace[" + raceId + "]";
    }

}
