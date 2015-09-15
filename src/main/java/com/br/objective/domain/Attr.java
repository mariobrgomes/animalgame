package com.br.objective.domain;

import lombok.Data;

/**
 * Created by 964456 on 15/09/2015.
 */

@Data
public class Attr extends Node {

    private String attr;

    public Attr(String attr) {
        this.attr = attr;
    }
}
