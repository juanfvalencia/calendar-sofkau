package co.com.sofka.calendar.controller;


import co.com.sofka.calendar.model.ProgramDate;
import co.com.sofka.calendar.services.ProgramDateService;
import co.com.sofka.calendar.services.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class ScheduleController {

    @Autowired
    SchedulerService schedulerService;

    @Autowired
    ProgramDateService programDateService;

    @GetMapping("/generate/{date}/{id}")
    public Flux<ProgramDate> generateCalendar(@PathVariable ("date") String date, @PathVariable("id") String id){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate localDate = LocalDate.parse(date, formatter);
        Flux<ProgramDate> generado = schedulerService.generateCalendar(id, localDate);

        return programDateService.saveAll(generado);
    }

    @GetMapping("/programas")
    public Flux<ProgramDate> program(){
        return programDateService.getAll();
    }
}
