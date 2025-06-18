package aula2403.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

@Entity //gera uma tabela no BD
public class Veiculo implements Serializable {

    @Id //chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento
    private Long id;

    @NotBlank
    private String marca;

    //gets e sets
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
