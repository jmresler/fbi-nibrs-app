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
@Table(name = "nibrs_prop_desc_type")
public class NibrsPropDescType implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "prop_desc_id", nullable = false)
    private Short propDescId;
    @Column(name = "prop_desc_name", length = 100)
    private String propDescName;
    @Column(name = "prop_desc_code", length = 2)
    private String propDescCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsPropDescType")
    private Collection<NibrsPropertyDesc> nibrsPropertyDescCollection;
}