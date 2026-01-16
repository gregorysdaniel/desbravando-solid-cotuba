package cotuba.domain;

import java.nio.file.Path;
import java.util.List;

public class Ebook {
    private String formato;

    private Path arquivosDeSaida;

    private List<Capitulo> capitulos;

    public boolean isUltimoCapitulo(Capitulo capitulo) {
        return this.capitulos.get(this.capitulos.size() - 1).equals(capitulo);
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Path getArquivosDeSaida() {
        return arquivosDeSaida;
    }

    public void setArquivosDeSaida(Path arquivosDeSaida) {
        this.arquivosDeSaida = arquivosDeSaida;
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }
}
