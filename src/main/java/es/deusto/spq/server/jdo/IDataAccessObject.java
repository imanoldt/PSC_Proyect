package es.deusto.spq.server.jdo;

import java.util.List;

public interface IDataAccessObject<DomainObject> {
	public void Save(DomainObject object);
	public void delete(DomainObject object);
	public List<DomainObject> getAll();
	public DomainObject find(String param);
	public void update(DomainObject object);
}
