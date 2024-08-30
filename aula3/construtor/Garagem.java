public class Garagem {
    public static void main (String[]args) {
        //Pneu pneu = new Pneu(15);
        
        //Moto m1 = new Moto(16);

        //Agregação

        Carro c1 = new Carro();

        Pneu pirelli = new Pneu(14);
        c1.p1 = pirelli;

        Motor novoMotor = new Motor();
        novoMotor.marca = "VW";

        Pneu pneu = c1.p2;

        c1 = null;
    }
}
