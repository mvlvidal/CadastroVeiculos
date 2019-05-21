package bean;

import dados.Categoria;
import dao.CategoriaDao;
import dao.HibernateUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

@ViewScoped
@ManagedBean
public class CategoriaBean {
    
    private Categoria ca1;
    private CategoriaDao cadao;
    private List<Categoria> categorias;
    private Collection selectCategorias;
    
    @PostConstruct
    public void init() {

        ca1 = new Categoria();
        cadao = new CategoriaDao();
        categorias = new ArrayList<>();
        categorias = cadao.listar();

    }

    public void salvar() {
        
        Categoria ca2 = cadao.salvar(ca1);
        System.out.println("TESTE: "+ca2.getId());
        if (ca2 != null) {

            ca1 = ca2;
            cadao.listar();

        }

    }

    public void deletar(Long id) {
        
        Categoria ca2 = cadao.deletar(id);
        
        if (ca2 != null) {
            ca1 = ca2;
            cadao.listar();
        }
    }

    public void editar(Long id) {
        ca1 = cadao.find(id);
    }
   

    public Categoria getCa1() {
        return ca1;
    }

    public void setCa1(Categoria ca1) {
        this.ca1 = ca1;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

}
