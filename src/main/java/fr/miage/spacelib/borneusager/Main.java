/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.spacelib.borneusager;

import fr.miage.spacelib.vspaceshared.interfremote.GestionBorneUsagerRemote;
import fr.miage.spacelib.vspaceshared.utilities.ReservationExport;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author AlexisVivier
 */
public class Main {
    public static void main(String[] args){
        try {
            // 1 : lookup object
            Context ctx = new InitialContext();
            GestionBorneUsagerRemote borne = (GestionBorneUsagerRemote) ctx.lookup("fr.miage.spacelib.vspaceshared.interfremote.GestionBorneUsagerRemote");
            
            // 2 : metier
//            ReservationExport reservation = borne.reserverVoyage(0, 0, dateDepart, dateArrivee, 0, 0);
            
        } catch (NamingException e){
            
        }
        
    }
}
