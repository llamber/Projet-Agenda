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
/**
 *
 * @author Ludo
 */
public class AffichageSimple extends JFrame {
    private JLabel label1 = new JLabel("Bonjour et bienvenue dans le L&P calendar");
    private JLabel label2 = new JLabel("");
    private JPanel conteneur = new JPanel();
    private JButton bouton1 = new JButton("Créer agenda");
    private JButton bouton2 = new JButton("Ouvrir agenda");
    private JButton bouton3 = new JButton("Annuler");
    private JTextField texte1 = new JTextField("Nom");
    
    public AffichageSimple() 
    {
    //Initialisation
    
    
    //String nomAg = ag.getNomPersonne();
    //app.Agenda(ag);
    CardLayout cardL = new CardLayout();
    JPanel content = new JPanel();
    setTitle("L&P Calendar");
    //Modifier la taille
    setSize(600,600);
    //Taille nom modifiable par l'utilisateur
    setResizable(false);
    //Cliquer sur crois permet la fermeture du programme
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //Centrer la fentre par rapport à l'écran de  l'odinateur
    setLocationRelativeTo(null);
    //Creation pan1 ajout d'un texte et couleur pour diferencier du pan2
    JPanel pan1 = new JPanel();
    pan1.add(new JTextField("Creation de l'agenda"));
    
    pan1.setBackground(Color.BLUE);
    //Creation pan2 ajout d'un texte et couleur pour diferencier du pan3 et pan1
    JPanel pan2 = new JPanel();
    pan2.add(new JTextField("Ouverture de l'agenda"));    
    pan2.setBackground(Color.RED);
    //Creation du pan3 
    JPanel pan3 = new JPanel();
    pan3.add(new JTextField("Annuler"));    
    pan3.setBackground(Color.YELLOW);  
    //ajout du gestionnaire de composant BorderLayout
    //conteneur.setLayout(new BorderLayout());
    //Ajout de label
    //conteneur.add(label1,BorderLayout.NORTH);
    //Ajout bouton sur le conteneur
    //conteneur.add(bouton1,BorderLayout.WEST);
    //conteneur.add(bouton2,BorderLayout.CENTER);
    //conteneur.add(bouton3,BorderLayout.EAST);
    //setContentPane(conteneur); 
    //Creation du panneau bouton pane qui va contenir nos boutons
    //Gestion de la creation de l'agenda
    JPanel boutonPane1 = new JPanel();
    bouton1.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
    cardL.next(content);
    //Agenda ag = new Agenda(texte1.getText());
    System.out.println("chopé!");
    }
    });
    //Gestion de l'ouverture de l'agenda 
    JPanel boutonPane2 = new JPanel();
    bouton2.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
    cardL.next(content);
    
    }
    }); 
    //Gestion de l'annulation de la page
    JPanel boutonPane3 = new JPanel();
    bouton3.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
    cardL.next(content);
    System.exit(0);
    }
    });      
    //Ajout du bouton sur le panneau
    boutonPane1.add(bouton1);
    boutonPane2.add(bouton2);
    boutonPane3.add(bouton3);
    //Definition du Layout
    content.setLayout(cardL);
    //ajout des panneaux pan1 et pan2 et pan3 sur notre content
    content.add(pan1);
    content.add(pan2);
    content.add(pan3);
    //4 ligne sur 1 colonnes
    GridLayout gl = new GridLayout();
    gl.setColumns(1);
    gl.setRows(4);
    setLayout(gl);
    //ajout des panneaux boutonPane et content à notre fenetre
    getContentPane().add(label1);
    getContentPane().add(bouton1);
    getContentPane().add(texte1);
    getContentPane().add(bouton2);
    getContentPane().add(label2);
    getContentPane().add(bouton3);
    getContentPane().add(content);

    }            
    
    
    static public void affichermenu1() {
        System.out.println("Bienvenue dans le menu principal");
        System.out.println("1: nouvel agenda" + "\n" + "2: ouvrir agenda" + "\n" + "3: annuler");
    }

    static public void afficherMenu2() {

        System.out.println("Bonjour Bienvenue dans le Menu de gestion d'agenda");
        //Instruction du menu
        System.out.println("Taper 1 : Afficher tous les RDV entre 2 dates");
        System.out.println("Taper 2 : Afficher les RDV filtrés sur critère(s)");
        System.out.println("Taper 3 : Modifier un RDV");
        System.out.println("Taper 4 : Ajouter un RDV");
        System.out.println("Taper 5 : Supprimer un RDV");
        System.out.println("Taper 6 : Supprimer tous les RDV");
        System.out.println("Taper 7 : Sauvegarder & fermer l’agenda");
    }

    static public void affichageTraitementMenu1(int choix1) {
        switch (choix1) {
            case 1:
                System.out.println("Creation d'un agenda");
                break;
            case 2:
                System.out.println("Ouverture de l'agenda");
                break;
            case 3:
                System.out.println("Fermeture de l'agenda");
                break;
        }
    }

    static public void affichageTraitementMenu2(int choix1) {
        switch (choix1) {
            case 0:
                System.out.println("Affichage tous les RDV");
                break;
            case 1:
                System.out.println("Affichage tous les RDV entre 2 dates");
                break;
            case 2:
                System.out.println(" Affichage des RDV filtrés sur critère(s)");
                break;
            case 3:
                System.out.println("Modification d'un rendez-vous");
                break;
            case 4:
                System.out.println("Ajout d'un RDV");
                break;
            case 5:
                System.out.println("Suppression d'un RDV");
                break;
            case 6:
                System.out.println("Suppression de tous les RDV");
                break;
            case 7:
                System.out.println("Sauvegarde & fermeture de l’agenda");
                break;
        }
    }

    static public void afficherPasDagenda() {
        System.out.println("Il n'y a pas d'agenda à ce nom");
    }

    // Demande de saisi -------------------------------------------------------------------------------------
    static public void afficherSaisiNom() {
        System.out.println("Saisir votre nom  ");
    }

    static public void afficherSaisiDate() {
        System.out.println("Saisir une date au format jj/mm/aaaaa :");
    }

    static public void afficherSaisiHeureDebut() {
        System.out.println("Saisir une heure de debut au format hh:mm :");
    }

    static public void afficherSaisiHeureFin() {
        System.out.println("Saisir une heure de fin au format hh:mm :");
    }

    static public void afficherHeureFinSuperieur() {
        System.out.println("Saisir une date de fin plus tard que l'heure de debut au format hh:mm :");
    }

    static public void afficherSaisiLibelle() {
        System.out.println("Saisir un libelle");
    }
    
    static public void afficherSelectRdv(){
        System.out.println("Saisir le numéro du RDV");
    }

    static public void afficherSaisiRappel() {
        System.out.println("Souhaitez vous un rappel ? O/N");
    }

    static public void afficherRappelOui() {
        System.out.println("Le rendez vous sera rappelé 15 minutes avant");
    }

    static public void afficherRappelNon() {
        System.out.println("Le rendez vous ne sera pas rappelé");
    }

    static public void afficherRdv(Agenda agenda) {
        Collections.sort(agenda.getListeRdv(), RendezVous.Comparator);
        for (int i = 0; i < agenda.getListeRdv().size(); i++) {
            System.out.println(i + " - Date: " + agenda.getListeRdv().get(i).getDate());
            System.out.println("Heure: " + agenda.getListeRdv().get(i).getHeureDebut() + " - " + agenda.getListeRdv().get(i).getHeureFin());
            System.out.println("Libelle: " + agenda.getListeRdv().get(i).getLibelle());
            System.out.println("Rappel:  " + agenda.getListeRdv().get(i).isRappel() + "\n" + "\n");
        }
    }

    static public void afficherRDV_Entre2Dates(Agenda agenda, int i) {
        System.out.println(i + " - Date: " + agenda.getListeRdv().get(i).getDate());
            System.out.println("Heure: " + agenda.getListeRdv().get(i).getHeureDebut() + " - " + agenda.getListeRdv().get(i).getHeureFin());
            System.out.println("Libelle: " + agenda.getListeRdv().get(i).getLibelle());
            System.out.println("Rappel:  " + agenda.getListeRdv().get(i).isRappel() + "\n" + "\n");
    }
    
     static public void afficherRDV_SurCritères(Agenda agenda, int choix){
         System.out.println("Sélectionner le critère");       
         switch (choix) {
            case 0:
                System.out.println("Affichage tous les RDV");
                break;
            case 1:
                System.out.println("1 - Date");
                break;
            case 2:
                System.out.println("2 - Heure de début");
                break;
            case 3:
                System.out.println("3 - Heure de fin");
                break;
            case 4:
                System.out.println("4 - libelle");
                break;
        }
     }
}
