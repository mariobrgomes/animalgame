package com.br.objective.domain;

import javax.swing.*;

/**
 * Created by 964456 on 15/09/2015.
 */
public class Game {

    private static final String THINK = "Pense em um animal";
    private static final String TITLE = "Animais";

    Node node;

    public void newGame() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        while (JOptionPane.showConfirmDialog(null, THINK, TITLE, JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            binarySearchTree.preOrder(node.getRoot());
        }
    }

}
