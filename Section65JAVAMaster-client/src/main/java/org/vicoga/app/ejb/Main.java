package org.vicoga.app.ejb;

import org.vicoga.ejb.models.Product;
import org.vicoga.ejb.service.ServiceEjbRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

       ServiceEjbRemote service= null;
       /*  final Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

        env.put("jboss.naming.client.ejb.context", true);*/
        InitialContext remoteContext = null;
        try {
            remoteContext = new InitialContext();
            service=(ServiceEjbRemote) remoteContext
                    .lookup("ejb:/Section64JAVAMaster/ServiceEjb!" +
                            "org.vicoga.ejb.service.ServiceEjbRemote");
            String greet = service.greet("zod");
            String greet2 = service.greet("zed");

            System.out.println(greet);
            System.out.println(greet2);
            Product p= service.create(new Product("box"));
            System.out.println(p);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

    }
}
