package bean;

import dados.Veiculo;
import dao.VeiculoDao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class VeiculoBean {

    private Veiculo v1;
    private VeiculoDao vdao;
    private List<Veiculo> veiculos;

    @PostConstruct
    public void init() {

        v1 = new Veiculo();
        vdao = new VeiculoDao();
        veiculos = new ArrayList<>();
        veiculos = vdao.listar();

    }

    public void salvar() {
        
        Veiculo v2 = vdao.salvar(v1);

        if (v2 != null) {

            v1 = v2;
            vdao.listar();

        }

    }

    public void deletar(Long id) {
        
        Veiculo v2 = vdao.deletar(id);

        if (v2 != null) {
            v1 = v2;
            vdao.listar();
        }
    }

    public void editar(Long id) {
        v1 = vdao.find(id);
    }

    public Veiculo getV1() {
        return v1;
    }

    public void setV1(Veiculo v1) {
        this.v1 = v1;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    

}
