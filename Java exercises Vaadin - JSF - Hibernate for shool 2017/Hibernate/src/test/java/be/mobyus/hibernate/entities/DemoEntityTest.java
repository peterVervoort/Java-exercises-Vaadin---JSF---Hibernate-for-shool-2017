package be.mobyus.hibernate.entities;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import be.mobyus.demo.DemoEntity;

@Test
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class DemoEntityTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private SessionFactory sessionFactory;

	public void test() {

		DemoEntity demoEntity = new DemoEntity();
		demoEntity.setProperty("testing 123");

		sessionFactory.getCurrentSession().save(demoEntity);

		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();

		List<DemoEntity> result = sessionFactory.getCurrentSession().createQuery("from DemoEntity").list();
		assertEquals(result.size(), 1);
		assertEquals(result.iterator().next().getProperty(), "testing 123");
	}
}
