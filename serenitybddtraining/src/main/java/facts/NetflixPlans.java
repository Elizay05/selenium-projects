package facts;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;

public class NetflixPlans implements Fact {

    @Override
    public void setup(Actor actor) {
        // Solo verifica que el contexto exista (sin lógica pesada)
        actor.recall("plans");
    }

    @Override
    public String toString() {
        return "Netflix plans are available for viewing series";
    }
}