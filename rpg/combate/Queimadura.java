package rpg.combate;

public class Queimadura extends StatusEffect {
    private final int danoPorTurno = 10;

    public Queimadura() {
        super("Queimadura", 2);
    }

    @Override
    public void aplicar(Personagem alvo) {
        System.out.println(alvo.getNome() + " está queimando e perde " + danoPorTurno + " de vida.");
        alvo.receberDanoDireto(danoPorTurno);
    }
}