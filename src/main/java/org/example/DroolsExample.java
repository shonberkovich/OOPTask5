package org.example;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsExample {


public static void main(String[] args) {
    KieServices ks = KieServices.Factory.get();
    KieContainer kc = ks.getKieClasspathContainer();

    KieSession kSession = kc.newKieSession("ksession-rules");
    if (kSession == null) {
        System.err.println(" kSession is null!");
        return;
    }

    Person shai = new Person("shai", 25);
    Person shon = new Person("shon", 5);
    Person yura = new Person("yura", 2);
    Person yakov = new Person("yakov", 72);

    kSession.insert(shai);
    kSession.insert(shon);
    kSession.insert(yura);
    kSession.insert(yakov);

    System.out.println(" Starting Drools rule engine...");
    kSession.fireAllRules();
    kSession.dispose();

    printPersonStatus(shai);
    printPersonStatus(shon);
    printPersonStatus(yura);
    printPersonStatus(yakov);
}

    private static void printPersonStatus(Person p) {
        System.out.println("------------");
        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
        System.out.println("Is adult? " + p.isAdult());
    }
}
