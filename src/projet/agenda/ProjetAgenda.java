/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.agenda;

import Vue.AffichageSimple;
import Modele.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author Ludo
 */
public class ProjetAgenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        AffichageSimple maFenetre = new AffichageSimple();
        maFenetre.setVisible(true);
        Scanner sc = new Scanner(System.in);
        int choix1 = 0;
        do {
            AffichageSimple.affichermenu1();
            choix1 = sc.nextInt();
            traiterChoixMenu1(choix1);
        } while (choix1 != 3);

    }

    /**
     * @param choix
     * @throws IOException
     */
    static private void traiterChoixMenu1(int choix) throws IOException {
        AffichageSimple.affichageTraitementMenu1(choix);

        switch (choix) {
            case 1:
                traiterChoixCreerAgenda();
                break;
            case 2:
                traiterChoixOuvrirAgenda();
                break;
            case 3:
                break;
        }
    }

    /**
     * @return
     */
    static private String lireNomFichierAgenda() {
        AffichageSimple.afficherSaisiNom();
        Scanner sc = new Scanner(System.in);
        String nomFichierAgenda = sc.nextLine();
        return nomFichierAgenda;
    }

    static private void traiterChoixCreerAgenda() {
        Agenda nouvelAgenda = new Agenda();
        String nomFichier = lireNomFichierAgenda();
        try {
            save(nouvelAgenda,nomFichier);
        } catch (IOException ex) {
            Logger.getLogger(ProjetAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @throws IOException
     */
    static private void traiterChoixOuvrirAgenda() throws IOException {
        Agenda agendaOuvert = null;
        String nomFichier = lireNomFichierAgenda();
        agendaOuvert = load(nomFichier);
        gererAgenda(agendaOuvert, nomFichier);
    }

    /**
     * @param agenda
     */
    static public void gererAgenda(Agenda agenda, String nomFichier) {
        int choix;
        Scanner sc = new Scanner(System.in);
        do {
            AffichageSimple.afficherMenu2();
            choix = sc.nextInt();
            traiterChoixMenu2(choix, agenda);
        } while (choix != 7);
        try {
            save(agenda, nomFichier);
        } catch (IOException ex) {
            Logger.getLogger(ProjetAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param choix
     * @param agenda
     */
    static public void traiterChoixMenu2(int choix, Agenda agenda) {
        AffichageSimple.affichageTraitementMenu2(choix);

        switch (choix) {
            case 0:
                AffichageSimple.afficherRdv(agenda);
                break;
            case 1:
                traiterChoixAfficherRDV_Entre2Dates(agenda);
                break;

            case 2:
                traiterChoixAfficherRDV_SurCritères(agenda);
                break;

            case 3:

                traiterChoixModifierRDV(agenda);
                break;

            case 4:
                traiterChoixAjouterRDV(agenda);
                break;

            case 5:
                traiterChoixSupprimerTousRDV(agenda);
                break;

            case 6:
                traiterChoixSupprimerRDV(agenda);
                break;
            case 7:
                break;
        }
    }

    /**
     * @param agenda
     */
    static private void traiterChoixAfficherRDV_Entre2Dates(Agenda agenda) {
        LocalDate date1 = Date();
        LocalDate date2 = Date();
        for (int i = 0; i < agenda.getListeRdv().size(); i++) {
            if (agenda.getListeRdv().get(i).getDate().isAfter(date1) && agenda.getListeRdv().get(i).getDate().isBefore(date2)) {
                AffichageSimple.afficherRDV_Entre2Dates(agenda, i);
            }
        }
    }

    /**
     * @param agenda
     */
    static private void traiterChoixAfficherRDV_SurCritères(Agenda agenda) {
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        AffichageSimple.afficherRDV_SurCritères(agenda, choix);
        switch (choix) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }
    }

    /**
     * @param agenda
     */
    static private void traiterChoixAjouterRDV(Agenda agenda) {
        LocalDate date = Date();
        LocalTime hDebut = heureDebut();
        LocalTime hFin = heureFin();
        boolean rappel = rappel();
        String libelle = libelle();
        RendezVous rdv = new RendezVous(date, hDebut, hFin, rappel, libelle);
        agenda.getListeRdv().add(rdv);
    }

    /**
     * @param agenda
     */
    static private void traiterChoixModifierRDV(Agenda agenda) {
        AffichageSimple.afficherRdv(agenda);
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        LocalDate date = Date();
        LocalTime hDebut = heureDebut();
        LocalTime hFin = heureFin();
        boolean rappel = rappel();
        String libelle = libelle();
        RendezVous rdv = new RendezVous(date, hDebut, hFin, rappel, libelle);
        agenda.getListeRdv().set(index, rdv);
    }

    /**
     * @param agenda
     */
    static private void traiterChoixSupprimerRDV(Agenda agenda) {
        AffichageSimple.afficherRdv(agenda);
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        agenda.getListeRdv().remove(index);

    }

    /**
     * @param agenda
     */
    static private void traiterChoixSupprimerTousRDV(Agenda agenda) {
        agenda.getListeRdv().forEach((_item) -> {
            agenda.getListeRdv().remove(1);

        });
    }

    /**
     * @return
     */
    static private LocalDate Date() {
        Scanner sc = new Scanner(System.in);
        AffichageSimple.afficherSaisiDate();
        String saisiDate = sc.nextLine();
        LocalDate date = LocalDate.parse(saisiDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return date;
    }

    /**
     * @return
     */
    static private LocalTime heureDebut() {
        Scanner sc = new Scanner(System.in);
        AffichageSimple.afficherSaisiHeureDebut();
        String saisiHeureDebut = sc.nextLine();
        LocalTime heureDebut = LocalTime.parse(saisiHeureDebut, DateTimeFormatter.ofPattern("kk:mm")); //<-- kk pour une date de 0 à 24h
        return heureDebut;
    }

    /**
     * @return
     */
    static private LocalTime heureFin() {
        LocalTime heureFin;
        Scanner sc = new Scanner(System.in);
        AffichageSimple.afficherSaisiHeureFin();
        String saisiHeureFin = sc.nextLine();
        heureFin = LocalTime.parse(saisiHeureFin, DateTimeFormatter.ofPattern("kk:mm"));
        while (heureFin.isBefore(heureDebut())) { //On verifie que l'heure de début et plus petite que l'heure de fin
            AffichageSimple.afficherHeureFinSuperieur();
            saisiHeureFin = sc.nextLine();
            heureFin = LocalTime.parse(saisiHeureFin, DateTimeFormatter.ofPattern("kk:mm"));
        }
        return heureFin;
    }

    /**
     * @return
     */
    static private String libelle() {
        Scanner sc = new Scanner(System.in);
        AffichageSimple.afficherSaisiLibelle();
        String libelle = "fzefez";//sc.nextLine();
        return libelle;
    }

    /**
     * @return
     */
    static private boolean rappel() {
        Scanner sc = new Scanner(System.in);

        String saisiRappel;
        boolean rappel;
        do {
            AffichageSimple.afficherSaisiRappel();
            saisiRappel = "N";
        } while (!("O".equals(saisiRappel) || "N".equals(saisiRappel)));
        rappel = "O".equals(saisiRappel);
        if (rappel) {
            AffichageSimple.afficherRappelOui();
        } else {
            AffichageSimple.afficherRappelNon();
        }
        return rappel;
    }

    /**
     * @param agenda
     * @throws IOException
     */
    static private void save(Agenda agenda, String nomFichier) throws IOException {
        FileOutputStream fos;
        ObjectOutputStream oos;
        fos = new FileOutputStream(nomFichier);
        oos = new ObjectOutputStream(fos);
        oos.writeObject(agenda);
        oos.flush();
        oos.close();
    }

    /**
     * @param nomFichierAgenda
     * @return
     * @throws IOException
     */
    static private Agenda load(String nomFichierAgenda) throws IOException {
        FileInputStream fis;
        ObjectInputStream ois;
        fis = new FileInputStream(nomFichierAgenda);
        ois = new ObjectInputStream(fis);
        Agenda agenda = null;
        try {
            agenda = (Agenda) ois.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjetAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        ois.close();
        return agenda;
    }

}
