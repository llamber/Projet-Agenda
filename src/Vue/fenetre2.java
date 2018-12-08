/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.*;
import java.util.Collections;
import Modele.Agenda;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import projet.agenda.GestionAgenda;

/**
 *
 * @author Pierre
 */
public class fenetre2 extends JFrame {

    private JButton bouton1 = new JButton("Mettre le nom agenda");
    private JButton bouton2 = new JButton("annuler");

    public fenetre2() {
        //titre de la fenetre
        setTitle("Creation de l'agenda");
        //Modifier la taille
        setSize(400, 400);
        //Taille nom modifiable par l'utilisateur
        setResizable(false);
        //Cliquer sur crois permet la fermeture du programme
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //Centrer la fentre par rapport à l'écran de  l'odinateur
        setLocationRelativeTo(null);
        //Gestion de la creation de l'agenda
        bouton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                //Agenda ag = new Agenda(nomag.getText());
                //JOptionPane.showMessageDialog(, "Printing complete");
                JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
                String nom = jop.showInputDialog(null, "Bonjour veuillez saisir le nom de votre agenda", "L&P calendar", JOptionPane.QUESTION_MESSAGE);
                jop2.showMessageDialog(null, "Votre nom est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);

            }
        });
        bouton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.exit(0);

            }
        });
        //gestion ergonomie
        //4 ligne sur 1 colonnes
        GridLayout gl = new GridLayout();
        gl.setColumns(2);
        gl.setRows(3);
        setLayout(gl);
        //ajout des panneaux sur la fenetre
        getContentPane().add(bouton1);
        getContentPane().add(bouton2);

    }

}
