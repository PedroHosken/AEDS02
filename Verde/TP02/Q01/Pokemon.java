package Verde.TP02.Q01;

import java.text.SimpleDateFormat;

/**
 * Classe Pokemon
 * @author Pedro Hosken - 816561
 * @version 1.0 - 24/09/2024
 */

// ----------- Dependências --------- //
import java.util.*;
import java.io.*;

public class Pokemon {
    /**
     * Atributos privados da Classe
     * 
     * Sua classe tera os atributos privado id (int),
     * generation (int), name (String), description (String), types (Lista)1
     * , abilities (Lista),
     * weight (double), height (double), captureRate (int), isLegendary (boolean),
     * captureDate
     * (Date)
     */

    private int id;
    private int generation;
    private int captureRate;
    private String name;
    private String description;
    private String type1;
    private String type2;
    private List<String> abilities;
    private double weight;
    private double height;
    private boolean isLegendary;
    private Date captureDate;

    /**
     * Construtores da Classe
     * Sua classe tambem tera pelo menos dois construtores
     * Construtor sem e com parametros
     * 
     * @param int          id
     * @param int          generation
     * @param String       name
     * @param Srting       description
     * @param String       type1
     * @param String       type2
     * @param List<String> abilities
     * @param double       weight
     * @param double       height
     * @param int          captureRate
     * @param boolean      isLegendary
     * @param Date         captureDate
     * 
     */

    public Pokemon() {
        this.id = 0;
        this.generation = 0;
        this.name = "";
        this.description = "";
        this.type1 = "";
        this.type2 = "";
        this.abilities = new ArrayList<>();
        this.weight = 0.0;
        this.height = 0.0;
        this.captureRate = 0;
        this.isLegendary = false;
        this.captureDate = null;
    }

    public Pokemon(int id, int generation, String name, String description, String type1, String type2,
            List<String> abilities,
            double weight, double height, int captureRate, boolean isLegendary, Date captureDate) {

        this.id = id;
        this.generation = generation;
        this.name = name;
        this.description = description;
        this.type1 = type1;
        this.type2 = type2;
        this.abilities = abilities;
        this.weight = weight;
        this.height = height;
        this.captureRate = captureRate;
        this.isLegendary = isLegendary;
        this.captureDate = captureDate;
    }

    /**
     * Metódos Get e Set do id
     * Metódos para instanciar e buscar na classe
     */

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metódos Get e Set do generation
     * Metódos para instanciar e buscar na classe
     */

