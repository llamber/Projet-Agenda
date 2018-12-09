/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.agenda;

import Modele.Agenda;
import Modele.RendezVous;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ludo
 */
public class GestionAgendaIHM {

    public static void creerAgenda(String nom) {
        Agenda ag = new Agenda(nom);
        try {
            save(ag, nom);
        } catch (IOException ex) {
            Logger.getLogger(GestionAgendaIHM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void ouvrirAgenda(String nom) {
        try {
            Agenda ag = load(nom);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GestionAgendaIHM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
  

    public static void créerRdv(String saisiDate, String saisiHeureDebut, String saisiHeureFin, String saisiLibelle, String saisiRappel) {
        LocalDate date = LocalDate.parse(saisiDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalTime heureDebut = LocalTime.parse(saisiHeureDebut, DateTimeFormatter.ofPattern("kk:mm")); //<-- kk pour une date de 0 Ã  24h
        LocalTime heureFin = LocalTime.parse(saisiHeureFin, DateTimeFormatter.ofPattern("kk:mm"));
        boolean rappel;
        do {
            saisiRappel = "N";
        } while (!("O".equals(saisiRappel) || "N".equals(saisiRappel)));
        rappel = "O".equals(saisiRappel);
        RendezVous rdv = new RendezVous(date, heureDebut, heureFin, rappel, saisiLibelle);
    }
    
    public static void modifierRdv(String saisiDate, String saisiHeureDebut, String saisiHeureFin, String saisiLibelle, String saisiRappel){
        
    }
    

    public static void save(Agenda agenda, String nomFichier) throws IOException {
        FileOutputStream fos;
        ObjectOutputStream oos;
        fos = new FileOutputStream(nomFichier);
        oos = new ObjectOutputStream(fos);
        oos.writeObject(agenda);
        oos.flush();
        oos.close();
    }

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
