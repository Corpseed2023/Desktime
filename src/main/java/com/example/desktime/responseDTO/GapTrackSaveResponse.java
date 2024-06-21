package com.example.desktime.responseDTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class GapTrackSaveResponse {
    private Long id;
    private Long userId;
    private LocalDate date;
    private LocalDateTime gapStartTime;
    private String reason;
    private String gapTime;
    private String workingStatus;
    private Boolean availability;
}
