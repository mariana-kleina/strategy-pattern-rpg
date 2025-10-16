package rpg.combate;

import java.util.Map;

public class Mago extends Personagem {
    public Mago(String nome) {
        super(nome, 70, 150, Map.of("Força", 5, "Destreza", 7, "Inteligência", 18));
    }

    @Override
    public void aplicarEfeitosInicioTurno() {
        super.aplicarEfeitosInicioTurno(); 
        if (this.estaVivo()) {
            int manaRecuperada = 10;
            this.setManaAtual(getManaAtual() + manaRecuperada);
            System.out.println(nome + " (Regeneração de Mana) recupera " + manaRecuperada + " de mana.");
        }
    }
    
    @Override
    public void receberDano(int dano) {
        super.receberDano(dano);
    }
}