# sbootcouchbase
This is the simple project to connect nosql-couchbase  using spring boot

Simple file ===================Properties
=====appliection.properties========
spring.couchbase.bootstrap-hosts=localhost
spring.couchbase.bucket.name=beer-sample
spring.couchbase.bucket.password=
spring.data.couchbase.auto-index=true




================= application.java main java class=============
package com.example;

	import com.couchbase.client.java.repository.annotation.Id;
	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.data.couchbase.core.mapping.Document;
	import org.springframework.data.couchbase.repository.CouchbaseRepository;
	import org.springframework.stereotype.Component;

	import java.util.Collection;
	import java.util.UUID;
	import java.util.stream.Stream;

	@SpringBootApplication
		public class CouchabasedemoApplication {

		public static void main(String[] args) {
			SpringApplication.run(CouchabasedemoApplication.class, args);
		}
	}
	 interface MovieRepository extends CouchbaseRepository<Movie,String>{
	    Collection<Movie> findByTitle(String title);
	 }


	@Component
	class SampleMovieCLR implements CommandLineRunner{
		private final MovieRepository movieRepository;

		public SampleMovieCLR(MovieRepository movieRepository){
			this.movieRepository=movieRepository;
		}

		@Override
		public void run(String... args) throws Exception{
			Stream.of("Film1","fillm2","film3")
					.forEach(title->this.movieRepository.save(new Movie(UUID.randomUUID().toString(),title)));
		}
	}


	@Document
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	class Movie{
	@Id
	private  String id;
	private String title;
	}
