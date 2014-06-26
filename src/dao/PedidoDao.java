package dao;

import java.sql.SQLException;
import java.util.List;
import model.Pedido;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Luiz
 */
public class PedidoDao extends DefaultDao {
    
     public PedidoDao() throws Exception, SQLException, HibernateException {
        
        this.setTable_reference("pedido");
        this.object_reference = "Pedido";
        
    }

    /**
     * Inserir
     * 
     * @param obj
     * @throws Exception
     * @throws SQLException
     * @throws HibernateException 
     */
    public void insert(Pedido obj) throws Exception, SQLException, HibernateException {

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
    public void delete(Pedido obj) throws Exception, SQLException, HibernateException {

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
    public void update(Pedido obj) throws Exception, SQLException, HibernateException {

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
    public List<Pedido> getAll() throws Exception, SQLException {

        List list = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL           
            Query con = this.session.createQuery("FROM Pedido p JOIN FETCH p.cliente ORDER BY data DESC");

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
    public Pedido get(int id) throws Exception, SQLException {

        Pedido comp = null;

        try {

            this.session = util.HibernateUtil.getSessionFactory().openSession();

            this.session.beginTransaction();

            // HQL para recuperar o componente do banco de dados           
            Query con = this.session.createQuery("FROM "+this.object_reference+" obj JOIN FETCH obj.cliente JOIN FETCH obj.funcionario JOIN FETCH obj.produtos WHERE obj.id=" + id);

            con.setMaxResults(1);

            List<Pedido> result = con.list();

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
