package rpg.combate;

public class Atordoado extends StatusEffect {
    public Atordoado() {
        super("Atordoado", 1);
    }

    @Override
    public void aplicar(Personagem alvo) {
        System.out.println(alvo.getNome() + " está atordoado e vai perder o próximo turno!");
        alvo.setEstaAtordoado(true);
    }
}