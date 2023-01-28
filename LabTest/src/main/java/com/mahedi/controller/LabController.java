package com.mahedi.controller;

import com.mahedi.model.Lab;
import com.mahedi.repository.LabRepository;
import com.mahedi.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LabController {

    @Autowired
    private LabService labService;

    @GetMapping("/")
    public String all(Model model)
    {
        model.addAttribute("listoftest",labService.getAllTest());
        return "index";
    }

    @GetMapping("/newsave")
    public String newtest(Model model){
        Lab lab =new Lab();
        model.addAttribute("newlabtest",lab);
        return "newsave";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Lab lab){
        labService.save(lab);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable long id, Model model){
        Lab lab=labService.updatetest(id);
        model.addAttribute("updatelist",lab);
        return "update";
    }
}
