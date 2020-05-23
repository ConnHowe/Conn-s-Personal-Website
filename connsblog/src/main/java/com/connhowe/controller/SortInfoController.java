package com.connhowe.controller;

import com.connhowe.entity.SortInfo;
import com.connhowe.mapper.SortInfoMapper;
import com.connhowe.service.SortInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Date;

@Controller
public class SortInfoController {

    @Autowired
    private SortInfoService sortInfoService;

    @GetMapping("/getAllSort")
    public String getAll(Model model) {
        Collection<SortInfo> sortInfos = sortInfoService.getSortInfos();
        model.addAttribute("sortInfos", sortInfos);
        return "admin";
    }

    @PostMapping("/updateSort")
    public String update(SortInfo sortInfo) {
        sortInfoService.update(sortInfo);
        return "redirect:/admin/sortmanager";
    }


}
