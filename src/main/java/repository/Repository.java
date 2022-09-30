package repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface Repository<K, V> {

    public void init();

    public V save(V v);

    public boolean update(K k, V v);

    public boolean delete(K k);

    public Optional<V> findById(K k);

    public List<V> findAll();

    public List<V> findByName(String name);

    public List<V> findByCreatedDateInterval(LocalDateTime start, LocalDateTime end);


}
