package com.ReservationArtisanaux.demoReservationArtisanaux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages=("com.ReservationArtisanaux.demoReservationArtisanaux.controllers"
	//	+"com.ReservationArtisanaux.demoReservationArtisanaux.services"))
public class DemoReservationArtisanauxApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoReservationArtisanauxApplication.class, args);
	}

}
