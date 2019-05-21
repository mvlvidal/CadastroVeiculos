package dados;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="modelo")
    private String modelo;
    
    @Column(name="marca")
    private String marca;
    
    @Column(name="cor")
    private String cor;
    
    @Column(name="potencia")
    private double potencia;
    
    @Column(name="fabricacao")
    @Temporal(TemporalType.DATE)
    Calendar fabricacao;
    
    @JoinColumn(name="idCategoria")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Categoria categoria;
    
    @JoinColumn(name="idCombustivel")
    @ManyToOne(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
    private Combustivel combustivel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    
}
