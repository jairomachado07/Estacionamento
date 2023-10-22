package Estacionamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstacionamentoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstacionamentoApplication.class, args);
    }

    @Autowired
    private Estacionamento estacionamento;

    public void calcularTarifa(Carro carro) {
        int horasEstacionado = carro.getHorasEstacionado();
        Tarifa tarifa = estacionamento.getTarifa(horasEstacionado);
        System.out.println("Tarifa: " + tarifa.getValor());
    }
}

class Estacionamento {

    private static Estacionamento estacionamento;

    private Estacionamento() {
    }

    public static Estacionamento getInstance() {
        if (estacionamento == null) {
            estacionamento = new Estacionamento();
        }
        return estacionamento;
    }

    public Tarifa getTarifa(int horasEstacionado) {
        if (horasEstacionado <= 2) {
            return new Tarifa(10);
        } else if (horasEstacionado <= 4) {
            return new Tarifa(20);
        } else {
            return new Tarifa(30);
        }
    }
}

class Carro {

    private int horasEstacionado;

    public Carro(int horasEstacionado) {
        this.horasEstacionado = horasEstacionado;
    }

    public int getHorasEstacionado() {
        return horasEstacionado;
    }
}

class Tarifa {

    private int valor;

    public Tarifa(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
