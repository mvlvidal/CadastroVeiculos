package dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class GenericDao<T, Type extends Serializable> {

    private Class<T> persistenceClass;

    public GenericDao(Class persistenceClass) {
        super();
        this.persistenceClass = persistenceClass;
    }

    public T salvar(T entity) {

        T retorno = null;

        Session sessao = dao.HibernateUtil.getSession();
        Transaction tx = null;

        try {

            tx = sessao.beginTransaction();
            //sessao.save(entity);
            //sessao.update(entity);
            retorno = (T) sessao.merge(entity);
            sessao.flush();
            tx.commit();

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        return retorno;
    }

    public T find(Long id) {

        T retorno = null;
        Session sessao = dao.HibernateUtil.getSession();

        try {

            retorno = (T) sessao.get(persistenceClass, id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }

    public T deletar(Long id) {

        Session sessao = dao.HibernateUtil.getSession();
        Transaction tx = null;

        T retorno = null;

        try {
            tx = sessao.beginTransaction();
            retorno = (T) sessao.get(persistenceClass, id);
            sessao.delete(retorno);
            tx.commit();

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        return retorno;
    }

    public List<T> listar() {

        Session sessao = dao.HibernateUtil.getSession();

        Criteria criteria = sessao.createCriteria(persistenceClass);

        return criteria.list();
    }

}
