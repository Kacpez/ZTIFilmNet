package zti.FilmNet.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import zti.FilmNet.model.StreamingPlatform;
public interface StreamingPlatformRepository extends JpaRepository<StreamingPlatform, Long>{
}
