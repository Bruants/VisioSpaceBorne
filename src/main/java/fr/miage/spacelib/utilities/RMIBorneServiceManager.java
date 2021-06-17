/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.spacelib.utilities;

import fr.miage.spacelib.vspaceshared.interfremote.ExpoGestionBorneRemote;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Service RMI client 
 * @version 1.0 
 */
public class RMIBorneServiceManager {
    private final static String GLASSFISH_ORB_HOST = "localhost";
    private final static String GLASSFISH_ORB_PORT = "3700";
    private final static String SERVICES_CLIENTLOURD_EJB_URI = "java:global/visiospace-ear/visiospace-ejb-1.0-SNAPSHOT/ExpoGestionBorne";

    private InitialContext namingContext;
    private ExpoGestionBorneRemote lourdRemoteSvc;

    public RMIBorneServiceManager() throws NamingException {
        this.initJndi();
        this.retrieveRemoteServicesClientLourd();
    }

    private void initJndi() throws NamingException {
        Properties jNDIProperties = new Properties();
        jNDIProperties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        jNDIProperties.setProperty("org.omg.CORBA.ORBInitialHost", GLASSFISH_ORB_HOST);
        jNDIProperties.setProperty("org.omg.CORBA.ORBInitialPort", GLASSFISH_ORB_PORT);
        this.namingContext = new InitialContext(jNDIProperties);
    }

    private void retrieveRemoteServicesClientLourd() throws NamingException {
        this.lourdRemoteSvc = (ExpoGestionBorneRemote) this.namingContext.lookup(SERVICES_CLIENTLOURD_EJB_URI);
    }

    public ExpoGestionBorneRemote getClientLourdRemoteSvc() {
        return lourdRemoteSvc;
    }
}
