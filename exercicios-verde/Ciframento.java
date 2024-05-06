class Ciframento {
    public static String Criptografa(String s) {
        String str = "";
        int auxiliar;

        for(int i = 0; i < s.length(); i++) {
            auxiliar = (int)s.charAt(i) + 3;
            str += (char)auxiliar;
        }
        return str;
    }

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        String frase = new String();

        frase = MyIO.readLine();
        
        MyIO.println(Criptografa(frase));
    }
}
