import java.util.Scanner;

public class algebraBooleana {
    public static boolean and(String expressao, int i){
        if(expressao.charAt(i) == 'a'){
            if (expressao.charAt(i + 1) == 'n'){
                if(expressao.charAt(i + 2) == 'd'){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean not(String expressao, int i){
        if (expressao.charAt(i) == 'n') {
            if(expressao.charAt(i + 1) == 'o'){
                if(expressao.charAt(i + 2) == 't'){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean or(String expressao, int i){
        if(expressao.charAt(i) == 'o') {
            if(expressao.charAt(i + 1) == 'r'){
                return true;
            }
        }

        return false;
    }

    public static boolean valorBooleano(int valor){
        if(valor == 0) {

            return false;
        } else {

            return true;
        }
    }

    public static boolean calculaExpressao(String expressao, int quantidade){
        int[] array = new int[quantidade];
        int j = 2;
        boolean bool = false;

        for (int i = 0; i < quantidade; i++){
            array[i] = ((int) expressao.charAt(j)) - 48;
            j = j + 2;
        }
        
        //caso exista 2 variaveis
        if(quantidade == 2){
            if(and(expressao, j)){
                if(not(expressao, j + 4)){
                    if(not(expressao, j + 13)){
                        bool = (!valorBooleano(array[0])) && (!valorBooleano(array[1]));

                        return bool;
                    }
                }
            }
            
            if(not(expressao, j)){
                if(and(expressao, j + 4)){
                    bool = !(valorBooleano(array[0]) && valorBooleano(array[1]));

                    return bool;
                }
            }
        }

        //caso exista 3 variaveis
        if(quantidade == 3){
            if(and(expressao, j)){
                if(or(expressao, j + 4)){
                    if(not(expressao, j + 16)){
                        if(and(expressao, j + 20)){
                            bool = ((valorBooleano(array[0]) || valorBooleano(array[1])) && (!(valorBooleano(array[1]) && valorBooleano(array[2]))));

                            return bool;
                        }
                    }

                    if(expressao.charAt(j + 7) == 'A'){
                        bool = (valorBooleano(array[0]) || valorBooleano(array[1]) || (! (valorBooleano(array[2])))) && (valorBooleano(array[1]) || valorBooleano(array[2])) && (!valorBooleano(array[0]) || valorBooleano(array[2]));

                        return bool;
                    }
                }

                if(expressao.charAt(j + 4) == 'A'){
                    if(or(expressao, j + 8)) {
                        bool = (valorBooleano(array[0]) && (valorBooleano(array[1]) || valorBooleano(array[2])));

                        return bool;
                    }
                }
            }

            if(or(expressao, j)){
                if(and(expressao, j + 3)){
                    if(and(expressao, j + 16)){
                        bool = ((valorBooleano(array[0]) && valorBooleano(array[1])) || (valorBooleano(array[0]) && valorBooleano(array[2])));

                        return bool;
                    }

                    if(and(expressao, j + 15)){
                        bool = ((valorBooleano(array[0]) && valorBooleano(array[1])) || (valorBooleano(array[0]) && valorBooleano(array[2])));

                        return bool;
                    }

                    if(and(expressao, j + 20)){
                        if(or(expressao, j + 24)){
                            bool = (valorBooleano(array[0]) && valorBooleano(array[1]) && valorBooleano(array[2])) || ((valorBooleano(array[0]) || valorBooleano(array[1])) && valorBooleano(array[2]));

                            return bool;
                        }
                        if(expressao.charAt(j + 24) == 'A'){
                            if(not(expressao, j + 28)){
                                if(expressao.charAt(j + 37) == 'C'){
                                    bool = (valorBooleano(array[0]) && valorBooleano(array[1]) && valorBooleano(array[2])) || (valorBooleano(array[0]) && (! (valorBooleano(array[1]))) && valorBooleano(array[2])) || ((!(valorBooleano(array[0]))) && (!(valorBooleano(array[1]))) && valorBooleano(array[2])) || ((!(valorBooleano(array[0]))) && (!(valorBooleano(array[1]))) && (!(valorBooleano(array[2]))));

                                    return bool;
                                }
                            }
                        }
                        if(not(expressao, j + 37)){
                            bool = ((valorBooleano(array[0]) && valorBooleano(array[1]) && valorBooleano(array[2]))) || ((valorBooleano(array[0]) && (!(valorBooleano(array[1]))) && (!(!(valorBooleano(array[0])) && (!(valorBooleano(array[2])))))));

                            return bool;
                        }
                    }
                }

                if(expressao.charAt(j + 3) == 'A'){
                    if(and(expressao, j + 7)) {
                        bool = (valorBooleano(array[0]) || (valorBooleano(array[1]) && valorBooleano(array[2])));

                        return bool;
                    }
                }

                if(or(expressao, j + 3)){
                    if(and(expressao, j + 6)){
                        bool = (((! (valorBooleano(array[0]) && valorBooleano(array[1]))) && (!(valorBooleano(array[2])))) || ((!(valorBooleano(array[0]))) && valorBooleano(array[1]) && valorBooleano(array[2])) || (valorBooleano(array[0]) && valorBooleano(array[1]) && valorBooleano(array[2])) || (valorBooleano(array[0]) && (! (valorBooleano(array[1]))) && (!(valorBooleano(array[2]))))) || (valorBooleano(array[0]) && (!(valorBooleano(array[1]))) && valorBooleano(array[2]));
                        
                        return bool;
                    }
                    bool =  (valorBooleano(array[0]) || valorBooleano(array[1])) || valorBooleano(array[2]);
                    return bool;
                }

                if(not(expressao, j + 3)){
                    bool = !valorBooleano(array[0]) || valorBooleano(array[1]) || (valorBooleano(array[0]) && valorBooleano(array[1]) && (!valorBooleano(array[2])));

                    return bool;
                }
            }
        }
        
        return false;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); 
        int quantidade = 0;
        boolean resposta = false;

        while (true) {
            String entrada = scanner.nextLine();
            if (entrada.equals("0")) {
                break;
            }
            quantidade = ((int)entrada.charAt(0)) - 48;
            resposta = calculaExpressao(entrada, quantidade);
            if (resposta == true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        scanner.close();
    }
}