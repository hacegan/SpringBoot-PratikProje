package samet.proje.projem.service;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import samet.proje.projem.model.Gorev;
import samet.proje.projem.repository.Gorev_Repo;
import samet.proje.projem.service.impl.Gorev_Servis_Impl;
import samet.proje.projem.staticstuff.Principal;

@Service
public class Gorev_Servis implements Gorev_Servis_Impl {

	@Autowired
	Gorev_Repo gorev_Repo;

	Date date = new Date();

	@Override
	public Optional<List<Gorev>> findByUsername(String Username) {
		return gorev_Repo.findByKulusername(Username);
	}

	@Override
	public void deleteGorev(Gorev gorev) {
		gorev.setUpdatedDate(date);
		gorev.setUpdatedBy(Principal.loggedInUser.getUsername());
		gorev_Repo.delete(gorev);
	}

	@Override
	public Gorev updateGorev(Gorev gorev) {
		gorev.setUpdatedDate(date);
		gorev.setUpdatedBy(Principal.loggedInUser.getUsername());
		
	System.out.println(gorev.getCreatedBy()+"   // "+gorev.getCreatedDate());
		
		
		
		return gorev_Repo.save(gorev);
	}

	@Override
	public Gorev createNewGorev(Gorev gorev) {
		gorev.setCreatedDate(date);
		gorev.setUpdatedDate(date);

		gorev.setCreatedBy(Principal.loggedInUser.getUsername());
		gorev.setUpdatedBy(Principal.loggedInUser.getUsername());
		return gorev_Repo.save(gorev);
	}

}
