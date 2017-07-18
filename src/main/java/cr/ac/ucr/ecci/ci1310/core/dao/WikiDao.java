package cr.ac.ucr.ecci.ci1310.core.dao;

import java.util.List;

/**
 * Created by Josue Cubero on 11/07/2017.
 */
public interface WikiDao<K,V> {
    V getDataWithId(K id);
    <V> List<V> getDataWithName(K name);
}
