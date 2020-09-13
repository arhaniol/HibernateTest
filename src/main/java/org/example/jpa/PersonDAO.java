package org.example.jpa;

import java.util.List;

public interface PersonDAO {
    public void save(int id, String name);

    public String getName(int id);

    public List getAllPerson();

    public void update(int id, String name);

    public void delete(int id);
}
