import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class Form extends JFrame {
    Button btnAddPorco;
    TextField txtNomePorco;
    TextField txtIdadePorco;
    TextField txtPesoPorco;
    Label lblNomePorco;
    Label lblIdadePorco;
    Label lblPesoPorco;
    List lstporquinhos;

    Label gramasRacao;
    Label gramasFeno;
    Label gramasVerdura;

    Label lblnomeporcosel;
    Label lblidadeporcosel;
    Label lblpesoporcosel;
    Button remover;

    Form() {
        Container JANELA = getContentPane();
        JANELA.setLayout(null);

        Color cor = new Color(168, 121, 50);

        txtNomePorco = new TextField();
        txtIdadePorco = new TextField();
        txtPesoPorco = new TextField();
        btnAddPorco = new Button("Novo Porquinho da India adotado");
        lstporquinhos = new List();
        lblNomePorco = new Label("Nome?");
        lblIdadePorco = new Label("Idade? Em meses por favor");
        lblPesoPorco = new Label("Peso? Em gramas por gentileza");
        gramasRacao = new Label("Gramas de racao:");
        gramasFeno = new Label("Gramas de feno:");
        gramasVerdura = new Label("Gramas de Verdura:");
        lblnomeporcosel = new Label();
        lblidadeporcosel = new Label();
        lblpesoporcosel = new Label();
        remover = new Button("Remover");

        lblNomePorco.setBounds(20, 0, 200, 50);
        txtNomePorco.setBounds(20, 50, 100, 20);
        lblIdadePorco.setBounds(20, 100, 200, 50);
        txtIdadePorco.setBounds(20, 150, 100, 20);
        lblPesoPorco.setBounds(20, 200, 200, 50);
        txtPesoPorco.setBounds(20, 250, 100, 20);
        btnAddPorco.setBounds(20, 300, 200, 50);
        lstporquinhos.setBounds(240, 0, 240, 490);
        gramasRacao.setBounds(500, 0, 200, 50);
        gramasFeno.setBounds(500, 50, 200, 50);
        gramasVerdura.setBounds(500, 100, 200, 50);
        lblnomeporcosel.setBounds(500, 300, 200, 15);
        lblidadeporcosel.setBounds(500, 325, 230, 15);
        lblpesoporcosel.setBounds(500, 350, 200, 15);
        remover.setBounds(315, 500, 70, 40);

        JANELA.add(lblNomePorco);
        JANELA.add(txtNomePorco);
        JANELA.add(lblIdadePorco);
        JANELA.add(txtIdadePorco);
        JANELA.add(lblPesoPorco);
        JANELA.add(txtPesoPorco);
        JANELA.add(btnAddPorco);
        JANELA.add(lstporquinhos);
        JANELA.add(gramasRacao);
        JANELA.add(gramasFeno);
        JANELA.add(gramasVerdura);
        JANELA.add(lblnomeporcosel);
        JANELA.add(lblidadeporcosel);
        JANELA.add(lblpesoporcosel);
        JANELA.add(remover);

        super.setTitle("Mantendo seus Cavia porcellus (Porquinho da India) saudaveis! ");
        setSize(770, 600);
        setVisible(true);
        txtNomePorco.requestFocus();

    }

    Porquinho_da_India porquinho[] = new Porquinho_da_India[1];
    int NumeroPorcos = 0;

    public boolean handleEvent(Event evt) {
        String targetclick = "java.awt.Button[button0,20,300,200x50,label=Novo Porquinho da India adotado]";
        String targetclick2 = "java.awt.Button[button0,315,500,50x50,label=Remover]";
        // System.out.println(evt.id);
        if (evt.target.toString().equals(targetclick) && (1001 == evt.id)) {
            // usuario clicou em novo porquinho adotado
            NumeroPorcos++;

            porquinho = aumentarvetor(porquinho);
            String nome = txtNomePorco.getText();
            nome = nome.trim();
            int peso = Integer.parseInt((txtPesoPorco.getText()).trim());
            int idade = Integer.parseInt((txtIdadePorco.getText()).trim());
            porquinho[NumeroPorcos - 1] = new Porquinho_da_India(nome, peso, idade);
            lstporquinhos.add(nome);
            /*
             * System.out.println("porquinhos:"); for (Porquinho_da_India p : porquinho){
             * System.out.println(p.getNome()); }
             */
            calcularnutricaototal(porquinho);
            txtNomePorco.requestFocus();
        }
        String target = evt.target.toString();
        // System.out.println(evt.id);
        if (target.startsWith("java.awt.List") && !(target.contains("null")) && (evt.id == 1004) || (evt.id == 701)) {
            porquinhoselecionado(porquinho);
        }
        // System.out.println("target:" + evt.target);
        if ((target.contains("Remover")) && (1001 == evt.id)) {
            System.out.println("entrei");
            int idx = lstporquinhos.getSelectedIndex();
            lstporquinhos.remove(idx);
            porquinho = removerselecionado(porquinho, idx);
            calcularnutricaototal(porquinho);
            desselecionar();
            txtNomePorco.requestFocus();
        }

        return false;
    }

    public Porquinho_da_India[] aumentarvetor(Porquinho_da_India vetor[]) {
        return Arrays.copyOf(vetor, NumeroPorcos);
    }

    public void calcularnutricaototal(Porquinho_da_India vet[]) {
        Nutricao nutricionista = new Nutricao();
        int correndovetor = 0;
        int racaototal = 0;
        int fenototal = 0;
        int verdurastotais = 0;
        while (correndovetor < vet.length) {
            nutricionista.CalcularquantidadeDeComida(vet[correndovetor].getIdade(), vet[correndovetor].getPeso());
            racaototal = racaototal + nutricionista.getGramasRacao();
            fenototal = fenototal + nutricionista.getGramasFeno();
            verdurastotais = verdurastotais + nutricionista.getGramasVerdura();
            correndovetor++;
        }
        gramasRacao.setText("Gramas de racao:" + racaototal + "g");
        gramasFeno.setText("Gramas de feno:" + fenototal + "g");
        gramasVerdura.setText("Gramas de verdura:" + verdurastotais + "g");
    }

    public void porquinhoselecionado(Porquinho_da_India vetor[]) {

        Integer idx = lstporquinhos.getSelectedIndex();
        // System.out.println(idx);
        lblnomeporcosel.setText("Nome: " + vetor[idx].getNome());
        lblidadeporcosel.setText("Idade: " + vetor[idx].getIdade() + " Meses");
        lblpesoporcosel.setText("Peso: " + vetor[idx].getPeso() + "g");
    }

    public void desselecionar() {
        lblnomeporcosel.setText("");
        lblidadeporcosel.setText("");
        lblpesoporcosel.setText("");
    }

    public Porquinho_da_India[] removerselecionado(Porquinho_da_India vetor[], int idx) {
        vetor = removeElement(vetor, idx);
        // System.out.println(vetor);
        System.out.println(vetor.length);
        for (Porquinho_da_India vet : vetor) {
            System.out.println(vet.getNome());
        }
        return vetor;
    }

    public Porquinho_da_India[] removeElement(Porquinho_da_India arr[], int index) {
        // Destination array
        NumeroPorcos--;
        Porquinho_da_India arrOut[] = new Porquinho_da_India[arr.length - 1];
        int tamanho = arr.length;
        int contador = 0;
        int num = 0;
        while (contador < tamanho) {
            if (contador != index) {
                arrOut[num] = arr[contador];
            } else {
                try {
                    contador++;
                    arrOut[num] = arr[contador];
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            contador++;
            num++;
        }
        return arrOut;
    }
}