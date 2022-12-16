package org.horizonefele.web;

import java.util.List;
import java.util.Optional;

import org.horizonefele.dao.TeamRepository;
import org.horizonefele.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeamController {

	@Autowired
	private TeamRepository teamDao;

	@RequestMapping(value="/teams/search")
	public String search(Model model, @RequestParam(name="motCle",
	defaultValue="")String mc) {
		List<Team> teams = teamDao.findByName("%"+mc+"%");
		model.addAttribute("teams",teams);
		return "myteams"; }

	@RequestMapping(value="/teams/add" )
	public String add(Model model, @RequestParam(name="name",defaultValue="")String name,@RequestParam(name="budget", defaultValue="0")float budget) {

		if (!(name.equals(""))) {

			model.addAttribute("name",name);
			model.addAttribute("budget", budget);
			Team t = new Team(name, budget);
			teamDao.save(t);

		}
		return "addTeam";

	}

	@RequestMapping(value="/teams/delete" )
	public String delete(Model model,

			@RequestParam(name="ref", defaultValue="")Long idTeam,
			@RequestParam(name="mc", defaultValue="")String mc) {

		teamDao.deleteById(idTeam);
		return "redirect:/teams/search?motCle="+mc;

	}

	@RequestMapping(value="/teams/edit" )
	public String edit(Model model,

			@RequestParam(name="ref", defaultValue="")Long idTeam,
			@RequestParam(name="name", defaultValue="")String name,
			@RequestParam(name="budget", defaultValue="")Float budget,
			@RequestParam(name="edit", defaultValue="0")int edit,
			@RequestParam(name="mc", defaultValue="")String mc) {
		if (edit == 0) {
			model.addAttribute("idTeam", idTeam);
			model.addAttribute("name", name);
			model.addAttribute("budget", budget);
			model.addAttribute("motCle", mc);
			return "editTeam";
		}
		else {
			Optional<Team> ot = teamDao.findById(idTeam);
			Team t = ot.get();
			t.setName(name);
			t.setBudget(budget);
			teamDao.save(t);
			return "redirect:/teams/search?motCle="+mc;
		} }

}
