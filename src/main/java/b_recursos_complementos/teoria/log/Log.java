package b_recursos_complementos.teoria.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Log {

    private static int qtdSteps = 0;
    private static final String PATH = "src/main/java/b_recursos_complementos/teoria/log/teste.txt";

    public static void main(String[] args) throws IOException {
//        escrever("Olá, mundo!");

//        escrever("Hoje testamos uma geração de log!\nEspero que dê certo =D");

//        exemploLogSucesso();

//        exemploLogFalha();
    }

    public static void escrever(String linha) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true));
        String[] linhaPartida = linha.split("\n");
        for (int i = 0; i < linhaPartida.length; i++) {
            bw.write(getDataAtualFormatada("yyyy-MM-dd HH:mm:ss.SSS") + ": " + linhaPartida[i] + "\n");
        }
        bw.close();
    }

    public static void exemploLogSucesso() throws IOException {
        escreverCabecalho("Cadastro de Usuário", "1.0.3");
        escreverCenario("Cadastro de idoso");
        escreverStepSucesso("acessarSite");
        escreverStepSucesso("preencherNome", "Vovô Andrade");
        escreverStepSucesso("preencherIdade", "70");
        escreverStepSucesso("clicarLiConcordo");
        escreverStepSucesso("clicarContinuar");
        escreverUltimoStepSucessoMsg("validarMsgSucesso", "Idoso cadastrado com sucesso!");
        escreverCenario("Cadastro de adm");
        escreverStepSucesso("acessarSite");
        escreverStepSucesso("preencherNome", "Adm Fulano");
        escreverStepSucesso("marcarCheckBoxAdm");
        escreverStepSucesso("clicarContinuar");
        escreverStepSucessoMsg("validarMsgSucesso", "Adm cadastrado com sucesso!");
        escreverUltimoStepSucesso("verificarBaseDeDados", "tabelaAdm");
    }

    public static void exemploLogFalha() throws IOException {
        escreverCabecalho("Cadastro de Usuário", "1.0.3");
        escreverCenario("Cadastro fail");
        escreverStepSucesso("acessarSite");
        escreverStepSucesso("preencherIdadeInvalida", "AA");
        escreverStepSucesso("clicarContinuar");
        try {
            ParaDarErro.soPraDarErro();
        } catch (Exception e) {
            escreverMensagemExcecao(e.getMessage());
            escreverStackTrace(e.getStackTrace());
        }
        escreverLinhaSemDataEHora("\nEssa linha só pra mostrar sem data e hora sem tabulação", false);
        escreverLinhaSemDataEHora("Essa linha só pra mostrar sem data e hora com tabulação\n", true);
    }


    public static void escreverCabecalho(String nomeFeature, String version) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, false));
        bw.write("");
        bw.close();

        escreverLinhaDivisoria(true);
        escrever("SISTEMA: SITE DO MEU TRABALHO");
        escrever("FUNCIONALIDADE: " + nomeFeature.toUpperCase());
        escreverLinhaDivisoria(true);
        escrever("VERSÃO: " + version);
        escreverLinhaDivisoria(true);
    }

    public static void escreverCenario(String cenario) throws IOException {
        qtdSteps = 0;
        String frase = "CENÁRIO: " + cenario.toUpperCase();
        escrever(frase);
    }

    public static void escreverLinhaDivisoria(boolean linhaDupla) throws IOException {
        String carac;
        if (linhaDupla) {
            carac = "=";
        } else {
            carac = "-";
        }

        StringBuilder divisoria = new StringBuilder();
        for (int i = 0; i < 134; i++) {
            divisoria.append(carac);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true));
        bw.write(divisoria + "\n");
        bw.close();
    }

    public static void escreverMensagemExcecao(String message) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true));
        bw.write(getDataAtualFormatada("yyyy-MM-dd HH:mm:ss.SSS") + ": ");
        bw.write(message + "\n");
        bw.close();
    }

    public static void escreverStackTrace(StackTraceElement[] stackTrace) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true));
        String stack = Arrays.toString(stackTrace);
        stack = stack.replace(" ", "");
        stack = stack.replace("[", "");
        stack = stack.replace("]", "");
        String[] stackPartido = stack.split(",");
        for (int i = 0; i < stackPartido.length; i++) {
            bw.write("\t\t\t\t\t\t " + stackPartido[i] + "\n");
        }
        bw.close();
    }

    public static void escreverLinhaSemDataEHora(String mensagem, boolean tabulacao) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true));
        String[] msgPartida = mensagem.split("\n");
        for (int i = 0; i < msgPartida.length; i++) {
            if (tabulacao) {
                bw.write("\t\t\t\t\t\t " + msgPartida[i] + "\n");
            } else {
                bw.write(msgPartida[i] + "\n");
            }
        }
        bw.close();
    }

    public static void escreverStepSucesso(String nomeStep) throws IOException {
        qtdSteps++;
        nomeStep = nomeStep.replace(" ", "");
        nomeStep = "> Step " + qtdSteps + " " + nomeStep;
        escrever(nomeStep);
    }

    public static void escreverStepSucesso(String nomeStep, String valor) throws IOException {
        qtdSteps++;
        nomeStep = nomeStep.replace(" ", "");
        nomeStep = "> Step " + qtdSteps + " " + nomeStep + " - valor utilizado: " + valor;
        escrever(nomeStep);
    }

    public static void escreverStepSucessoMsg(String nomeStep, String msgValidada) throws IOException {
        qtdSteps++;
        nomeStep = nomeStep.replace(" ", "");
        nomeStep = "> Step " + qtdSteps + " " + nomeStep;
        escrever(nomeStep);
        escreverMensagemValidada(msgValidada);
    }

    public static void escreverUltimoStepSucesso(String nomeStep) throws IOException {
        qtdSteps++;
        nomeStep = nomeStep.replace(" ", "");
        nomeStep = "> Step " + qtdSteps + " " + nomeStep;
        escrever(nomeStep);
        escrever("Cenário validado com sucesso.");
        escreverLinhaDivisoria(false);
    }

    public static void escreverUltimoStepSucesso(String nomeStep, String valor) throws IOException {
        qtdSteps++;
        nomeStep = nomeStep.replace(" ", "");
        nomeStep = "> Step " + qtdSteps + " " + nomeStep + " - valor utilizado: " + valor;
        escrever(nomeStep);
        escrever("Cenário validado com sucesso.");
        escreverLinhaDivisoria(false);
    }

    public static void escreverUltimoStepSucessoMsg(String nomeStep, String msgValidada) throws IOException {
        qtdSteps++;
        nomeStep = nomeStep.replace(" ", "");
        nomeStep = "> Step " + qtdSteps + " " + nomeStep;
        escrever(nomeStep);
        escreverMensagemValidada(msgValidada);
        escrever("Cenário validado com sucesso.");
        escreverLinhaDivisoria(false);
    }

    public static void escreverMensagemValidada(String msgValidada) throws IOException {
        msgValidada = "Mensagem validada: \"" + msgValidada + "\"";
        escrever(msgValidada);
    }

    public static String getDataAtualFormatada(String formato) {
        Calendar calendario = Calendar.getInstance();
        SimpleDateFormat formatadorData = new SimpleDateFormat(formato);
        return formatadorData.format(calendario.getTime());
    }

}
