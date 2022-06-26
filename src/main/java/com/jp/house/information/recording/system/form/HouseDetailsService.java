package com.jp.house.information.recording.system.form;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;




public interface HouseDetailsService {

    Page<HouseDetails> findAll(Integer pageNumber, String sortingField, String sortDirection);

    HouseDetails findById(Long id);

    HouseDetails save(HouseDetails houseDetails);

    void deleteById(Long id);

    Long getHouseDetailsCount();

//    DataTablesOutput<HouseDetails> findAll(DataTablesInput input);
}
