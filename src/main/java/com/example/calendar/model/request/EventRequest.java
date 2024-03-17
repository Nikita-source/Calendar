package com.example.calendar.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {

    @NotBlank(message = "Cannot be blank")
    @Size(max = 255, message = "Size cannot be longer then 255 symbols")
    @ApiModelProperty("Event title")
    private String title;

    @ApiModelProperty("Event start time")
    private LocalDateTime startTime;
}
