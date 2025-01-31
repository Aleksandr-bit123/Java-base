package com.aston.javabase;

import com.aston.javabase.dto.RobotRequestDto;
import com.aston.javabase.model.Robot;

public class RobotMapper {

    public Robot map(RobotRequestDto requestDto) {
        return Robot.builder()
                .name(requestDto.getName())
                .number(requestDto.getNumber())
                .build();
    }
}
