package cl.vicoga.recursion;

import cl.vicoga.recursion.model.Component;

public class TestRecursion {

    public static void main(String[] args) {

        Component pc = new Component("cabinet");

        Component motherboard = new Component("motherboard xc");
        Component power = new Component("power");
        Component cpu = new Component("amd");
        Component cpuFan = new Component("cpuFan");
        Component cpuPaste = new Component("cpuPaste");

        cpu.addSon(cpuPaste).addSon(cpuFan);
        motherboard.addSon(cpu);
        pc.addSon(motherboard).addSon(power);






    }

}
