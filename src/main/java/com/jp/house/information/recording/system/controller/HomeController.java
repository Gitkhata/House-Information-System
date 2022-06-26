package com.jp.house.information.recording.system.controller;

import com.jp.house.information.recording.system.form.HouseDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/index"})
    public String home() {

        return "index";
    }

}
