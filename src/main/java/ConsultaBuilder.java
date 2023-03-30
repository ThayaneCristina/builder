import java.util.Date;

public class ConsultaBuilder {

    private Consulta consulta;

    public ConsultaBuilder(){
        consulta = new Consulta();
    }

    public  Consulta build() {
        if (consulta.getPaciente().equals("")) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (consulta.getMedico().equals("")){
            throw new IllegalArgumentException("Nome inválido");
        }
        if (consulta.getDataConsulta()==null) {
            throw new IllegalArgumentException("Data inválida");
        }
        return consulta;
    }

    public ConsultaBuilder setMedico(String medico) {
        consulta.setMedico(medico);
        return this;
    }

    public ConsultaBuilder setPaciente(String paciente) {
        consulta.setPaciente(paciente);
        return this;
    }

    public ConsultaBuilder setProcedimento(String procedimento) {
        consulta.setProcedimento(procedimento);
        return this;
    }

    public ConsultaBuilder setDataConsulta(Date dataConsulta) {
        consulta.setDataConsulta(dataConsulta);
        return this;
    }

    public ConsultaBuilder setHorario(Date horario) {
        consulta.setHorario(horario);
        return this;
    }

    public ConsultaBuilder seObservacao(String observacao) {
        consulta.setObservacao(observacao);
        return this;
    }

    public ConsultaBuilder setConvenio(String convenio) {
        consulta.setConvenio(convenio);
        return this;
    }

    public ConsultaBuilder setValor(double valor) {
        consulta.setValor(valor);
        return this;
    }

}