    public int getGeneration() {
        return this.generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    /**
     * Metódos Get e Set do Name
     * Metódos para instanciar e buscar na classe
     */

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metódos Get e Set do Description
     * Metódos para instanciar e buscar na classe
     */

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Metódos Get e Set do type1
     * Metódos para instanciar e buscar na classe
     */

    public String getType1() {
        return this.type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    /**
     * Metódos Get e Set do type2
     * Metódos para instanciar e buscar na classe
     */

    public String getType2() {
        return this.type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    /**
     * Metódos Set e Get de Abilities
     * Para instanciar e recuperar
     */
    public List<String> getAbilities() {
        return this.abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities != null ? abilities : new ArrayList<>();
    }

    /**
     * Metódos Get e Set do weight
     * Metódos para instanciar e buscar na classe
     */
    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Metódos Get e Set do height
     * Metódos para instanciar e buscar na classe
     */
    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Metódos Get e Set do captureRate
     * Metódos para instanciar e buscar na classe
     */
    public int getCaptureRate() {
        return this.captureRate;
    }

    public void setCaptureRate(int captureRate) {
        this.captureRate = captureRate;
    }

    /**
     * Metódos Get e Set do isLegendary
     * Metódos para instanciar e buscar na classe
     */
    public boolean isLegendary() {
        return this.isLegendary;
    }

    public void setLegendary(boolean isLegendary) {
        this.isLegendary = isLegendary;
    }

    /**
     * Metódos Get e Set do CaptureDate
     * Metódos para instanciar e buscar na classe
     */
    public Date getCaptureDate() {
        return this.captureDate;
    }

    public void setCaptureDate(Date captureDate) {
        this.captureDate = captureDate;
    }

    /**
     * Metódo de Clone
     * Criar novo objeto com os mesmos atributos, receber atributos
     * 
     * @var Pokemon clone
     * @return clone
     * 
     */

    public Pokemon clone() {
        // definir dados
        Pokemon clone = new Pokemon();
        // receber dados do outro pokemon
        clone.setId(this.id);
        clone.setGeneration(this.generation);
        clone.setName(this.name);
        clone.setDescription(this.description);
        clone.setType1(this.type1);
        clone.setType2(this.type2);
        clone.setAbilities(new ArrayList<>(this.abilities));
        clone.setWeight(this.weight);
        clone.setHeight(this.height);
        clone.setCaptureRate(this.captureRate);
        clone.setLegendary(this.isLegendary);
        clone.setCaptureDate(this.captureDate);
        // return
        return clone;

    }

    /**
     * Metódo de Imprimir
     * O metodo imprimir mostra os atributos do registro (ver cada linha da saída
     * padrão)
     * [#181 -> Ampharos: Light Pokémon - ['electric'] - ['Static', 'Plus'] - 61.5kg
     * - 1.4m - 45% - false - 2 gen] - 25/05/1999
     * 
     * @return String
     */

    public String imprimir() {
        return "[#" + id + " -> " + name + ":" + description + " - ['" + type1
                + (type2 != null ? "', '" + type2 : "']") + " - ['" + String.join("', '", abilities) + "']" + " - "
                + weight + "kg - " + height + "m - " + captureRate + "% - "
                + (isLegendary ? "false" : "true") + " - " + generation + " gen] - "
                + new SimpleDateFormat("dd/MM/yyyy").format(captureDate);

    }

    /**
     * Metódo de Leitura
     * Objetivo: a partir do id, ler arquivo csv em busca desse id, criar um novo
     * objeto pokemon e guardar os atributos daquele id nele e retornar
     * 
     * @param int id
     * @return Pokemon novo
     * 
     * @var String path
     * @var Pokemon novo
     * @var BufferedReader br
     * @var String linha
     * @var boolean found
     * @var String[] dados
     * @var int idarquivo
     */

    public Pokemon ler(int id) {
        // definir dados
        Pokemon novo = null;
        String linha = "";
        BufferedReader br = null;
        String path = "C:/Users/User11/Documents/AEDS02/Verde/TP02/Q01/pokemon.csv";
        boolean found = false;
        // teste para se conseguiu abrir o arquivo
        try {
            br = new BufferedReader(new FileReader(path));
            br.readLine(); // pular primeira linha do arquivo
            // continuar lendo enquanto não encontrar o id
            while ((linha = br.readLine()) != null && !found) {
                String[] dados = linha.split(",");// separa os atributos pela ,
                int idArquivo = Integer.parseInt(dados[0]);// inicializa váriavel com o id de cada linha
                if (idArquivo == id) {
                    found = true;
                    // Remover os colchetes e as aspas simples, depois dividir por vírgula
                    String habilidadesLimpa = dados[6].replace("[", "").replace("]", "").replace("'", "").trim();
                    List<String> abilities = Arrays.asList(habilidadesLimpa.split(","));
                    // inicializar novo pokemon
                    novo = new Pokemon(idArquivo,
                            Integer.parseInt(dados[1]), // generation
                            dados[2], // name
                            dados[3], // description
                            dados[4], // type1
                            dados[5].isEmpty() ? null : dados[5], // type2
                            abilities,
                            Double.parseDouble(dados[7]), // weight_kg
                            Double.parseDouble(dados[8]), // height_m
                            Integer.parseInt(dados[9]), // capture_rate
                            Boolean.parseBoolean(dados[10]), // is_legendary
                            new SimpleDateFormat("dd/MM/yyyy").parse(dados[11]) // capture_date
                    );
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        // return
        return novo;
    }

    /**
     * Metódo Main
     * Ler arquivo do csv os ids, gerar lista de Pokemons e printar na tela a lista
     * 
     * @version 1 - teste de metódo printar e dos construtores CERTO
     * @version 2 - teste do metódo de leitura e printar pokemon lido
     * 
     * 
     */

    public static void main(String args[]) {
        // Instanciar a classe Pokemon e ler o Pokémon com ID específico
        Pokemon leitor = new Pokemon();
        Pokemon resultado = leitor.ler(115); // Teste com o ID 115 (ou qualquer outro)

        // Verificar se encontrou o Pokémon e imprimir as informações
        if (resultado != null) {
            System.out.println(resultado.imprimir());
        } else {
            System.out.println("Pokémon com ID 115 não encontrado.");
        }

    }

    /**
     * Testes realizados
     * Colocar por versões e o que está sendo testado
     */

    /*
     * VERSÃO 1 - CONSTRUTORES E PRINTAR
     * // Criar lista de habilidades
     * List<String> abilities = new ArrayList<>(Arrays.asList("Static", "Plus"));
     * 
     * // Definir data de captura
     * Date captureDate = new Date(); // Usa a data atual, você pode definir outra
     * data se preferir.
     * 
     * // Criar instância do Pokemon com o construtor parametrizado
     * Pokemon ampharos = new Pokemon(
     * 181, // id
     * 2, // generation
     * "Ampharos", // name
     * "Light Pokémon", // description
     * "electric", // type1
     * null, // type2 (null)
     * abilities, // abilities
     * 61.5, // weight
     * 1.4, // height
     * 45, // captureRate
     * false, // isLegendary
     * captureDate // captureDate
     * );
     * 
     * System.out.println(ampharos.imprimir());
     */

}
