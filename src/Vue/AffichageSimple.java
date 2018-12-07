/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.*;
import java.util.Collections;

/**
 *
 * @author Ludo
 */
public class AffichageSimple {

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
