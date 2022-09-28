package com.dylansmusicshop.dao;

import java.util.Collection;
import java.util.Optional;

public interface orderDAO<T> {


    Optional<T> get(int id);
    Collection<T> getAll();

}
