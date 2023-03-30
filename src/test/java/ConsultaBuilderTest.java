import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ConsultaBuilderTest {

    String dataRecebida = "23/11/2025";
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Date dataFormatada;

    {
        try {
            dataFormatada = formato.parse(dataRecebida);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void deveRetornarExcecaoParaNomeMedico() {

        try {
            ConsultaBuilder consultaBuilder = new ConsultaBuilder();
            Consulta consulta = consultaBuilder
                    .setPaciente("Kellen Miranda")
                    .setDataConsulta(dataFormatada)
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaNomePaciente() {

        try {
            ConsultaBuilder consultaBuilder = new ConsultaBuilder();
            Consulta consulta = consultaBuilder
                    .setMedico("Kellen Miranda")
                    .setDataConsulta(dataFormatada)
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaData() {

        try {
            ConsultaBuilder consultaBuilder = new ConsultaBuilder();
            Consulta consulta = consultaBuilder
                    .setMedico("Kellen Miranda")
                    .setPaciente("Kellen Miranda")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Data inválida", e.getMessage());
        }
    }

    @Test
    void deveRetornarConsultaValida() {

        ConsultaBuilder consultaBuilder = new ConsultaBuilder();
        Consulta consulta = consultaBuilder
                .setMedico("Kellen Miranda")
                .setPaciente("Kellen Miranda")
                .setDataConsulta(dataFormatada)
                .build();

        assertNotNull(consulta);
    }

}
