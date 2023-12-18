package org.jmresler.fbi.nibrs.mappers;

import org.jmresler.fbi.nibrs.NibrsOffender;
import org.jmresler.fbi.nibrs.dto.NibrsOffenderDTO;
import org.mapstruct.Mapper;

@Mapper
public interface NibrsOffenderMapper {

    NibrsOffender map(NibrsOffenderDTO nibrsOffenderDTO);

    NibrsOffenderDTO map(NibrsOffender nibrsOffender);

}
