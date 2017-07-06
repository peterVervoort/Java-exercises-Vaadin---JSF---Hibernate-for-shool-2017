package be.mobyus.hibernate.exercise1.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.mobyus.hibernate.exercise1.AddressSearchCriteria;
import be.mobyus.hibernate.exercise1.entities.Person;

@Profile("hibernate")
@Repository
@Transactional
public class PersonDaoImpl extends HibernateTemplate implements PersonDao {

	private SessionFactory sessionFactory;

	@Autowired
	public PersonDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Person> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Person").list();
	}

	@Override
	public List<Person> findByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Person as p where lower(p.name) = :name" ).setParameter("name", name.toLowerCase()).list();
	}

	@Override
	public void removePerson(Person person) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(person);
	}

	@Override
	public void savePerson(Person person) {
		Session session = sessionFactory.getCurrentSession();
		session.save(person);
	}

	@Override
	public List<Person> findByAddress(AddressSearchCriteria addressSearchCriteria) {
		Session session = sessionFactory.getCurrentSession();

		List<String> fragments = new ArrayList<>();
		Map<String, String> parameters = new HashMap<>();

		if (addressSearchCriteria.getBox()!=null){
			fragments.add("box = :box");
			parameters.put("box",addressSearchCriteria.getBox());
		}

		if (addressSearchCriteria.getCountry()!= null){
			fragments.add("country = :country");
			parameters.put("country", addressSearchCriteria.getCountry());
		}

		if (addressSearchCriteria.getHouseNumber()!= null){
			fragments.add("houseNumber= :houseNumber");
			parameters.put("houseNumber", addressSearchCriteria.getHouseNumber());
		}

		if (addressSearchCriteria.getMunicipality()!=null){
			fragments.add("municipality = :municipality");
			parameters.put("municipality", addressSearchCriteria.getMunicipality());
		}

		if (addressSearchCriteria.getPostalCode() != null){
			fragments.add("postalCode = :postalCode");
			parameters.put("postalCode", addressSearchCriteria.getPostalCode());
		}

		if (addressSearchCriteria.getStreet() != null){
			fragments.add("street = :street");
			parameters.put("street", addressSearchCriteria.getStreet());
		}

		StringBuilder criteria = new StringBuilder("select p from Person p" + "join p.address a where ");
		//fragments.forEach(f -> criteria.append(f + " AND"));
		criteria.delete((criteria.length()-3), criteria.length());




		return session.createQuery(criteria.toString()).list();
	}
}
