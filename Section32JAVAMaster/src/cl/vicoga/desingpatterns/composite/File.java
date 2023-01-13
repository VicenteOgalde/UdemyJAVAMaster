package cl.vicoga.desingpatterns.composite;

public class File extends Component{
    public File(String name) {
        super(name);
    }

    @Override
    public String show(int level) {
        return "\t".repeat(level)+getName();
    }
}
