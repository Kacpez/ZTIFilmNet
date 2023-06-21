package zti.FilmNet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import zti.FilmNet.model.Movie;
/*
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByPublished(boolean published);

    List<Employee> findByTitleContaining(String title);
}*/

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // all crud database methods
}