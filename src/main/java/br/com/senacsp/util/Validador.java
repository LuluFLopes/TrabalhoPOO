package br.com.senacsp.util;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Classe utilizada para validação dos dados nos campos
 *
 * @author lucme
 *
 */
public class Validador {

    // Array grava os erros de maneira geral.
    private ArrayList<String> mensagensErro = new ArrayList<>();

    /**
     * Método utilizado para conversão de possíveis números inteiros dentro dos
     * campos
     *
     * @param txt - JTextField
     * @throws NumberFormatException
     * @throws NullPointerException
     */
    public void validarNumero(JTextField txt) {

        try {
            //Verifico se o campo está vazio
            if (txt.getText().trim().equals("")) {
                throw new NullPointerException();
            }
            int valorConvertido = Integer.parseInt(txt.getText());
            txt.setBackground(Color.WHITE);
        } catch (NumberFormatException e) {
            this.mensagensErro.add("Falha ao converter o valor do campo " + txt.getName() + " em inteiro!");
            txt.setBackground(Color.red);
        } catch (NullPointerException e) {
            this.mensagensErro.add("Digite um valor para o campo " + txt.getName() + "!");
            txt.setBackground(Color.red);
        }

    }

    /**
     * Método utilizado para verificar se um campo de texto está nulo
     *
     * @param txt - jTextFied
     * @throws NullPointerException
     */
    public void validarTexto(JTextField txt) {

        try {
            // Verifico se o campo está vazio.
            if (txt.getText().trim().replace(" ", "").replace("-", "").replace("(", "").replace(")", "").replace(".", "").equals("")) {
                throw new NullPointerException();
            }
            txt.setBackground(Color.WHITE);
        } catch (NullPointerException e) {
            this.mensagensErro.add("Digite um valor para o campo " + txt.getName() + "!");
            txt.setBackground(Color.red);
        }
    }

    /**
     * Método utilizado para verificar se a linhas a partir da linha 1 foram
     * selecionadas
     *
     * @param cbo - JComboBox
     * @throws NullPointerException
     */
    public void validarCbo(JComboBox cbo) {

        int index = cbo.getSelectedIndex();

        try {
            // Verifico se o campo está vazio.
            if (index == 0) {
                throw new NullPointerException();
            }
            cbo.setBackground(Color.WHITE);
        } catch (NullPointerException e) {
            this.mensagensErro.add("Digite um valor para o campo " + cbo.getName() + "!");
            cbo.setBackground(Color.red);
        }
    }

    /**
     * Método utilizado para verificar se um campo de texto está nulo ou no
     * formato incorreto
     *
     * @param txt - JTextFiled
     * @throws NumberFormatException
     * @throws NullPointerException
     */
    public void validarDouble(JTextField txt) {

        try {
            // Verifico se o campo está vazio.
            if (txt.getText().trim().equals("")) {
                throw new NullPointerException();
            }
            // Tentativa de conversão.
            Double valorConvertido = Double.parseDouble(txt.getText());
            txt.setBackground(Color.WHITE);
        } catch (NumberFormatException e) {
            this.mensagensErro.add("Falha ao converter o valor do campo " + txt.getName() + " em float");
            txt.setBackground(Color.red);
        } catch (NullPointerException e) {
            this.mensagensErro.add("Digite um valor para o campo " + txt.getName() + "!");
            txt.setBackground(Color.red);
        }
    }

    /**
     * Método responsável para validar se exite erros gravados na ArrayList
     *
     * @return boolean - true Sem erros gravados; false Com erros gravados na
     * lista
     */
    public boolean temErro() {
        if (this.mensagensErro.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método responsável por limpar a ArrayList. Utilizado no método
     * {@link #exibirMensagensErro()}
     *
     */
    public void limparMensagens() {
        this.mensagensErro.clear();
    }

    /**
     * Método de impressão das mensagens armazenadas na ArrayList e limpa a
     * lista caso tenha conteúdo nela. Utilizando o método
     * {@link #limparMensagens()} para limpar
     *
     */
    public void exibirMensagensErro() {
        String errosFormulario = "";
        for (String msg : this.mensagensErro) {
            errosFormulario += msg + "\n";
        }
        if (!errosFormulario.equals("")) {
            JOptionPane.showMessageDialog(null, errosFormulario);
            this.limparMensagens();
        }
    }
}
