package com.springframe.coding.repository;

import java.util.List;
import java.util.Map;

public interface UserRepository<T> {
    List<T> views();
    Map<?,T> create(T objects);
    T view(Long id);
    Map<?,T> update(T objects);
    Map<?,T> delete(Long id);
}
