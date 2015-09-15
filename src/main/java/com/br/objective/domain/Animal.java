package com.br.objective.domain;

import lombok.Data;

/**
 * Created by 964456 on 15/09/2015.
 */

@Data
public class Animal extends Node {

    private String name;

    public Animal(String name) {
        this.name = name;
    }
}
