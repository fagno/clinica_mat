package aula2403.model.repository;

import aula2403.model.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VeiculoRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Veiculo> veiculos(){
        Query query = em.createQuery("from Veiculo"); //HQL
        return query.getResultList();
    }

    public List<Veiculo> veiculos(String marca){
        Query query = em.createQuery("from Veiculo v where v.marca like : marca"); //HQL
        query.setParameter("marca" , "%"+marca+"%");
        return query.getResultList();
    }

    public void save(Veiculo veiculo){
        em.persist(veiculo);
    }

}
