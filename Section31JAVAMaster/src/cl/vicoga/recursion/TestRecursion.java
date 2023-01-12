package cl.vicoga.recursion;

import cl.vicoga.recursion.model.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

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
        pc.addSon(power).addSon(motherboard);

        recursiveMethodJAVA8(pc,0).forEach(f->System.out.println("\t".repeat(f.getLevel())+f.getName()));





    }
    public static Stream<Component> recursiveMethodJAVA8(Component component, int level){

        component.setLevel(level);
        return Stream.concat(Stream.of(component),
                component.getSons().stream().flatMap(s->recursiveMethodJAVA8(s,level+1)));




    }

    public static void recursiveMethod(Component component, int level){


        System.out.println("\t".repeat(level)+component.getName());

        if(component.hasSons()){
            for (Component c: component.getSons()) {
                recursiveMethod(c,level++);
            }
        }


    }

}
