import java.util.Scanner;

public class EstudoProva {
    public static String combinar(String a, String b){
        StringBuilder str = new StringBuilder();
        int tamanhoMin = Math.min(a.length(), b.length());
        for (int i = 0; i < tamanhoMin; i++) {
            str.append(a.charAt(i));
            str.append(b.charAt(i));
        }
        if (a.length() > tamanhoMin) {
            str.append(a.substring(tamanhoMin));
        }
        if (b.length() > tamanhoMin) {
            str.append(b.substring(tamanhoMin));
        }
        return str.toString();
    }

    public static String combinadorDoisEmDois(String a, String b){
        StringBuilder str = new StringBuilder();
        int min = Math.min(a.length(), b.length());
        for (int i = 0; i < min; i+=2) {
            str.append(a.charAt(i));
            str.append(a.charAt(i+1));
            str.append(b.charAt(i));
            str.append(b.charAt(i+1));
        }
        if (a.length() > min) {
            str.append(a.substring(min));
        }
        if (b.length() > min) {
            str.append(b.substring(min));
        }
        return str.toString();
    }

    public static String combinadorReverso(String a, String b){
        StringBuilder str = new StringBuilder();
        int tam = a.length() + b.length();
        int tamA = a.length()-1;
        int tamB = b.length()-1;
        for (int i = 0; i < tam; i++) {
            if (tamA >= 0) {
                str.append(a.charAt(tamA));
                tamA--;
            }
            if (tamB >= 0) {
                str.append(b.charAt(tamB));
                tamB--;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = new String();
        String b = new String();
        String entrada = sc.nextLine();
        a = entrada.split(" ")[0];
        b = entrada.split(" ")[1];
        System.out.println(combinadorDoisEmDois(a, b));

        sc.close();
    }
}
