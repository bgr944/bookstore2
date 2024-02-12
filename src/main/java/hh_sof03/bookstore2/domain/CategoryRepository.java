package hh_sof03.bookstore2.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	
    List<Category> findByName(String name);

}
