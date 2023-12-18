package org.jmresler.fbi.nibrs.services;


import lombok.extern.slf4j.Slf4j;
import org.jmresler.fbi.nibrs.Agencies;
import org.jmresler.fbi.nibrs.dao.AgencyRepository;
import org.jmresler.fbi.nibrs.dto.AgenciesDTO;
import org.jmresler.fbi.nibrs.exceptions.AgenciesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AgenciesService {

    @Autowired
    protected AgencyRepository repository;


    @Transactional
    public List<AgenciesDTO> getAllAgencies() {
        var dtos = new ArrayList<AgenciesDTO>();


        return dtos;
    }

    @Transactional
    public AgenciesDTO getAgenciesById(final Integer id) {
        var agenciesDto = repository.findById(id).orElseThrow(AgenciesNotFoundException::new);



        return null;
    }


}
