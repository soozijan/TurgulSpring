package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class ReportController {

            private static Repository repository = new Repository("jdbc:sqlite:C://SQlight//dohot tenua.db");

            @GetMapping("/reports")
            public ArrayList<Report> getReport(){
                ArrayList<Report> reports = repository.getAllReports();
                //  ArrayList<RestaurantDTO> restaurantDTO = new ArrayList<RestaurantDTO>();
                // restaurantDTO.add(new RestaurantDTO(1,"Tzipora","1","2",3.5f));
                return reports;
            }

            @GetMapping("/reports/{id}")
            public Report doGetReportById(@PathVariable("id") int id)
            {
                Report report = repository.getReportsById(id);
                return report;
            }

            @PostMapping("/reports")
            public void addReports(@RequestBody Report r)
            {
                repository.insertReport(r);
            }

            @PutMapping("/reports/{id}")
            public void updateReports(@PathVariable("id") int id, @RequestBody Report update_r)
            {
                repository.updateReports(update_r, id);
            }

            @DeleteMapping("/reports/{id}")
            public void delReportstById(@PathVariable("id") int id)
            {
                repository.deleteReports(id);
            }

        }


