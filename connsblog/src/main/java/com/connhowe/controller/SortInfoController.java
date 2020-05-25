package com.connhowe.controller;

import com.connhowe.entity.SortInfo;
import com.connhowe.service.SortInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class SortInfoController {

    @Autowired
    private SortInfoService sortInfoService;

    @GetMapping("/sortInfos")
    public String list(Model model) {
        Collection<SortInfo> sortInfos = sortInfoService.getSortInfos();
        model.addAttribute("sortInfos", sortInfos);
        return "sort/list";
    }

    @PostMapping("/updateSort")
    public String update(SortInfo sortInfo) {
        sortInfoService.update(sortInfo);
        return "redirect:/sortInfos";
    }

    @GetMapping("/sort/{id}")
    public String toUpdateSort(@PathVariable("id") Long id, Model model) {
        SortInfo sortInfo = sortInfoService.getSortInfoById(id);
        model.addAttribute("sortInfo", sortInfo);
        return "sort/update";
    }

    @GetMapping("/delSort/{id}")
    public String delSortById(@PathVariable("id") Long id) {
        sortInfoService.delSortById(id);
        return "redirect:/sortInfos";
    }

    @PostMapping("/addSort")
    public String addSort(SortInfo sortInfo) {
        sortInfoService.addSort(sortInfo);
        return "redirect:/sortInfos";
    }

    @GetMapping("/addSort")
    public String addSort() {
        return "sort/add";
    }
}
