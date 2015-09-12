package avaliacao.sample.dao;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import avaliacao.sample.entities.Skill;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Stateless
public class SkillDAO {

	public List<Skill> findAll() {
		try {
			Reader reader = new InputStreamReader(SkillDAO.class.getResourceAsStream(Skill.FILE), "UTF-8");
			Gson gson = new GsonBuilder().create();
			ArrayList<Skill> p = gson.fromJson(reader, new ArrayList<Skill>().getClass());
			return p;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
