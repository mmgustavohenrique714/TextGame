import java.util.*;

public class jogo {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> cmdsMAPA = new ArrayList<>();
    static ArrayList<String> inventario = new ArrayList<>();
    static String[] opcoesJOG = {"Status", "Inventario"};

    static String nome = "";
    static String genero = "";
    static int escolha = 67;
    static boolean ishaveOPJOGG;
    static String lugarAtual = "";

    static int opcTamanho;

    //missoes
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
        if (ishaveOPJOGG == true) {
            System.out.println("[" + (cmdsMAPA.size() + 1) + "] Opções do jogador");
            linhasln(50);
        }

    }
    
    public static void verificarNumeroESCOLHA() {
        if (ishaveOPJOGG == true) {
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
    
                if (escolha < 1 || escolha > opcTamanho+1) {
                    printTEXTO("Escolha precisa ser entre :");
                }
            } while (escolha < 1 || escolha > opcTamanho+1);

        } else {
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
    
                if (escolha < 1 || escolha > opcTamanho) {
                    printTEXTO("Escolha precisa ser entre :");
                }
    
            } while (escolha < 1 || escolha > opcTamanho);
        }
        
    }
    
    public static void limparTela(int ui) {
        for (int i = 0; i < ui; i++) {
            System.out.println(".");
            wait(30);
        }
        System.out.println();
    }

    public static int CATCHescolha(boolean ishaveOPJOG, String... opcoes) {
        ishaveOPJOGG = ishaveOPJOG;
        for (int i = 0; i < opcoes.length; i++ ) {
            cmdsMAPA.add(opcoes[i]);
        }

        opcTamanho = opcoes.length;
        verificarNumeroESCOLHA();

        cmdsMAPA.clear();

        return escolha;

    }
    public static void lugarAtual() {
        limparTela(20);
        switch (lugarAtual) {
            case "Bar" -> bar();
        }
    }
    static public void Status() {

    }
    static public void Inventario() {

    }
    static public void opcoesProJogador() {
        linhasln(30);
        for (int i = 0; i < opcoesJOG.length; i++) {
            System.out.println("[" + (i + 1) + "] " + opcoesJOG[i]);
        }
        linhasln(30);
        System.out.println("[" + (opcoesJOG.length + 1) + "] Sair");
        linhasln(30);

        do {
            while (!sc.hasNextInt()) {
                System.out.println("Precisa ser número");
                System.out.println("Tente novamente");
                System.out.print("Escolha: ");
                sc.next();
            }

            escolha = sc.nextInt();
            sc.nextLine();

            if (escolha < 1 || escolha > opcoesJOG.length + 1) {
                printTEXTO("Escolha precisa ser entre :");
            }

        } while (escolha < 1 || escolha > opcoesJOG.length + 1);

        switch (escolha) {

            case 1 -> Status();
            case 2 -> Inventario();
           
            default -> lugarAtual();
        }
    }





    //lugares
    
    public static void bar() {
        lugarAtual = "Bar";
        System.out.println("-----BAR-----");
        System.out.println("Carlos (No banco)");
        System.out.println("Roberta (Atentende)");
        CATCHescolha(true, "Conversar", "Sair");

        limparTela(10);

        switch (escolha) {
    
            case 1 -> {

                CATCHescolha(false, "Conversar com carlos", "Conversar com Roberta", "Sair");

                wait(500);
                switch (escolha) {
                    case 1 -> conversaComCarlos();
                    case 2 -> conversaComRoberta();
                    case 3 -> {
                        limparTela(10);
                        bar();
                    }
                }

            }
            case 2 -> System.out.println("Saindo..."); //sla();
            default -> opcoesProJogador();
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
            if (missaoAA == true) {

                msg("Carlos", "Oi, você é novo por aqui");
                wait(1100);
                msg("Carlos", "De onde você é?");

                CATCHescolha(false, "Curitiba (mentira)", "Londrina (verdade)");

                switch (escolha) {
                    case 1 -> DcarlosR1();
                    case 2 -> DcarlosR2();
                    case 0 -> {
                        printTEXTO("Conversa vem Conversa vai");
                        wait(1500);
                        limparTela(25);
                        bar();
                    }
                }

            }
        }
        


        
        }

    public static void DcarlosR1() {
        msg("Carlos", "Legal cara, eu nasci lá");
        wait(1200);
        msg("Carlos", "Você morava la quando voce tinha quantos anos?");

        CATCHescolha(false, "2 anos(Mentira)", "67 anos(Verdade)");


        switch (escolha) {
            case 1 -> DcarlosR3();
            case 2 -> DcarlosR4();
        }

    }
    public static void DcarlosR2() {
        msg("Carlos", "legal");
        wait(1200);
        printTEXTO("um pouco pensativo...");
        wait(300);
        msg("Carlos", "MAS que legal cara, eu amo Londrina, um youtuber que eu gosto mt mora la sabia?");
        wait(2200);

        CATCHescolha(false, "Qual?", "João Caetano? amo os videos dele");

        switch (escolha) {
            case 1 -> DcarlosR5();
            case 2 -> DcarlosR6();
        }
    }
    public static void DcarlosR3() {
        msg(nome, "moro la ah 2 anos...");
        wait(1000);
        printTEXTO("Carlos te observa atentamente");
        wait(3000);
        msg("Carlos", "N tema filho, isso só distancia as pessoas");
        wait(2000);
        bar();
    }
    public static void DcarlosR4() {
        msg("Carlos", "hm... esta confuso n esta?");
        wait(1500);
        msg("Carlos", "Quer encontrar paz?");
        wait(1500);
        
        CATCHescolha(false, "(fazer sim com a cabeça)", "Só preciso pensar");
        
        switch (escolha) {
            case 1 -> {
                msg("Carlos", "(da missao)");
                wait(1500);

                //missaodocarlos();     // n existe
                printTEXTO("missao concluida pra fins de teste");
                isDoneA = true;
                wait(1000);
                mapa(false, true, false);

            }
            case 2 -> {
                msg("Carlos", "Pense, me procure se necessario");
                wait(1500);
                bar();
            }
        }
    }
    public static void DcarlosR5() {
        msg(nome, "Qual?");
        wait(1200);
        msg("Carlos", "Joao Caetano, é um youtuber que eu via antes, mas agr tenho que fazer um trabalho aq. flw.");
        wait(3000);
        bar();
    }
    public static void DcarlosR6() {
        msg("Carlos", "MANO VOCE TAMBEM ASSISTE? AAAAAAA");
        wait(1500);
        limparTela(3);
        wait(2000);
        printTEXTO("Conversa desenvolve...");
        wait(2000);
        printTEXTO("Carlos te convida pra uma missao...");
        wait(2000);
        CATCHescolha(false, "Ir", "Não ir");

        switch (escolha) {
            case 1 -> {
                msg("Carlos", "Foi um prazer te conhecer, vá");
                wait(5000);

                //missaodocarlos();     // n existe
                printTEXTO("missao concluida pra fins de teste");
                isDoneA = true;
                wait(1000);
                mapa(false, true, false);

            }
            case 2 -> {
                msg("Carlos", "Tudo bem meu mn, n é pra todos");
                wait(1500);
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

        CATCHescolha(false, "Skoll", "Brama", "Itaipava");
        
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

                CATCHescolha(false, "ir", "nao ir");

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
    
    // n tem dialogos completos





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

        mapa(true, false, false);

    }


}
