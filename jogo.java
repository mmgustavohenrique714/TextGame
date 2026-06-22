import java.util.*;

public class jogo {

    static Scanner sc = new Scanner(System.in);

    static String nome = "";
    static String genero = "";

    // pronomes
    static String u;
    static String elu;
    static String delu;
    static String aquelu;
    static String U;
    static String Elu;
    static String Delu;
    static String Aquelu;
    // 

    static void linhas(int ui) {
        for (int i = 0; i < ui; i++) {
            System.out.print("-");
        }
    }
    static void linhasln(int ui) {
        for (int i = 0; i < ui; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static String PegarTexto(Scanner sc, String textoUI) {
        System.out.print(textoUI + ": ");
        
        String texto = sc.nextLine();
        return texto;

    }

    public static void pegarNOMEeGENERO() {

        nome = PegarTexto(sc, "Nome");
        
        linhasln(35);
        System.out.println("1 - Homem");
        System.out.println("2 - Mulher");
        linhasln(35);
        
        int generoINT = 0;

        
        do {
            
            System.out.print("Escolha seu gênero: ");
            while (!sc.hasNextInt()) {
    
                System.out.println("Precisa ser numero, tente novamente.");
                System.out.println("Escolha seu gênero: ");
                sc.next();
    
            }
    
            generoINT = sc.nextInt();
            sc.nextLine();
    
            if (generoINT < 1 || generoINT > 2) {
                System.out.println("Precisa ser entre 1 (Homem) e 2 (Mulher)");
            }

        } while (generoINT < 1 || generoINT > 2);

        if (generoINT == 1) {
            genero = "Ele/Dele";
        } else {
            genero = "Ela/Dela";
        }

    }
    
    public static void mudarPronomes() {

        if (genero.equals("Ele/Dele")) {

            u = "o";
            elu = "ele";
            delu = "dele";
            aquelu = "aquele";
            U = "O";
            Elu = "Ele";
            Delu = "Dele";
            Aquelu = "Aquele";

        } else {

            u = "a";
            elu = "ela";
            delu = "dela";
            aquelu = "aquela";
            U = "A";
            Elu = "Ela";
            Delu = "Dela";
            Aquelu = "Aquela";

        }

    }
    
    public static void main(String[] args) {

        linhas(50);
        System.out.print("RPG");
        linhasln(50);
        
        pegarNOMEeGENERO();
        mudarPronomes();

        // area de teste (sera removida)
        System.out.println(nome);
        System.out.println(genero);
        System.out.println(U + " " + nome);
        System.out.println("Isso é " + delu);
        //

    }


}
