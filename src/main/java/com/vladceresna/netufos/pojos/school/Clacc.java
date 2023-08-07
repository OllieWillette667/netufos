package com.vladceresna.netufos.pojos.school;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@AllArgsConstructor
public class Clacc {
    private @Getter String name,
                   headTeacher;
    private @Getter ArrayList<String> students;
    private @Getter ArrayList<Day> schedule;
    private @Getter ArrayList<CSubject> subjects;
}
