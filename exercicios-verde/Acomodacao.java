// Crie uma classe Acomodacao com os atributos privados: roomId (int), hostId (int), roomType (String), country (String), city (String), neighbourhood (String), reviews (int), overallSatisfaction (double), accommodates (int), bedrooms (double), price (double), propertyType (String). Sua classe também terá, pelo menos, dois construtores, e os métodos gets, sets, clone, ler e imprimir. O método ler deve ser implementado considerando-se a leitura, a partir do teclado, dos dados de uma única acomodação; enquanto o método imprimir exibe o valor de atributos do objeto (observe o formato de cada linha da saída esperada) na tela.

// Seu programa deve ler um arquivo-texto chamado dados_airbnb.txt que, no VERDE, localiza-se na pasta /tmp. Você deve preencher um vetor de objetos da classe Acomodacao com os dados das diversas acomodações informadas nesse arquivo. A primeira linha desse arquivo deve ser descartada, pois apenas informa os diversos campos presentes em cada uma das linhas seguintes. Cada uma das linhas seguintes indica os dados de uma acomodação, separados por uma tabulação (‘\t’).

// Depois, seu programa deve processar a entrada padrão que apresenta várias linhas, cada uma contendo uma string indicando o id da acomodação cujos dados devem ser exibidos na saída padrão. A última linha da entrada contém a palavra FIM. Na saída padrão, para cada id lido da entrada padrão, escreva uma linha com os dados do registro correspondente.

// A saída padrão deve obedecer o seguinte formato: [roomId ## hostId ## roomType ## country ## city ## neighbourhood ## reviews ## overallSatisfaction ## accommodates ## bedrooms ## price ## propertyType]

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Acomodacao implements Cloneable{
    private int roomId;
    private int hostId;
    private String roomType;
    private String country;
    private String city;
    private String neighbourhood;
    private int reviews;
    private double overallSatisfaction;
    private int accommodates;
    private double bedrooms;
    private double price;
    private String propertyType;

    public Acomodacao(int roomId, int hostId, String roomType, String country, String city, String neighbourhood,
            int reviews, double overallSatisfaction, int accommodates, double bedrooms, double price,
            String propertyType) {
        this.roomId = roomId;
        this.hostId = hostId;
        this.roomType = roomType;
        this.country = country;
        this.city = city;
        this.neighbourhood = neighbourhood;
        this.reviews = reviews;
        this.overallSatisfaction = overallSatisfaction;
        this.accommodates = accommodates;
        this.bedrooms = bedrooms;
        this.price = price;
        this.propertyType = propertyType;
    }

    public Acomodacao() {
        this.roomId = 0;
        this.hostId = 0;
        this.roomType = "";
        this.country = "";
        this.city = "";
        this.neighbourhood = "";
        this.reviews = 0;
        this.overallSatisfaction = 0;
        this.accommodates = 0;
        this.bedrooms = 0;
        this.price = 0;
        this.propertyType = "";
    }

    public int getRoomId() {
        return this.roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getHostId() {
        return this.hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighbourhood() {
        return this.neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public int getReviews() {
        return this.reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public double getOverallSatisfaction() {
        return this.overallSatisfaction;
    }

    public void setOverallSatisfaction(double overallSatisfaction) {
        this.overallSatisfaction = overallSatisfaction;
    }

    public int getAccommodates() {
        return this.accommodates;
    }

    public void setAccommodates(int accommodates) {
        this.accommodates = accommodates;
    }

    public double getBedrooms() {
        return this.bedrooms;
    }

    public void setBedrooms(double bedrooms) {
        this.bedrooms = bedrooms;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPropertyType() {
        return this.propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void ler(List<Acomodacao> acomodacoes) {
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();
        while (!entrada.equals("FIM")) {
            Acomodacao a = pesquisar(acomodacoes, entrada);
            imprimir(a);
            entrada = scanner.nextLine();
        }
        scanner.close();
    }

    public static void imprimir(Acomodacao acomodacao) {
                System.out.println("[" + acomodacao.getRoomId() + " ## " + acomodacao.getHostId() + " ## " + acomodacao.getRoomType() + " ## " + acomodacao.getCountry() + " ## " + acomodacao.getCity() + " ## " + acomodacao.getNeighbourhood() + " ## " + acomodacao.getReviews() + " ## " + acomodacao.getOverallSatisfaction() + " ## " + acomodacao.getAccommodates() + " ## " + acomodacao.getBedrooms() + " ## " + acomodacao.getPrice() + " ## " + acomodacao.getPropertyType() + "]");
    }

    public static Acomodacao pesquisar(List<Acomodacao> acomodacoes, String entrada) {
        //BUSCA NORMAL 
        // for(int i = 0; i < acomodacoes.size(); i++){
        //     if(Integer.parseInt(entrada) == acomodacoes.get(i).getRoomId()){
        //         return acomodacoes.get(i);
        //     }
        // }
        // return new Acomodacao();


        //BUSCABINÁRIA
        int inicio = 0;
        int fim = acomodacoes.size()-1;
        while(inicio <= fim){
            int mid = (inicio + fim) / 2;
            int midId = acomodacoes.get(mid).getRoomId();
            int searchId = Integer.parseInt(entrada);
        
            if(midId == searchId){
                return acomodacoes.get(mid);
            }else if(midId < searchId){
                inicio = mid + 1;
            }else{
                fim = mid - 1;
            }
        }

        return new Acomodacao();
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("dados_airbnb.txt"));
            scanner.nextLine();
            List<Acomodacao> acomodacoes = new ArrayList<>();
            while (scanner.hasNextLine()) {
                Acomodacao a = new Acomodacao();
                String text = scanner.nextLine();
                String[] data = text.split("\t");
                a.setRoomId(Integer.parseInt(data[0]));
                a.setHostId(Integer.parseInt(data[1]));
                a.setRoomType(data[2]);
                a.setCountry(data[3]);
                a.setCity(data[4]);
                a.setNeighbourhood(data[5]);
                a.setReviews(Integer.parseInt(data[6]));
                a.setOverallSatisfaction(Double.parseDouble(data[7]));
                a.setAccommodates(Integer.parseInt(data[8]));
                a.setBedrooms(Double.parseDouble(data[9]));
                a.setPrice(Double.parseDouble(data[10]));
                a.setPropertyType(data[11]);
                
                acomodacoes.add(a); 
            }
            //ORDENAÇÃO DO ARRAY
            acomodacoes.sort(Comparator.comparing(Acomodacao::getRoomId));
            
            ler(acomodacoes);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
