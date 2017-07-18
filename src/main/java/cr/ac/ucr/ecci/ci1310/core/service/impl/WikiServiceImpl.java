package cr.ac.ucr.ecci.ci1310.core.service.impl;

import cr.ac.ucr.ecci.ci1310.core.dao.WikiDao;
import cr.ac.ucr.ecci.ci1310.core.dao.impl.WikiDaoImpl;
import cr.ac.ucr.ecci.ci1310.core.service.WikiService;

import java.util.List;

/**
 * Created by Josue Cubero on 11/07/2017.
 */
public class WikiServiceImpl<K,V> implements WikiService<K,V> {


    private WikiDao<K,V> wikiDao = new WikiDaoImpl();

    public V getDataWithId(K id) {
        return this.wikiDao.getDataWithId(id);
    }

    public <V> List<V> getDataWithName(K name) {
        return this.wikiDao.getDataWithName(name);
    }
}
