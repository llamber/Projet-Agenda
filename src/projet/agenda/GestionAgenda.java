/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.agenda;

import Modele.Agenda;
import Modele.RendezVous;
import Vue.AffichageSimple;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author Pierre
 */
public class GestionAgenda implements Serializable {

    /**
     * @param choix
     * @throws IOException
     */
    public static void traiterChoixMenu1(int choix) throws IOException, ClassNotFoundException {
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
    static public void traiterChoixCreerAgenda() {
        AffichageSimple.afficherSaisiNom();
        Scanner sc = new Scanner(System.in);
        String nom = sc.nextLine();
        Agenda ag = new Agenda(nom);
        try {
            save(ag, nom);
        } catch (IOException ex) {
            Logger.getLogger(ProjetAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @throws IOException
     */
    public static void traiterChoixOuvrirAgenda() throws IOException, ClassNotFoundException {
        AffichageSimple.afficherSaisiNom();
        Scanner sc = new Scanner(System.in);
        String nomAgenda = sc.nextLine();
        Agenda agendaOuvert = load(nomAgenda);
    }

    /**
     * @param agenda
     */
    public static void gererAgenda(Agenda agenda) {
        int choix;
        Scanner sc = new Scanner(System.in);
        do {
            AffichageSimple.afficherMenu2();
            choix = sc.nextInt();
            traiterChoixMenu2(choix, agenda);
        } while (choix != 7);
        try {
            save(agenda, agenda.getNom());
        } catch (IOException ex) {
            Logger.getLogger(ProjetAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param choix
     * @param agenda
     */
    public static void traiterChoixMenu2(int choix, Agenda agenda) {
        AffichageSimple.affichageTraitementMenu2(choix);

        switch (choix) {

            case 1:
                traiterChoixAfficherRDV_Entre2Dates(agenda);
                break;
            case 2:
                AffichageSimple.afficherRdv(agenda);
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
    public static void traiterChoixAfficherRDV_Entre2Dates(Agenda agenda) {
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
    /**
     * @param agenda
     */
    public static void traiterChoixAjouterRDV(Agenda agenda) {
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
    public static void traiterChoixModifierRDV(Agenda agenda) {
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
    public static void traiterChoixSupprimerRDV(Agenda agenda) {
        AffichageSimple.afficherRdv(agenda);
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        agenda.getListeRdv().remove(index);

    }

    /**
     * @param agenda
     */
    public static void traiterChoixSupprimerTousRDV(Agenda agenda) {
        agenda.getListeRdv().forEach((_item) -> {
            agenda.getListeRdv().remove(1);

        });
    }

    /**
     * @return
     */
    static public LocalDate Date() {
        Scanner sc = new Scanner(System.in);
        AffichageSimple.afficherSaisiDate();
        String saisiDate = sc.nextLine();
        LocalDate date = LocalDate.parse(saisiDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return date;
    }

    /**
     * @return
     */
    public static LocalTime heureDebut() {
        Scanner sc = new Scanner(System.in);
        AffichageSimple.afficherSaisiHeureDebut();
        String saisiHeureDebut = sc.nextLine();
        LocalTime heureDebut = LocalTime.parse(saisiHeureDebut, DateTimeFormatter.ofPattern("kk:mm")); //<-- kk pour une date de 0 Ã  24h
        return heureDebut;
    }

    /**
     * @return
     */
    public static LocalTime heureFin() {
        LocalTime heureFin;
        Scanner sc = new Scanner(System.in);
        AffichageSimple.afficherSaisiHeureFin();
        String saisiHeureFin = sc.nextLine();
        heureFin = LocalTime.parse(saisiHeureFin, DateTimeFormatter.ofPattern("kk:mm"));
        while (heureFin.isBefore(heureDebut())) { //On verifie que l'heure de dÃ©but et plus petite que l'heure de fin
            AffichageSimple.afficherHeureFinSuperieur();
            saisiHeureFin = sc.nextLine();
            heureFin = LocalTime.parse(saisiHeureFin, DateTimeFormatter.ofPattern("kk:mm"));
        }
        return heureFin;
    }

    /**
     * @return
     */
    public static String libelle() {
        Scanner sc = new Scanner(System.in);
        AffichageSimple.afficherSaisiLibelle();
        String libelle = "fzefez";//sc.nextLine();
        return libelle;
    }

    /**
     * @return
     */
    public static boolean rappel() {
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
    public static void save(Agenda agenda, String nomFichier) throws IOException {
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
    public static Agenda load(String nomAgenda) throws IOException, ClassNotFoundException {
        FileInputStream fis;
        ObjectInputStream ois;
        fis = new FileInputStream(nomAgenda);
        ois = new ObjectInputStream(fis);
        Agenda ag;
        ag = (Agenda) ois.readObject();
        ois.close();
        return ag;
    }

}
