package br.uesc.computacao.estagio.aplicacao.util;

import java.awt.Toolkit;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 * JTextField personalizado permitindo somente numeros inteiros ou ponto flutuante.
 *
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 */

public class JNumberFloatField extends JTextField {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Variáveis globais.
     */
    private Toolkit toolkit;
    private NumberFormat integerFormatter;
    private int maxDigits;


    /**
     * Constroi um novo JNumberFloatField com m�ximo de caracteres igual a maxNoDigits.
     *
     * @param maxNoDigits Um inteiro contendo o n�mero maximo de
     * caracteres do campo.
     */
    public JNumberFloatField(int maxNoDigits) {
        super(maxNoDigits-1);
        toolkit = Toolkit.getDefaultToolkit();
        integerFormatter = NumberFormat.getNumberInstance(Locale.US);
        integerFormatter.setParseIntegerOnly(true);
        if(maxNoDigits<1) {
            maxDigits=99;
        }
        else {
            maxDigits=maxNoDigits;
        }
    }


    /**
     * Construtor, Constroi um novo JNumberFloatField com tamanho maximo de 99.
     */
    public JNumberFloatField() {
        super(4);
        toolkit = Toolkit.getDefaultToolkit();
        integerFormatter = NumberFormat.getNumberInstance(Locale.US);
        integerFormatter.setParseIntegerOnly(true);
        maxDigits=99;
    }


    /**
     * Retorna o comprimento do JNumberFloatField.
     *
     * @return Um inteiro contendo o total de caracteres no campo.
     */
    public int getlength() {
        String fieldValue=getText();
        return (fieldValue.length());
    }

    /**
     * Retorna o valor do JNumberField.
     *
     * @return Um inteiro contendo o texto do campo.
     */
    public float getValue() {
        int retVal = 0;
        try {
            retVal = integerFormatter.parse(getText()).intValue();
        } catch (ParseException e) {
            // Isto nunca deveria acontecer porque insertString permite
            // apenas dados propriamente formatados para inserir no JNumberField.
            toolkit.beep();
        }
        return retVal;
    }

    /**
     * Seta o valor passado no JNumberFloatField.
     *
     * @param value Um inteiro contendo o valor a ser escrito no campo.
     */
    public void setValue(int value) {
        setText(integerFormatter.format(value));
    }

    /**
     * Seta o numero maximo de caracteres no JNumberFloatField.
     *
     * @param value um inteiro contendo a capacidade m�xima do campo.
     */
    public void setMaxDigits(int value) {
        if(value>0) {
            maxDigits=value;
        }
    }


    /**
     * Retorna o numero maximo de caracteres no JNumberFloatField.
     *
     * @return Um inteiro contendo o maximo de caracteres suportado pelo campo.
     */
    public int getMaxDigits() {
        return maxDigits;
    }

    /**
     * Limpa o JNumberFloatField.
     */
    public void clearField() {
        setText("");
    }

    /**
     * Cria um novo documento padrao para o campo.
     *
     * @return Um documento novo que ser� aplicado no componente.
     */
    protected Document createDefaultModel() {
        return new WholeNumberDocument();
    }

    /**
     * Insere o texto digitado no campo, conforme ele e digitado.
     * Caso um caracter nao permitido seja digitado, nao e exibido.
     *
     * @param offs Um inteiro contendo a capacidade do campo.
     * @param str Uma String contendo o texto a ser inserido no campo.
     * @param a Um AttributeSet contendo os atributos.
     */
    protected class WholeNumberDocument extends PlainDocument {

        /**
		 *
		 */
		private static final long serialVersionUID = 1L;

		public void insertString(int offs, String str, AttributeSet a)
        throws BadLocationException {
            char[ ] source = str.toCharArray();
            char[ ] result = new char[source.length];
            int j = 0;

            for (int i = 0; i < result.length; i++) {
                //impede a quebra de linha de ser mostrada no campo.
                if ((Character.isWhitespace(source[i]) || ((source[i]) == '.') || ((source[i]) == ' ') ||
                    Character.isDigit(source[i]))&&(offs<(maxDigits)) && (int)source[i] != 10)
                    result[j++] = source[i];
                else
                    toolkit.beep();
            }
            super.insertString(offs, new String(result, 0, j), a);
        }
    }
}

