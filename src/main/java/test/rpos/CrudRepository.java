package test.rpos;

import java.util.Optional;

/**
 * @author Vorobyev Vyacheslav
 */
public interface CrudRepository<L, T> {

    Optional<T> insert(T t);

    Integer update(T t);

    Optional<T> get(L id);

    Boolean delete(L id);

}