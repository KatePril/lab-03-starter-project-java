package docker.lab3.repositories;

import docker.lab3.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    void deleteItemById(Integer id);
    Item findItemById(Integer id);
}
