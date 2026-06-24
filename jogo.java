import java.util.*;

public class jogo {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> cmdsMAPA = new ArrayList<>();
    static ArrayList<String> inventario = new ArrayList<>();

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
    static String pirralhu;
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
            pirralhu = "pirralho";

        } else {

            u = "a";
            elu = "ela";
            delu = "dela";
            aquelu = "aquela";
            U = "A";
            Elu = "Ela";
            Delu = "Dela";
            Aquelu = "Aquela";
            pirralhu = "pirralha";

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

            mostrarCMDS();
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

        } while (escolha < De || escolha > Até);
        
    }
    
    public static void limparTela(int ui) {
        for (int i = 0; i < ui; i++) {
            System.out.println(".");
            wait(30);
        }
        System.out.println();
    }








    //lugares
    
    public static void bar() {
        System.out.println("-----BAR-----");
        System.out.println("Carlos (No banco)");
        System.out.println("Roberta (Atentende)");
    
        cmdsMAPA.add("Conversar");
        cmdsMAPA.add("Sair...");

        verificarNumeroESCOLHA(1, 2);

        cmdsMAPA.clear();

        limparTela(10);

        switch (escolha) {
    
            case 1 -> {

                cmdsMAPA.add("Conversar com carlos");
                cmdsMAPA.add("Conversar com Roberta");

                verificarNumeroESCOLHA(1, 2);

                cmdsMAPA.clear();

                wait(500);
                switch (escolha) {
                    case 1 -> conversaComCarlos();
                    case 2 -> conversaComRoberta();
                }

            }
            case 2 -> System.out.println("Saindo..."); //sla();
    
        }   
    }










    //dialogos
    
    public static void conversaComCarlos() {

        limparTela(30);

        printTEXTO("Voce vai ate o banco");
        wait(1500);
        printTEXTO("(Sentando no banco)");
        wait(1500);
        
        

        if (isDoneA == true) {
            msg("Carlos", "EAE MEU MN, DBOA?");
            escolha = 0;
        } else {
            System.out.println(missaoAA);
            if (missaoAA == true) {

                System.err.println("vai pa missao.");

                cmdsMAPA.add("ir");
                cmdsMAPA.add("nope");


                verificarNumeroESCOLHA(1, 2);

                cmdsMAPA.clear();

            }
        }
        



        switch (escolha) {
            case 1 -> {
                printTEXTO("Missao concluida pra fins de teste(n existe)");
                wait(2000);

                isDoneA = true;
                limparTela(30);
                mapa(false, true, false);

            }
            case 2 -> {

                printTEXTO("tudo bem, n lhe obrigarei");
                wait(1500);
                limparTela(30);
                bar();
            }
            case 0 -> {
                printTEXTO("é o voltas...");
                wait(1500);
                limparTela(30);
                bar();
            }
        }
    }
    
    public static void conversaComRoberta() {

        limparTela(30);

        printTEXTO("(Andando até roberta)");
        wait(1500);
        msg(nome, "Ola, me ve uma breja ae fia, pls");
        wait(1500);
        msg("Roberta", "Qual?");
        wait(300);

        cmdsMAPA.add("Skoll");
        cmdsMAPA.add("Brama");
        cmdsMAPA.add("Itaipava");

        verificarNumeroESCOLHA(1, 3);

        cmdsMAPA.clear();
        
        if (escolha == 1) {
            printTEXTO("Skoll adicionada ao inventario");
            inventario.add("Skoll");
        } else if (escolha == 2) {
            printTEXTO("Brama adicionada ao inventario");
            inventario.add("Brama");
        } else if (escolha == 3) {
            printTEXTO("Itaipava adicionada ao inventario");
            inventario.add("Itaipava");
        }

        wait(1500);
        if (isDoneB == true) {

            msg("Roberta", "não aguento mais te ver, " + pirralhu);
            wait(2000);

            limparTela(30);
            bar();

        } else {
            if (missaoBB == true) {
                msg("Roberta", "Vai pros confins bla bla bla");

                cmdsMAPA.add("ir");
                cmdsMAPA.add("não ir");

                verificarNumeroESCOLHA(1, 2);

                cmdsMAPA.clear();

                switch (escolha) {

                    case 1 -> {
                        printTEXTO("Missao ainda n existe mas vamos supor que vc ja finalizou");
                        wait(1000);
                        isDoneB = true;
                        limparTela(30);
                        mapa(false, false, true);
                    }
                    case 2 -> {
                        msg("Roberta", "Tudo bem, n é para todos");
                        wait(1500);
                        limparTela(30);
                        bar();
                    }

                }

            } else {
                printTEXTO("(A observa)");
                wait(1670);
                msg("Roberta", "Ta olhando oque? vai embora");
                wait(1500);
                limparTela(30);
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
        
        pegarNOMEeGENERO();
        mudarPronomes();

        mapa(true, false, false);

    }


}
