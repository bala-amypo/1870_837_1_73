import java.util.Optional;

public interface WorkflowTemplateRepository
        extends JpaRepository<WorkflowTemplate, Long> {

    Optional<WorkflowTemplate> findById(Long id);
}
