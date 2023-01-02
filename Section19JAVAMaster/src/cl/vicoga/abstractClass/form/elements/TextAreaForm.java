package cl.vicoga.abstractClass.form.elements;

public class TextAreaForm extends FormElement{

    private int rows;
    private int columns;

    public TextAreaForm(String name) {
        super(name);
    }

    public TextAreaForm(String name, int rows, int columns) {
        super(name);
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    @Override
    public String drawHtml() {
        return "<textarea name=\""+this.name
                +"\" cols='"+getColumns()
                +"' rows='"+getRows()+"'>"+
                this.value+"</textarea>";
    }
}
