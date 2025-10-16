package rpg.combate;

public class Sangramento extends StatusEffect {
    private final int danoPorTurno = 5;

    public Sangramento() {
        super("Sangramento", 3);
    }

    @Override
    public void aplicar(Personagem alvo) {
        System.out.println(alvo.getNome() + " está sangrando e perde " + danoPorTurno + " de vida.");
        alvo.receberDanoDireto(danoPorTurno); 
    }
}