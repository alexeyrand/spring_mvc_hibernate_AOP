package com.alexeyrand.mvc_hibernate_AOP.dao;

import com.alexeyrand.mvc_hibernate_AOP.entity.Employee;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        System.out.println("Получаем список всех сотрудников (DAO)");
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getEmployee(int id) {
        System.out.println("Получаем сотрудника с id " + id + "(DAO)");
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);

    }

    @Override
    public void saveEmployee(Employee employee) {
        System.out.println("Сохраняем сотрудника с id " + employee.getId() + "(DAO)");
        Session session = sessionFactory.getCurrentSession();
        session.merge(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        System.out.println("Удаляем сотрудника с id " + id + "(DAO)");
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id =: employeeID");
        query.setParameter("employeeID", id);
        query.executeUpdate();
    }
}
