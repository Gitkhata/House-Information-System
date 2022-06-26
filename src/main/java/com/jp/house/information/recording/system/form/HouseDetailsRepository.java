package com.jp.house.information.recording.system.form;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface HouseDetailsRepository extends JpaRepository<HouseDetails, Long> {
    //additional methods here

}
