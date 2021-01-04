/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Acme
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label lblCampo;
    public String mainMemoria = "";
    public String percertHolder;
    public double resultadoCalculo = 0;
    public int operacao = 0;
    public int operacaoPre;
    public int i = 0;
    public Boolean finalizado = false;
    public String[] oldMemoria = new String[15];

    @FXML
    private void clickNumero0(ActionEvent event) {
        mainMemoria = (mainMemoria + "0");
        lblCampo.setText(mainMemoria);
        gerenciadorMemoria();
    }

    @FXML
    private void clickNumero1(ActionEvent event) {
        mainMemoria = (mainMemoria + "1");
        lblCampo.setText(mainMemoria);
        gerenciadorMemoria();
    }

    @FXML
    private void clickNumero2(ActionEvent event) {
        mainMemoria = (mainMemoria + "2");
        lblCampo.setText(mainMemoria);
        gerenciadorMemoria();
    }

    @FXML
    private void clickNumero3(ActionEvent event) {
        mainMemoria = (mainMemoria + "3");
        lblCampo.setText(mainMemoria);
        gerenciadorMemoria();
    }

    @FXML
    private void clickNumero4(ActionEvent event) {
        mainMemoria = (mainMemoria + "4");
        lblCampo.setText(mainMemoria);
        gerenciadorMemoria();
    }

    @FXML
    private void clickNumero5(ActionEvent event) {
        mainMemoria = (mainMemoria + "5");
        lblCampo.setText(mainMemoria);
        gerenciadorMemoria();
    }

    @FXML
    private void clickNumero6(ActionEvent event) {
        mainMemoria = (mainMemoria + "6");
        lblCampo.setText(mainMemoria);
        gerenciadorMemoria();
    }

    @FXML
    private void clickNumero7(ActionEvent event) {
        mainMemoria = (mainMemoria + "7");
        lblCampo.setText(mainMemoria);
        gerenciadorMemoria();
    }

    @FXML
    private void clickNumero8(ActionEvent event) {
        mainMemoria = (mainMemoria + "8");
        lblCampo.setText(mainMemoria);
        gerenciadorMemoria();
    }

    @FXML
    private void clickNumero9(ActionEvent event) {
        mainMemoria = (mainMemoria + "9");
        lblCampo.setText(mainMemoria);
        gerenciadorMemoria();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        mainMemoria = (mainMemoria + "0");
        lblCampo.setText(mainMemoria);
    }

    @FXML
    public void clickSoma(ActionEvent event) {
        operacao = 1;
        gerenciadorNumeros(null);
    }

    @FXML
    public void clickMulti(ActionEvent event) {
        operacao = 2;
        gerenciadorNumeros(null);
    }

    @FXML
    public void clickDivisao(ActionEvent event) {
        operacao = 3;
        gerenciadorNumeros(null);
    }

    @FXML
    public void clickAdicao(ActionEvent event) {
        operacao = 4;
        gerenciadorNumeros(null);
    }

    @FXML
    public void gerenciadorNumeros(ActionEvent event) {
        resultadoCalculo = Double.parseDouble(mainMemoria);
        mainMemoria = "";
        lblCampo.setText(mainMemoria);
    }

    @FXML
    public void clickClear(ActionEvent event) {
        resultadoCalculo = 0;
        lblCampo.setText("0");
        mainMemoria = "";
        percertHolder = "";
        operacao = 0;
        finalizado = false;
        for (int x = 0 ;x < 15; x++){
            oldMemoria[x] = "";
            System.out.println("oldMemoria[" + x + "] = null");
        }       
        i = 0;
        System.out.println("i = [" + i + "]");
    }

    @FXML
    public void clickRemove(ActionEvent event) {
        i--;
        mainMemoria = oldMemoria[i];
        lblCampo.setText(mainMemoria);        
        System.out.println("oldMemoria[" + i + "]");
            
    }

    @FXML
    public void gerenciadorMemoria() {
        i++;
        oldMemoria[i] = mainMemoria;
        System.out.println("oldMemoria[" + i + "]");       
    }

    @FXML
    public void clickPercent(ActionEvent event) {
        if (!finalizado) {
            if (resultadoCalculo != 0 && operacao != 0) {
                operacaoPre = operacao;
                operacao = 5;
                percertHolder = mainMemoria + "%";
                lblCampo.setText(percertHolder);
            }
        }
    }

    @FXML
    public void clickNegativo(ActionEvent event) {
        if (!mainMemoria.contains("-")) {
            mainMemoria = (mainMemoria + "-");
            lblCampo.setText(mainMemoria);
        }
    }

    @FXML
    public void clickPonto(ActionEvent event) {
        if (!mainMemoria.contains(".")) {
            mainMemoria = (mainMemoria + ".");
            lblCampo.setText(mainMemoria);
        }
    }

    @FXML
    public void mostraResultado() {
        lblCampo.setText(String.valueOf(resultadoCalculo));
    }

    @FXML
    public void clickResultado(ActionEvent event) {
        finalizado = true;
        switch (operacao) {
            case 1:
                resultadoCalculo = resultadoCalculo + Double.parseDouble(mainMemoria);
                mostraResultado();
                break;
            case 2:
                resultadoCalculo = resultadoCalculo * Double.parseDouble(mainMemoria);
                mostraResultado();
                break;
            case 3:
                resultadoCalculo = resultadoCalculo / Double.parseDouble(mainMemoria);
                mostraResultado();
                break;
            case 4:
                resultadoCalculo = resultadoCalculo - Double.parseDouble(mainMemoria);
                mostraResultado();
                break;
            case 5:
                switch (operacaoPre) {
                    case 1:
                        resultadoCalculo = resultadoCalculo + ((resultadoCalculo / 100) * Double.parseDouble(mainMemoria));
                        mostraResultado();
                        break;
                    case 2:
                        resultadoCalculo = resultadoCalculo * ((resultadoCalculo / 100) * Double.parseDouble(mainMemoria));
                        mostraResultado();
                        break;
                    case 3:
                        resultadoCalculo = resultadoCalculo / ((resultadoCalculo / 100) * Double.parseDouble(mainMemoria));
                        mostraResultado();
                        break;
                    case 4:
                        resultadoCalculo = resultadoCalculo - ((resultadoCalculo / 100) * Double.parseDouble(mainMemoria));
                        mostraResultado();
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
