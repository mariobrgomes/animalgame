package com.br.objective.domain;

import lombok.Data;

/**
 * Created by 964456 on 15/09/2015.
 */

@Data
public abstract class Node {

    private Node parent;
    private Node rChild;
    private Node lChild;
}
