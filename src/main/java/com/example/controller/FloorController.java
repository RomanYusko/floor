package com.example.controller;

import com.example.model.Floor;
import com.example.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;

@Controller
public class FloorController {

    private final FloorService floorService;

    @Autowired
    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @GetMapping("/floors")
    public String findAll(Model model) {
        List<Floor> floors = floorService.findAll();
        model.addAttribute("floors", floors);
        return "list";
    }

    @GetMapping("/create")
    public String createForm(Floor floor) {
        return "create";
    }

    @PostMapping("/create")
    public String createFloor(Floor floor) {
        floorService.saveFloor(floor);
        return "redirect:/floors";
    }

    @GetMapping("/delete/{id}")
    public String deleteFloor(@PathVariable("id") int id) {
        floorService.deleteById(id);
        return "redirect:/floors";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") int id, Model model) {
        Floor floor = floorService.findById(id);
        model.addAttribute("floor", floor);
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(Floor floor) {
        floorService.saveFloor(floor);
        return "redirect:/floors";
    }
}

