package com.jp.house.information.recording.system.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class HouseDetailsServiceImpl implements HouseDetailsService {

    //display 5 items per page
    public static final Integer PAGE_SIZE = 5;

  @Autowired
  private HouseDetailsRepository houseDetailsRepository;

    @Autowired
    public HouseDetailsServiceImpl(HouseDetailsRepository houseDetailsRepository) {
        this.houseDetailsRepository = houseDetailsRepository;
    }


//    @Override
//    public List<HouseDetails> findAll() {
//        return (List<HouseDetails>) houseDetailsRepository.findAll();
//    }

    @Override
    public Page<HouseDetails> findAll(Integer pageNumber, String sortingField, String sortDirection) {

        //we can chain other columns. For example: .and(().address
        Sort sort = Sort.by("firstName").ascending();


//        sort = sortDirection.equals("asc") ? sort.ascending() : sort.descending();

        /* pageSize defines the total elements to be displayed in a page */


        //if sort sort direction is 'asc' sort in ascending else sort in descending
        Pageable pageable = PageRequest.of(0, PAGE_SIZE
                ,
                sortDirection
                        .equals("asc") ? Sort
                        .by(sortingField)
                        .ascending()
                        : Sort
                        .by(sortingField)
                        .descending());

        return houseDetailsRepository.findAll(pageable);
    }

    @Override
    public HouseDetails findById(Long id) {
        Optional<HouseDetails> houseDetails = houseDetailsRepository.findById(id);

        if (houseDetails.isPresent()) {
            return houseDetails.get();
        } else {
            throw new RuntimeException("Record not found for id: " + id);
        }
    }

    @Override
    public HouseDetails save(HouseDetails houseDetails) {
        return houseDetailsRepository.save(houseDetails);
    }

    @Override
    public void deleteById(Long id) {
        houseDetailsRepository.deleteById(id);
    }

    public Long getHouseDetailsCount() {
        return houseDetailsRepository.count();
    }


}
