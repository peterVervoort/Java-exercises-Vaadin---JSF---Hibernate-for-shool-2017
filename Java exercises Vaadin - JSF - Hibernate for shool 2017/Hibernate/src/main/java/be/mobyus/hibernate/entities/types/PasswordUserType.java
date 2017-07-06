package be.mobyus.hibernate.entities.types;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.springframework.util.ObjectUtils;

public class PasswordUserType implements UserType {

	@Override
	public Object nullSafeGet(final ResultSet rs, final String[] names, final SharedSessionContractImplementor session, final Object owner)
			throws HibernateException, SQLException {
		return null;
	}

	@Override
	public void nullSafeSet(final PreparedStatement st, final Object value, final int index, final SharedSessionContractImplementor session)
			throws HibernateException, SQLException {

	}

	// -- Helpers
	@Override
	public Object deepCopy(Object value) throws HibernateException {
		if (value != null) {
			Password p = (Password) value;
			return new Password(p.getClearText(), p.getPassword());
		}
		return null;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return ObjectUtils.nullSafeEquals(x, y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return ObjectUtils.nullSafeHashCode(x);
	}

	@Override
	public boolean isMutable() {
		return true;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	@Override
	public Class<?> returnedClass() {
		return Password.class;
	}

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.VARCHAR };
	}
}