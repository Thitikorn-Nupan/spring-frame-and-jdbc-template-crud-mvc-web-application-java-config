package com.springframe.coding.repository;

import java.util.List;
import java.util.Map;

public interface UserRepository<T> {
    public List<T> views();
    public Map<?,T> create(T objects);
    public T view(Long id);
    public Map<?,T> update(T objects);
    public Map<?,T> delete(Long id);
}
