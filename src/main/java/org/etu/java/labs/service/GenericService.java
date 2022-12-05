package org.etu.java.labs.service;

import java.util.List;
import java.util.Locale;

public interface GenericService<Entity> {
    List<Entity> getAll(Locale locale);
    Entity getById(String id, Locale locale);
    String create(Entity item, Locale locale);
    String update(Entity item, Locale locale);
    String delete(String id, Locale locale);
}
