/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ludo
 */
public class Agenda implements Serializable {
    // Déclaration des variables ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        ArrayList<RendezVous>listeRdv;
        String nom;

    // Creation de l'objet agenda

    public Agenda(String nom){
        listeRdv = new ArrayList<>();
        this.nom = nom;
    }

    public ArrayList<RendezVous> getListeRdv() {
        return listeRdv;
    }

    public void setListeRdv(ArrayList<RendezVous> listeRdv) {
        this.listeRdv = listeRdv;
        
    }

}
  