package com.jp.house.information.recording.system.form;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class HouseDetailsController {

    @Autowired
    private HouseDetailsService houseDetailsService;


    @GetMapping("/house-info")
    public String show(Model model) {
//        Page<HouseDetails> houseDetails = houseDetailsService.findAll();
//        model.addAttribute("listHouseInfo", houseDetails);
//        return "list-all-records";

        return showByPage(model, 1, "firstName", "asc");
    }

    @GetMapping("/house-info/page/{pageNumber}")
    public String showByPage(Model model,
                             @PathVariable(name = "pageNumber") Integer pageNumber,
                             @Param("sortingField") String sortingField,
                             @Param("sortDirection") String sortDirection) {
        Page<HouseDetails> houseDetails = houseDetailsService.findAll(pageNumber, sortingField, sortDirection);


        //current page is the value of current page being accessed
        Integer currentPage = pageNumber;
        Page<HouseDetails> page = houseDetailsService.findAll(currentPage, sortingField, sortDirection);

        List<HouseDetails> houseDetailsList = page.getContent();

        Integer totalPages = page.getTotalPages();
        Long totalElements = page.getTotalElements();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalElements", totalElements);

        model.addAttribute("sortingField", sortingField);
        model.addAttribute("sortDirection", sortDirection);

        //we are using ternary operator to specify the condition.
        String revereseDirection = sortDirection.equals("asc") ? "desc" : "asc";
        model.addAttribute("revereseSortDirection", revereseDirection);

        model.addAttribute("listHouseInfo", houseDetailsList);





        return "list-all-records";
    }

    @GetMapping("/house-info/add")
    public String add(Model model) {

        model.addAttribute("addHousInfo", new HouseDetails());
        return "create-or-update-house-info";
    }


    @PostMapping("/house-info/save")
    public String save(@ModelAttribute("addHousInfo") HouseDetails houseDetails) throws IOException {

        houseDetailsService.save(houseDetails);

        return "redirect:/house-info";
    }

    @GetMapping("/house-info/edit")
    public String edit(@RequestParam("nagarikId") Long id, Model model){
        HouseDetails updateHouseInfo = houseDetailsService.findById(id);

        model.addAttribute("addHousInfo", updateHouseInfo);
        return "create-or-update-house-info";
    }

    @GetMapping("/house-info/delete")
    public String delete(@RequestParam("nagarikId") Long id) {
        houseDetailsService.deleteById(id);

        return "redirect:/house-info";
    }
}
