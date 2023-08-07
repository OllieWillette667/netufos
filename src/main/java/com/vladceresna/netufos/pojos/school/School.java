package com.vladceresna.netufos.pojos.school;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@AllArgsConstructor
public class School {
    private @Getter String name;

    private @Getter String director;

    private @Getter ArrayList<String> teachers,
                              students,
                              parents,
                              managers;

    private @Getter ArrayList<Clacc> claccs;
    private @Getter ArrayList<SSubject> subjects;

}
