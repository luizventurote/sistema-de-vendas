package dao;

import java.sql.SQLException;
import java.util.List;
import model.Cliente;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Luiz
 */
public class ClienteDao extends DefaultDao {
    
     public ClienteDao() throws Exception, SQLException, HibernateException {
        
        this.setTable_reference("cliente");
        this.object_reference = "Cliente";
        
    }

    /**
     * Inserir
     * 
     * @param obj
     * @throws Exception
     * @throws SQLException
     * @throws HibernateException 
     */
    public void insert(Cliente obj) throws Exception, SQLException, HibernateException {

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
    public void delete(Cliente obj) throws Exception, SQLException, HibernateException {

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
    public void update(Cliente obj) throws Exception, SQLException, HibernateException {

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
    public List<Cliente> getAll() throws Exception, SQLException {

        List list = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM "+this.object_reference);

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
    public Cliente get(int id) throws Exception, SQLException {

        Cliente comp = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL para recuperar o componente do banco de dados           
            Query con = this.session.createQuery("FROM "+this.object_reference+" obj WHERE obj.id=" + id);

            con.setMaxResults(1);

            List<Cliente> result = con.list();

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
