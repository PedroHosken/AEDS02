package Verde.TP02.Q07;

/**
 * Pesquisa Sequencial na Lista de Pokemons
 * @author Pedro Hosken - 816561
 * @version 1.0 - 10/10/2024
 */

// ----------- Dependências --------- //
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;

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
        return "[#" + id + " -> " + name + ": " + description + " - ['" + type1
                + (type2 != null ? "', '" + type2 + "']" : "']") + " - ['" + String.join("', '", abilities) + "']"
                + " - "
                + weight + "kg - " + height + "m - " + captureRate + "% - "
                + (isLegendary ? "true" : "false") + " - " + generation + " gen] - "
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
        String path = "/tmp/pokemon.csv";
        // "C:/Users/User11/Documents/AEDS02/Verde/TP02/Q01/pokemon.csv"; //
        // certifique-se de que este : /tmp/pokemon.csv

        // caminho esteja correto
        boolean found = false;

        try {
            // Abrir o arquivo CSV com a codificação UTF-8
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
            br.readLine(); // pular a primeira linha do arquivo (cabeçalho)

            // continuar lendo enquanto não encontrar o id
            while ((linha = br.readLine()) != null && !found) {
                // Dividir a linha com base nas vírgulas, mas respeitando campos entre aspas
                String[] dados = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if (!dados[0].isEmpty()) {
                    int idArquivo = Integer.parseInt(dados[0]); // inicializa variável com o id de cada linha

                    if (idArquivo == id) {
                        found = true;

                        // Capturar type1 e type2 corretamente
                        String type1 = dados[4].trim();
                        String type2 = dados[5].isEmpty() ? null : dados[5].trim(); // Verifica se o type2 é vazio

                        // Corrigir o campo de habilidades (remover colchetes e aspas duplas)
                        String habilidadesLimpa = dados[6].replace("[", "").replace("]", "").replace("\"", "")
                                .replace("'", "").trim();
                        List<String> abilities = Arrays.asList(habilidadesLimpa.split(",\\s*"));

                        // Inicializar novo Pokémon
                        double weight = !dados[7].isEmpty() ? Double.parseDouble(dados[7]) : 0.0;
                        double height = !dados[8].isEmpty() ? Double.parseDouble(dados[8]) : 0.0;
                        int captureRate = !dados[9].isEmpty() ? Integer.parseInt(dados[9]) : 0;
                        boolean isLegendary = dados[10].equals("1");

                        // Converter a data
                        Date captureDate = null;
                        if (!dados[11].isEmpty()) {
                            captureDate = new SimpleDateFormat("dd/MM/yyyy").parse(dados[11]);
                        }

                        novo = new Pokemon(idArquivo, Integer.parseInt(dados[1]), dados[2], dados[3], type1, type2,
                                abilities,
                                weight, height, captureRate, isLegendary, captureDate);
                    }
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

        return novo;
    }

    /**
     * Metódo de Pesquisa Sequencial
     * Objetivo: Usar algoritmo de PS, verificando se há pokemon com aqule nome no
     * Array
     * 
     * @param name  String
     * @param lista Array List
     * @return boolean is
     * 
     * @var boolean is - teste se há ou não
     * @var Pokemon p - usamos para captar o da lista e ser verificado
     * @var String n2 - nome do pokemon da lista
     */
    static boolean pesqS(String name, ArrayList<Pokemon> lista) {
        // definir dados
        boolean is = false;
        String n2 = "";
        // percorrer lista
        for (Pokemon p : lista) {
            n2 = p.getName();
            // fazer teste se nome existe esse nome na lista
            if (n2.equals(name)) {
                is = true;
            }
        }
        // return
        return is;
    }

    /**
     * Metódo Swap
     * Trocar elementos dentro da Lista
     * 
     * 
     * @param Array<Pokemons> lista
     * @param int             menor
     * @param int             j
     * 
     * @var Pokemon temp - uso de pokemon temporario
     */

    static void swap(ArrayList<Pokemon> lista, int menor, int i) {
        // Armazena o elemento em i temporariamente
        Pokemon temp = lista.get(menor);
        // Troca o elemento i pelo elemento j
        lista.set(menor, lista.get(i));
        // Coloca o valor temporário na posição j
        lista.set(i, temp);
    }

    /**
     * Metódo de Ordenação por Seleção
     * Chave: Pokemon.name
     * Objetivo: ordenar os pokemons pelo seus nomes de maneira crescente
     * 
     * @param Array<Pokemons> lista de pokemons
     * 
     * @var int n - tamanho da lista
     * @var Pokemon p1 - vem da posição menor
     * @var Pokemon p2 - vem depois da menor
     * 
     */

    static void ordSelecao(ArrayList<Pokemon> lista) {
        // definir dados
        int n = lista.size();

        // ordenação
        for (int i = 0; i < (n - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < n; j++) {
                Pokemon p1 = lista.get(menor);
                Pokemon p2 = lista.get(j);
                if (p1.getName().compareTo(p2.getName()) > 0) {
                    menor = j;
                }
            }
            swap(lista, menor, i);
        }
    }

    /**
     * Metódo de Ordenação por Inserção
     * Chave: Pokemon.captureDate, caso empate : pokemon.name
     * Objetivo: ordenar os pokemons por suas datas de Captura de maneira crescente
     * 
     * @param Array<Pokemons> lista de pokemons
     * 
     * @var int n - tamanho da lista
     * @var Pokemon tmp - vem da posição i
     * @var Pokemon tmp2 - vem da posição j
     * 
     */

    static void ordInsercao(ArrayList<Pokemon> lista) {
        // definir dados
        int n = lista.size();

        // ordenação
        for (int i = 1; i < n; i++) {
            Pokemon tmp = lista.get(i);
            int j = i - 1;
            // Loop para mover os elementos maiores que `tmp` para frente
            while (j >= 0 && (lista.get(j).getCaptureDate().compareTo(tmp.getCaptureDate()) > 0 ||
                    (lista.get(j).getCaptureDate().compareTo(tmp.getCaptureDate()) == 0 &&
                            lista.get(j).getName().compareTo(tmp.getName()) > 0))) { // caso empate
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, tmp);

        }
    }

    /**
     * Metódo Main
     * Ler ids da entrada, criar pokemon a partir do csv, formar lista de pokemons e
     * fazer pesquisa sequencial
     * 
     * @version 1 - teste de ler Id e formar array de pokemons dinamicamente - CERTO
     * @version 2 - chamar metódo de ordenação por inserção e imprimir - CERTO
     * 
     * @var String linha - para leitura de entradas
     * @var int proucurado - id que vamos formar o pokemon
     * @var Pokemon leitor - pokemon auxiliar
     * @var Pokemon resultado - pokemon resultaod
     * @var ArrayList<Pokemon> lista - lista de Pokemons
     * @var int i - controle do array
     * @var Scanner sc - para leitura
     */

    public static void main(String args[]) {
        // definir dados
        String linha = "";
        int proucurado = 0;
        int i = 0;
        Pokemon leitor = new Pokemon();
        Pokemon resultado = null;
        ArrayList<Pokemon> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        // ler ids, while diferente de FIM
        linha = sc.nextLine();
        while (!linha.equals("FIM")) {
            proucurado = Integer.parseInt(linha);
            resultado = leitor.ler(proucurado);
            // verifica se deu certo
            if (resultado != null) {
                lista.add(i, resultado);// adiciona a lista
                i++;// anda com a variável de controle
            } else {
                System.out.println("Pokémon com ID deu ruim " + proucurado);
            }
            linha = sc.nextLine();
        }

        /*
         * // printar lista desordenada
         * for (Pokemon p : lista) {
         * System.out.println(p.imprimir());
         * }
         */

        // chamar metódo de ordenação por seleção
        ordInsercao(lista);
        // printar lista ordenada
        for (Pokemon p : lista) {
            System.out.println(p.imprimir());
        }

        // fechar scanner
        sc.close();

    }

    /**
     * Testes realizados
     * Colocar por versões e o que está sendo testado
     */

}