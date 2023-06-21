package zti.FilmNet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import zti.FilmNet.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
@SpringBootApplication
public class FilmNetApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FilmNetApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
