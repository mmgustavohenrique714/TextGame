import java.util.*;

public class jogo {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> cmdsMAPA = new ArrayList<>();

    static String nome = "";
    static String genero = "";
    static int escolha = 67;

    static boolean missaoAA;
    static boolean isDoneA = false;

    static boolean missaoBB;
    static boolean isDoneB = false;

    static boolean missaoCC;
    static boolean isDoneC = false;


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











    // funçoes

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
    
    public static void wait(int ms) {
        try { 
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }
    
    public static void msg(String entidade, String mensagem) {
        String msgCompleta = entidade + ": " + mensagem;
        String[] msgCortada = msgCompleta.split("");
        
        for (int i = 0; i < msgCortada.length ; i++) {

            System.out.print(msgCortada[i]);
                wait(20);  
        }

        System.out.println();

    }
    public static void printTEXTO(String texto) {
        String[] msgCortada = texto.split("");
        
        for (int i = 0; i < msgCortada.length ; i++) {

            System.out.print(msgCortada[i]);
                wait(20);  
        }

        System.out.println();
    }
    
    public static void mostrarCMDS() {

        linhasln(50);
        for (int i = 0; i < cmdsMAPA.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + cmdsMAPA.get(i));
        }
        linhasln(50);

    }
    
    public static void verificarNumeroESCOLHA(int De, int Até) {

        do {

            System.out.print("Escolha: ");

            while (!sc.hasNextInt()) {
                System.out.println("Precisa ser número");
                System.out.println("Tente novamente");
                System.out.print("Escolha: ");
                sc.next();
            }

            escolha = sc.nextInt();
            sc.nextLine();

            if (escolha < De || escolha > Até) {
                printTEXTO("Escolha precisa ser entre :");
            }

        } while (escolha < 1 || escolha > 2);
        
    }
    









    //lugares
    
    public static void bar() {
        System.out.println("-----BAR-----");
        System.out.println("Carlos (No banco)");
        System.out.println("Roberta (Atentende)");
    
        cmdsMAPA.add("Conversar");
        cmdsMAPA.add("Sair...");

        mostrarCMDS();
        verificarNumeroESCOLHA(1, 2);

        cmdsMAPA.clear();

        switch (escolha) {
    
            case 1 -> {
                conversaComCarlos();
            }
    
        }   
    }










    //dialogos
    
    public static void conversaComCarlos() {

        printTEXTO("Voce vai ate o banco");
       // wait(2000);
        printTEXTO("(Sentando no banco)");
       // wait(2000);
        
        

        if (isDoneA == true) {
            msg("Carlos", "EAE MEU MN, DBOA?");
        } else {
            System.out.println(missaoAA);
            if (missaoAA == true) {

                System.err.println("vai pa missao.");

                cmdsMAPA.add("ir");
                cmdsMAPA.add("nope");

                mostrarCMDS();
                verificarNumeroESCOLHA(1, 2);

                cmdsMAPA.clear();

            } else {
                //pro carlos n precisa pois ele é a primeira missao
                printTEXTO("Aquelu");
            }
        }
        



        switch (escolha) {
            case 1 -> {
                printTEXTO("Missao concluida pra fins de teste(n existe)");
                wait(2000);
                //missao do carlos
                if (escolha == 1) {
                    isDoneA = true;
                    mapa(false, true, false);
                }
                // todo esse if faz parte do metodo DA MISSAO DO CARLOS
            }
            case 2 -> {
                printTEXTO("Missao ainda n existe ent voltando...");
                wait(1500);
                bar();
            }
        }
    }
    
    
    






    //mapa
    
    public static void mapa(boolean missaoA, boolean missaoB, boolean missaoC) {

        missaoAA = missaoA;
        missaoBB = missaoB;
        missaoCC = missaoC;

        System.out.println("Entrando no mapa...");
        wait(500);

        bar();
    }
    









    public static void main(String[] args) {

        linhas(50);
        System.out.print("RPG");
        linhasln(50);
        
        //pegarNOMEeGENERO();
        //mudarPronomes();

        //SUPOSTAmissaoinicial();
        mapa(true, false, false);

    }


}
