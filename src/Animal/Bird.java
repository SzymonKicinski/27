package Animal;

public abstract class Bird extends Animal implements ICanFly {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is peaking -> BIRD");
    }

    @Override
    public void breathe() {
        System.out.println(getName() + " is breathe and repeat -> BIRD");
    }


    @Override
    public void fly() {
        System.out.println(getName() + " is flying -> Brind");
    }
}
