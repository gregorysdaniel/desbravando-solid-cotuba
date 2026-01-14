package cotuba;

import java.nio.file.Path;

public class Main {

  public static void main(String[] args) {

    Path diretorioDosMD;
    String formato;
    Path arquivoDeSaida;
    boolean modoVerboso = false;

    try {
        LeitorOpcoesCLI leitorOpcoesCLI = new LeitorOpcoesCLI(args);

        diretorioDosMD = leitorOpcoesCLI.getDiretorioDosMD();
        formato = leitorOpcoesCLI.getFormato();
        arquivoDeSaida = leitorOpcoesCLI.getArquivoDeSaida();
        modoVerboso = leitorOpcoesCLI.isModoVerboso();

      if ("pdf".equals(formato)) {
        GeradorPDF geradorPDF = new GeradorPDF();
        geradorPDF.gera(diretorioDosMD, arquivoDeSaida);
      } else if ("epub".equals(formato)) {
        GeradorEPUB geradorEPUB = new GeradorEPUB();
        geradorEPUB.gera(diretorioDosMD, arquivoDeSaida);
      } else {
        throw new IllegalArgumentException("Formato do ebook inválido: " + formato);
      }

      System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);

    } catch (Exception ex) {
      System.err.println(ex.getMessage());
      if (modoVerboso) {
        ex.printStackTrace();
      }
      System.exit(1);
    }
  }

}
