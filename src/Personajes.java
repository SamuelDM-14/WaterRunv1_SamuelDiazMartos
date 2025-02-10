public abstract class Personajes {
    protected String color;

    public Personajes(String color){

        this.color=color;
    }

    public abstract void accion();

    public String getColor(){
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    
}
