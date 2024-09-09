package nl.han.bewd.lambdas.reis;

public class OpgevoerdeFatbikeVervoerStrategy implements VervoerStrategy {
    @Override
    public int berekenReistijd(boolean isReisTijdensSpits) {return 5; }
}
