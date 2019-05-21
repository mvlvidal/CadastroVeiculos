package bean;

import dados.Combustivel;
import dao.CombustivelDao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class CombustivelBean {
    
    private Combustivel co1;
    private CombustivelDao codao;
    private List<Combustivel> combustiveis;
    
    @PostConstruct
    public void init(){
        
        co1 = new Combustivel();
        codao = new CombustivelDao();
        combustiveis = new ArrayList<>();
        combustiveis = codao.listar();
        
    }
    
    public void salvar(){
    
        Combustivel co2 = codao.salvar(co1);
        
        if(co2 != null){
            
           
            co1 = co2;
            codao.listar();
            
        }
        
    }
    
    public void deletar(Long id){
    
        Combustivel co2 = codao.deletar(id);
        
        if(co2 != null){
            
            co1 = co2;
            codao.listar();
            
        }
        
    }
    
    public void editar(Long id){
        
        co1 = codao.find(id);
        
    }

    public Combustivel getCo1() {
        return co1;
    }

    public void setCo(Combustivel co1) {
        this.co1= co1;
    }

    public List<Combustivel> getCombustiveis() {
        return combustiveis;
    }

    public void setCombustiveis(List<Combustivel> combustiveis) {
        this.combustiveis = combustiveis;
    }
    
    
    
}
