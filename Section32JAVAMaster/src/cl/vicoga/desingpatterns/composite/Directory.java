package cl.vicoga.desingpatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Component{

    private List<Component> children;

    public Directory(String name) {
        super(name);
        this.children= new ArrayList<>();
    }

    public Directory addComponent(Component c){
        this.children.add(c);
        return this;
    }

    public void removeComponent(Component c){
        this.children.remove(c);
    }

    @Override
    public String show(int level) {
        StringBuilder sb = new StringBuilder("\t".repeat(level)+name);
        sb.append("/")
                .append("\n");

        for (Component son:this.children) {
            sb.append(son.show(level+1));
            if(son instanceof File){
                 sb.append("\n");
            }


        }

        return sb.toString();
    }
}
