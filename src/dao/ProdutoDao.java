package dao;

import java.sql.SQLException;
import java.util.List;
import model.Produto;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Luiz
 */
public class ProdutoDao extends DefaultDao {
    
     public ProdutoDao() throws Exception, SQLException, HibernateException {
        
        this.setTable_reference("produto");
        
    }

    /**
     * Inserir
     * 
     * @param obj
     * @throws Exception
     * @throws SQLException
     * @throws HibernateException 
     */
    public void insert(Produto obj) throws Exception, SQLException, HibernateException {

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            this.session.save(obj);

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    /**
     * Deletar
     *
     * @param obj
     * @throws Exception
     * @throws SQLException
     * @throws HibernateException
     */
    public void delete(Produto obj) throws Exception, SQLException, HibernateException {

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            this.session.delete(obj);

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    /**
     * Atualizar
     *
     * @param obj
     * @throws Exception
     * @throws SQLException
     * @throws HibernateException
     */
    public void update(Produto obj) throws Exception, SQLException, HibernateException {

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            this.session.update(obj);

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    /**
     * Return all inserted objects.
     *
     * @return
     * @throws Exception
     * @throws SQLException
     */
    public List<Produto> getAll() throws Exception, SQLException {

        List<Produto> list = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM Produto");

            list = con.list();

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            return list;
        }
    }
    
    /**
     * Get object by ID
     *
     * @param id
     * @return
     * @throws Exception
     * @throws SQLException
     */
    public Produto get(int id) throws Exception, SQLException {

        Produto comp = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL para recuperar o componente do banco de dados           
            Query con = this.session.createQuery("FROM Produto obj WHERE obj.id=" + id);

            con.setMaxResults(1);

            List<Produto> result = con.list();

            comp = result.get(0);

            this.session.getTransaction().commit();

        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            return comp;
        }
    }
    
}
