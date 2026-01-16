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

        Cotuba cotuba = new Cotuba();
        cotuba.executa(formato, diretorioDosMD, arquivoDeSaida);

    } catch (Exception ex) {
      System.err.println(ex.getMessage());
      if (modoVerboso) {
        ex.printStackTrace();
      }
      System.exit(1);
    }
  }

}
