package org.jmresler.fbi.nibrs.mappers;

import org.jmresler.fbi.nibrs.NibrsIncident;
import org.jmresler.fbi.nibrs.NibrsMonth;
import org.jmresler.fbi.nibrs.dto.NibrsIncidentDTO;
import org.jmresler.fbi.nibrs.dto.NibrsMonthDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = NibrsIncidentMapper.class)
public interface NibrsMonthMapper {

    NibrsMonth map(final NibrsMonthDTO nibrsMonthDTO);

    NibrsMonthDTO map(final NibrsMonth nibrsMonthDTO);

    List<NibrsMonth> mapToMonthList(final List<NibrsMonthDTO> nibrsMonthDTOList);

    List<NibrsMonthDTO> mapToMonthDtoList(final List<NibrsMonth> nibrsMonthList);
}
