package org.jmresler.fbi.nibrs.dao;

import org.jmresler.fbi.nibrs.Agencies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agencies, Integer> {
}
