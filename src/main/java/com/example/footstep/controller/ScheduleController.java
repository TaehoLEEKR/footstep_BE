package com.example.footstep.controller;

import com.example.footstep.component.security.LoginMember;
import com.example.footstep.domain.dto.schedule.DayScheduleDto;
import com.example.footstep.domain.dto.schedule.DayScheduleMemoDto;
import com.example.footstep.domain.dto.schedule.DestinationDto;
import com.example.footstep.domain.form.DayScheduleForm;
import com.example.footstep.domain.form.ScheduleRecommendForm;
import com.example.footstep.service.ScheduleService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/share-room/{shareId}")
public class ScheduleController {

    private final ScheduleService scheduleService;


    @GetMapping("/schedule")
    public ResponseEntity<List<DayScheduleDto>> getAllListSchedule(
        @PathVariable("shareId") Long shareId,
        @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {

        return ResponseEntity.ok(scheduleService.getAllListSchedule(shareId, startDate, endDate));
    }


    @GetMapping("/schedule/plan")
    public ResponseEntity<DayScheduleDto> getAllListScheduleDate(
        @PathVariable("shareId") Long shareId, @RequestParam("date") String planDate) {

        return ResponseEntity.ok(scheduleService.getAllListScheduleDate(shareId, planDate));
    }


    @GetMapping("/schedule/recommend")
    public ResponseEntity<List<DestinationDto>> getAllListScheduleRecommend(
        @PathVariable("shareId") Long shareId,
        @RequestBody @Valid ScheduleRecommendForm recommendForm) {

        return ResponseEntity.ok(
            scheduleService.getAllListScheduleRecommend(shareId, recommendForm));
    }


    @PostMapping("/schedule")
    public ResponseEntity<DayScheduleMemoDto> createOrUpdateScheduleMemo(
        @AuthenticationPrincipal LoginMember loginMember, @PathVariable("shareId") Long shareId,
        @RequestBody @Valid DayScheduleForm dayScheduleForm) {

        return ResponseEntity.ok(
            scheduleService.createOrUpdateScheduleMemo(loginMember, shareId, dayScheduleForm));
    }
}
