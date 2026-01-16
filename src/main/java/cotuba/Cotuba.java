package cotuba;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {
    public void executa(String formato, Path diretorioDosMD, Path arquivoDeSaida) {
        RenderizadorMDParaHTML renderizador = new RenderizadorMDParaHTML();

        List<Capitulo> capitulos = renderizador.renderiza(diretorioDosMD);

        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setCapitulos(capitulos);
        ebook.setArquivosDeSaida(arquivoDeSaida);

        if ("pdf".equals(formato)) {
            GeradorPDF geradorPDF = new GeradorPDF();
            geradorPDF.gera(ebook);
        } else if ("epub".equals(formato)) {
            GeradorEPUB geradorEPUB = new GeradorEPUB();
            geradorEPUB.gera(ebook);
        } else {
            throw new IllegalArgumentException("Formato do ebook inválido: " + formato);
        }

        System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);
    }
}
