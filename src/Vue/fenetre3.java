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
public class fenetre3 extends JFrame {
    private JButton bouton1 = new JButton("Afficher tous les RDV entre 2 dates");
    private JButton bouton2 = new JButton("Afficher les RDV filtrés sur critère(s)");
    private JButton bouton3 = new JButton("Modifier un RDV");
    private JButton bouton4 = new JButton("Ajouter un RDV");
    private JButton bouton5 = new JButton("Supprimer un RDV");
    private JButton bouton6 = new JButton("Supprimer tous les RDV");
    private JButton bouton7 = new JButton("Sauvegarder & fermer l’agenda");
    public fenetre3()
    {
        //titre de la fenetre
        setTitle("Creation de l'agenda");
        //Modifier la taille
        setSize(500,400);
        //Taille nom modifiable par l'utilisateur
        setResizable(false);
        //Cliquer sur crois permet la fermeture du programme
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //Centrer la fentre par rapport à l'écran de  l'odinateur
        setLocationRelativeTo(null);
        bouton1.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
            
        }
        });
        bouton2.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
            
        }
        });
        bouton3.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
            
        }
        });
        bouton4.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
            
        }
        });
        bouton5.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
            
        }
        });
        bouton6.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
            
        }
        });
        bouton7.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
            
        }
        });
        //gestion ergonomie
        //4 ligne sur 1 colonnes
        GridLayout GL = new GridLayout();
        GL.setColumns(1);
        GL.setRows(7);
        setLayout(GL);
        //ajout des panneaux sur la fenetre
        getContentPane().add(bouton1);
        getContentPane().add(bouton2);
        getContentPane().add(bouton3);
        getContentPane().add(bouton4);
        getContentPane().add(bouton5);
        getContentPane().add(bouton6);
        getContentPane().add(bouton7);
    }
}
