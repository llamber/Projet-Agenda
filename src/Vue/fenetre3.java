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
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import projet.agenda.GestionAgenda;
import projet.agenda.GestionAgendaIHM;
/**
 *
 * @author Pierre
 */
public class fenetre3 extends JFrame {
    private JButton bouton0 = new JButton("Afficher tous les RDV");
    private JButton bouton1 = new JButton("Afficher tous les RDV entre 2 dates");
    private JButton bouton2 = new JButton("Modifier un RDV");
    private JButton bouton3 = new JButton("Ajouter un RDV");
    private JButton bouton4 = new JButton("Supprimer un RDV");
    private JButton bouton5 = new JButton("Supprimer tous les RDV");
    private JButton bouton6 = new JButton("Sauvegarder & fermer l’agenda");
    
    public fenetre3()
    {
        
        //titre de la fenetre
        setTitle("Creation de l'agenda");
        //Modifier la taille
        setSize(500,400);
        //Taille nom modifiable par l'utilisateur
        setResizable(false);
        //Cliquer sur crois permet la fermeture du programme
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //Centrer la fentre par rapport à l'écran de  l'odinateur
        setLocationRelativeTo(null);
        
        //Affiche tous les RDV a faire
        bouton0.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
            JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
            String AfficherDateRDV = jop.showInputDialog(null, "Afficher tous les RDV", "L&P calendar", JOptionPane.QUESTION_MESSAGE);
            jop2.showMessageDialog(null, " ", "Identité", JOptionPane.INFORMATION_MESSAGE);   
        }    
        });
        
        //Afficher les RDV entre 2 dates a faire 
        bouton1.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
            JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
            String AfficherDateRDV = jop.showInputDialog(null, "Afficher tous les RDV entre 2 dates", "L&P calendar", JOptionPane.QUESTION_MESSAGE);
            jop2.showMessageDialog(null, "Les RDV entre ces deux dates sont : " + AfficherDateRDV, "Identité", JOptionPane.INFORMATION_MESSAGE);            
        }
        });
        
        //Modifier un RDV
        bouton2.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
            JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
            String modifRDV1 = jop.showInputDialog(null, "Mettez la date du RDV que vous voulez modifier", "L&P calendar", JOptionPane.QUESTION_MESSAGE);
            String modifDate = jop.showInputDialog(null, "Mettez la nouvelle date du RDV", "L&P calendar", JOptionPane.QUESTION_MESSAGE);
            String modifhDebut = jop.showInputDialog(null, "Ajouter la nouvelle heure de début", "L&P calendar", JOptionPane.QUESTION_MESSAGE);
            String modifhFin = jop.showInputDialog(null, "Ajouter la nouvelle heure de fin", "L&P calendar", JOptionPane.QUESTION_MESSAGE);
            String modiflibelle = jop.showInputDialog(null, "Ajouter le nouveau commentaire", "L&P calendar", JOptionPane.QUESTION_MESSAGE);
            jop.showMessageDialog(null, "Le rendez-vous est le " + modifDate + " de " + modifhDebut + " a " + modifhFin + "\n" + "Commentaire : " + modiflibelle , "Identité", JOptionPane.INFORMATION_MESSAGE);
            
        }
        });
        
        //Ajouter un RDV
        bouton3.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
            JOptionPane jop3 = new JOptionPane(), jop4 = new JOptionPane();
            String saisiDate = jop3.showInputDialog(null, "Donnez une date", "L&P calendar", JOptionPane.QUESTION_MESSAGE);
            String saisiHeureDebut = jop3.showInputDialog(null, "Ajouter une heure de début", "L&P calendar", JOptionPane.QUESTION_MESSAGE);
            String saisiHeureFin = jop3.showInputDialog(null, "Ajouter une heure de fin", "L&P calendar", JOptionPane.QUESTION_MESSAGE);
            String saisiLibelle = jop3.showInputDialog(null, "Ajouter un commentaire", "L&P calendar", JOptionPane.QUESTION_MESSAGE);
            String saisiRappel = jop3.showInputDialog(null, "Ajouter un commentaire", "L&P calendar", JOptionPane.QUESTION_MESSAGE);
            //Creation du RDV il manque l'ajout de ce rendez vous dans l'agenda
            GestionAgendaIHM.créerRdv(saisiDate, saisiHeureDebut, saisiHeureFin, saisiLibelle, saisiRappel);
            jop4.showMessageDialog(null, "Le rendez-vous est le " + saisiDate + " de " + saisiHeureDebut + " a " + saisiHeureFin + "\n" + "Commentaire : " + saisiLibelle , "Identité", JOptionPane.INFORMATION_MESSAGE);
            
        }   
        });
        
        //Supprimer un RDV
        bouton4.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
            JOptionPane jop5 = new JOptionPane(), jop6 = new JOptionPane();
            String DateRDVsupprimer = jop5.showInputDialog(null, "Quelle date de RDV voulez vous supprimer ?", "L&P calendar", JOptionPane.QUESTION_MESSAGE);
            jop6.showMessageDialog(null, "La date" + DateRDVsupprimer + "est supprimé" , "Identité", JOptionPane.INFORMATION_MESSAGE); 
            
        }
        });
        
        //Supprimer tous les RDV
        bouton5.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
            JOptionPane jop7 = new JOptionPane();
            jop7.showMessageDialog(null, "Tous les RDV sont supprimés", "Identité", JOptionPane.INFORMATION_MESSAGE); 
        }
        });
        
        //Sauvegarder et quitter
        bouton6.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
            JOptionPane jop8 = new JOptionPane();
            jop8.showMessageDialog(null, "RDV enregistré", "Identité", JOptionPane.INFORMATION_MESSAGE); 
        }
        });
        //gestion ergonomie
        //4 ligne sur 1 colonnes
        GridLayout GL = new GridLayout();
        GL.setColumns(1);
        GL.setRows(7);
        setLayout(GL);
        //ajout des panneaux sur la fenetre
        getContentPane().add(bouton0);
        getContentPane().add(bouton1);
        getContentPane().add(bouton2);
        getContentPane().add(bouton3);
        getContentPane().add(bouton4);
        getContentPane().add(bouton5);
        getContentPane().add(bouton6);
    }
}
