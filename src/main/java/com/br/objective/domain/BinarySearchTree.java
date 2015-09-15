package com.br.objective.domain;

import javax.print.DocFlavor;
import javax.swing.*;

/**
 * Created by 964456 on 15/09/2015.
 */
public class BinarySearchTree {

    private static final String ROOT_ATTR = "vive na água";
    private static final String ROOT_R = "Macaco";
    private static final String ROOT_L = "Tubarão";
    private static final String ASK_ATTR = "askAttr";
    private static final String GUESS = "guess";
    private static final String ANIMAL_GUESSED = "O animal que você pensou é?";
    private static final String ANIMALS = "Animais";
    private static final String WHICH_ANIMAL = "Em qual animal você pensou?";
    private static final String ANIMAL = "Um(a) %s _____________ mas um(a) %s n\u00e3o.";
    private static final String L = "L";
    private static final String R = "R";
    private static final String MESSAGE_WIN = "Acertei novamente!";


    private Node root;

    public BinarySearchTree() {
        root = new Attr(ROOT_ATTR);
        root.setRChild(new Animal(ROOT_R));
        root.setLChild(new Animal(ROOT_L));

        root.getLChild().setParent(root);
        root.getRChild().setParent(root);

    }

    public void messageWin() {
        JOptionPane.showMessageDialog(null, MESSAGE_WIN);
    }

    public Integer ask(Node node, String ask) {

        if (ask.equals(ASK_ATTR)) {

            Attr attr = (Attr) node;

            return JOptionPane.showConfirmDialog(null,
                                                String.format(ANIMAL_GUESSED, attr.getAttr()),
                                                ANIMALS,
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE);
        } else if (ask.equals(GUESS)) {
            Animal animal= (Animal) node;
            return JOptionPane.showConfirmDialog(null,
                                                String.format(ANIMAL_GUESSED, animal.getName()),
                                                ANIMALS,
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE);
        }
        return null;
    }

    public Node preOrder (Node current) {
        if (ask(current, ASK_ATTR) == 0) {
            current = current.getLChild();

            if (current != null) {
                if (ask(current, GUESS) == 0) {
                    messageWin();
                } else {
                    insertNode(current, L);
                }
            } else {
                current = preOrder(current.getRChild());

                if (current != null) {
                    if (ask(current, GUESS) == 0) {
                        messageWin();
                    } else {
                        insertNode(current, R);
                    }
                }
            }
        }
        return null;
    }

    public void insertNode(Node currentNode, String value) {
        Animal animal = (Animal) currentNode;
        String currentAnimal = animal.getName();
        String newAnimal = JOptionPane.showInputDialog(WHICH_ANIMAL);

        while (newAnimal == null || newAnimal.isEmpty() || !newAnimal.matches("[A-Z a-z]*")) {
            newAnimal = JOptionPane.showInputDialog(WHICH_ANIMAL);

            animal = new Animal(newAnimal);

            String message = String.format(ANIMAL, newAnimal, currentAnimal);
            String diff = JOptionPane.showInputDialog(message);

            while (diff == null || diff.isEmpty() || diff.matches("[A-Z a-z]*")){
                diff = JOptionPane.showInputDialog(message);

                Attr attr = new Attr(diff);

                if (value.equals(L)) {
                    currentNode.setLChild(attr);
                } else if (value.equals(R)) {
                    currentNode.setRChild(attr);
                }

                animal.setParent(attr);
                attr.setParent(currentNode.getParent());
                attr.setLChild(animal);
                attr.setRChild(currentNode);
            }
        }
    }
}
