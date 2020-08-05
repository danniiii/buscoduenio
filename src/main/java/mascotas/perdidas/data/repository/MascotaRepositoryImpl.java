package mascotas.perdidas.data.repository;

import mascotas.perdidas.data.entity.MascotaEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MascotaRepositoryImpl {

    @PersistenceContext
    EntityManager entityManager;

    public List<MascotaEntity> getData(Map<String, Integer> conditions){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<MascotaEntity> query= cb.createQuery(MascotaEntity.class);//en este objeto pondremos las condiciones de la query
        Root<MascotaEntity> root = query.from(MascotaEntity.class);
        List<Predicate> predicates = new ArrayList<>(); //En esa lista irán todos los Predicate que no son sino las condiciones de nuestra query.

        conditions.forEach((field,value) ->
        {
            switch (field) {
                case "partido":
                    if (value != null)
                        predicates.add(cb.equal(root.get(field), value ));
                    break;
                case "localidad":
                    if (value != null)
                        predicates.add(cb.equal(root.get(field), value ));
                    break;
                case "color1":
                    if (value != null)
                        predicates.add(cb.equal(root.get(field), value ));
                    break;
                case "color2":
                    if (value != null)
                        predicates.add(cb.equal(root.get(field), value ));
                    break;
                case "idTipoMascota":
                    if (value != null)
                        predicates.add(cb.equal(root.get(field), value ));
                    break;
                case "raza":
                    if (value != null)
                        predicates.add(cb.equal(root.get(field), value ));
                    break;

    /*            case "created":
                    String dateCondition=(String) conditions.get("dateCondition");
                    switch (dateCondition)
                    {
                        case GREATER_THAN:
                            predicates.add(cb.greaterThan(root.<Date>get(field),(Date)value));
                            break;
                        case LESS_THAN:
                            predicates.add(cb.lessThan(root.<Date>get(field),(Date)value));
                            break;
                        case EQUAL:
                            predicates.add(cb.equal(root.<Date>get(field),(Date)value));
                            break;
                    }
                    break;*/
            }
        });

        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }
}