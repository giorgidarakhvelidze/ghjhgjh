package ge.giorgi.darakhvelidze.repository;

import ge.giorgi.darakhvelidze.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface TaskRepository extends JpaRepository<Task, Long> {

}
