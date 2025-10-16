package rpg.combate;

public class Batalha {
    private Personagem p1;
    private Personagem p2;
    private int turno;

    public Batalha(Personagem p1, Personagem p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.turno = 1;
    }

    public void iniciar() {
        System.out.println("====== A BATALHA COMEÇOU! ======");
        System.out.println(p1.getNome() + " VS " + p2.getNome() + "\n");

        while (p1.estaVivo() && p2.estaVivo()) {
            System.out.println("\n======== TURNO " + turno + " ========");

            Personagem atacante = (turno % 2 != 0) ? p1 : p2;
            Personagem defensor = (turno % 2 != 0) ? p2 : p1;

            System.out.println(p1);
            System.out.println(p2);

            atacante.aplicarEfeitosInicioTurno();
            if (!atacante.estaVivo()) break;

            if (atacante.isEstaAtordoado()) {
                System.out.println(atacante.getNome() + " está atordoado e não pode agir!");
            } else {
                
                boolean manaInsuficiente = atacante.getManaAtual() < atacante.armaEquipada.getCustoMana();
                boolean temArmaParaTrocar = !atacante.getInventarioArmas().isEmpty();

                if (manaInsuficiente && temArmaParaTrocar) {
                    System.out.println(atacante.getNome() + " não tem mana para o ataque atual e tenta trocar de arma!");
                    
                    boolean trocouComSucesso = false;
                    for (int i = 0; i < atacante.getInventarioArmas().size(); i++) {
                        Arma armaDoInventario = atacante.getInventarioArmas().get(i);
                        if (atacante.getManaAtual() >= armaDoInventario.getCustoMana()) {
                            atacante.trocarArma(i + 1); 
                            trocouComSucesso = true;
                            break; 
                        }
                    }
                    if (!trocouComSucesso) {
                        System.out.println(atacante.getNome() + " não encontrou uma arma que pudesse usar e perdeu o turno tentando!");
                    }

                } else {
                    atacante.atacar(defensor);
                }
            }
            
            atacante.incrementarTurnoEmCombate();
            turno++;
        }
        declararVencedor();
    }

    private void declararVencedor() {
        System.out.println("\n====== FIM DA BATALHA! ======");
        if (p1.estaVivo()) {
            System.out.println("O vencedor é " + p1.getNome() + "!");
        } else if (p2.estaVivo()) {
            System.out.println("O vencedor é " + p2.getNome() + "!");
        } else {
            System.out.println("A batalha terminou em empate!");
        }
    }
}