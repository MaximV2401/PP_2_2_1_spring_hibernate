package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class CarDaoImpl implements CarDao{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<Car> listCars() {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }

    @Override
    public Car getCar(String model) {
        String HQL = "from Car car where car.model = :model";
        return sessionFactory.getCurrentSession().createQuery(HQL, Car.class).setParameter("model", model).getSingleResult();

    }
}
