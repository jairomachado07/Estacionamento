package com.example.estacionamento;

@SpringBootApplication
public class EstacionamentoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstacionamentoApplication.class, args);
    }

    @Autowired
    private Estacionamento estacionamento;

    public EstacionamentoApplication(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }

    public void calcularTarifa(Carro carro) {
        int horasEstacionado = carro.getHorasEstacionado();
        Tarifa tarifa = estacionamento.getTarifa(horasEstacionado);
        System.out.println("Tarifa: " + tarifa.getValor());
    }

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }

    @Override
    public String toString() {
        return "EstacionamentoApplication [estacionamento=" + estacionamento + "]";
    }

   
}