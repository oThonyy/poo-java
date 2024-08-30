public class Moto {
    Pneu p1;
    Pneu p2;

    public Moto() {

    }

    public Moto(int aro) {
        criar(aro);
    }

    public void criar (int aro) {
        this.p1 = new Pneu(aro);
        this.p2 = new Pneu(aro);
    }
}
