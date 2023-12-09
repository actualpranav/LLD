package InterfaceRunnable;

/**
 *
 */
abstract class Animal extends Organism{
    String Name;

    Animal(){
        super.family = "Animalia";
    }

    void breathe(){
        System.out.println("breathing");
    }
}
