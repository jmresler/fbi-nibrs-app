package org.jmresler.fbi.nibrs.services;

import org.jmresler.fbi.nibrs.Agencies;
import org.jmresler.fbi.nibrs.dao.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenciesService {

    @Autowired
    protected AgencyRepository agencyRepository;

    private static final Agencies EMPTY_AGENCY = new Agencies(){{
        setAgencyId(-1);
    }};

    public Agencies findAgencyById(final long agencyId) {
        var agency = agencyRepository.findById(agencyId).orElse(EMPTY_AGENCY);
        return agency;
    }

}
