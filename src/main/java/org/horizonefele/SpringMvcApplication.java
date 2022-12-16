package org.horizonefele;

import org.horizonefele.dao.TeamRepository;
import org.horizonefele.entities.Team;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringMvcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(SpringMvcApplication.class, args);
		TeamRepository teamDao = ctx.getBean(TeamRepository.class);
		teamDao.save(new Team("Avenir Sportif de Lala", new Float(45000)));
		teamDao.save(new Team("Club Olympique de Transport", new Float(60000)));
		teamDao.save(new Team("Stir Sportif Jarzouna", new Float(40000)));
		// Adding other teams
		teamDao.findAll().forEach(t->System.out.println(t.getName())); }}