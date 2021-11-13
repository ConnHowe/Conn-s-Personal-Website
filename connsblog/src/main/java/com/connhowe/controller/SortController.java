package com.connhowe.controller;

import com.connhowe.entity.SortDO;
import com.connhowe.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class SortController {

    @Autowired
    private SortService sortService;

    @GetMapping("/sort")
    public String list(Model model) {
        Collection<SortDO> sortDOs = sortService.getSortInfos();
        model.addAttribute("sortDOs", sortDOs);
        return "sort/list";
    }

    @PostMapping("/updateSort")
    public String update(SortDO sortDO) {
        sortService.update(sortDO);
        return "redirect:/sort";
    }

    @GetMapping("/sort/{id}")
    public String toUpdateSort(@PathVariable("id") Long id, Model model) {
        SortDO sortDO = sortService.getSortInfoById(id);
        model.addAttribute("sortDO", sortDO);
        return "sort/update";
    }

    @GetMapping("/delSort/{id}")
    public String delSortById(@PathVariable("id") Long id) {
        sortService.delSortById(id);
        return "redirect:/sort";
    }

    @PostMapping("/addSort")
    public String addSort(SortDO sortDO) {
        sortService.addSort(sortDO);
        return "redirect:/sort";
    }

    @GetMapping("/addSort")
    public String addSort() {
        return "sort/add";
    }
}
