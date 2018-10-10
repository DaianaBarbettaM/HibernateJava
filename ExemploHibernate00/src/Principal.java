
import bean.Sistema;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Principal {
    
    public static void main(String[] args){
        Configuration conf =new Configuration() ;
        StandardServiceRegistry sr= new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        SessionFactory factory = new Configuration()
                .buildSessionFactory(sr);
        
        Transaction transaction = null;
        try{
            Session session = factory.openSession();
            transaction= session.getTransaction();
            transaction.begin();
            
            //PARA INSERIR NO SISTEMA ↓
            //Sistema sistemaDoKleiton = new Sistema();
            //sistemaDoKleiton.setNome("Kleiton");
            //session.save(sistemaDoKleiton);
            
            //PARA ALTERAR NO SISTEMA ↓
            //sistemaDoKleiton.setId(1);  
            //sistemaDoKleiton.setNome("Cleiton");
            //session.update(sistemaDoKleiton);
            
            List resultados = session.createQuery("from Sistema").list();
             for(Sistema sistema: (List<Sistema>)resultados){
                 System.out.println(sistema.getNome());
            }
             
            //PARA REMOVER! ↓
            Sistema sistema = new Sistema();
            sistema.setId(1);
            session.remove(sistema);
            
            //INSERT NO BD
            transaction.commit();
            
        }catch(HibernateException e){
            e.printStackTrace();
            if(transaction.isActive()){
                transaction.rollback();
            }
        }finally{
        factory.close();
        }
    }
}
