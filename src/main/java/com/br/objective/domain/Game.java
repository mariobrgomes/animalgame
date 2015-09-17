package com.br.objective.domain;

import javax.swing.*;

/**
 * Created by 964456 on 15/09/2015.
 */
public class Game {

    private static final String THINK = "Pense em um animal";
    private static final String TITLE = "Animais";

    public void newGame() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        Object[] options = {"OK"};

        while (JOptionPane.showOptionDialog(null,THINK, TITLE, JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.OK_OPTION) {
            binarySearchTree.preOrder(binarySearchTree.getRoot());
        }
    }
}
