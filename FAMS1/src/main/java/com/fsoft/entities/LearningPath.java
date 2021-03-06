package com.fsoft.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LearningPath database table.
 * 
 */
@Entity
@NamedQuery(name="LearningPath.findAll", query="SELECT l FROM LearningPath l")
public class LearningPath implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="learning_code")
	private String learningCode;

	private String descriptions;

	@Column(name="technic_name")
	private String technicName;

	//bi-directional many-to-one association to Courselearn
	@OneToMany(mappedBy="learningPath", fetch=FetchType.EAGER)
	private List<Courselearn> courselearns;

	//bi-directional many-to-one association to Clazz
	@OneToMany(mappedBy="learningPath", fetch=FetchType.EAGER)
	private List<Clazz> clazzs;

	public LearningPath() {
	}

	public String getLearningCode() {
		return this.learningCode;
	}

	public void setLearningCode(String learningCode) {
		this.learningCode = learningCode;
	}

	public String getDescriptions() {
		return this.descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public String getTechnicName() {
		return this.technicName;
	}

	public void setTechnicName(String technicName) {
		this.technicName = technicName;
	}

	public List<Courselearn> getCourselearns() {
		return this.courselearns;
	}

	public void setCourselearns(List<Courselearn> courselearns) {
		this.courselearns = courselearns;
	}

	public Courselearn addCourselearn(Courselearn courselearn) {
		getCourselearns().add(courselearn);
		courselearn.getId().setLearningCode(this.getLearningCode());

		return courselearn;
	}

	public Courselearn removeCourselearn(Courselearn courselearn) {
		getCourselearns().remove(courselearn);
		courselearn.getId().setLearningCode(null);

		return courselearn;
	}

	public List<Clazz> getClazzs() {
		return this.clazzs;
	}

	public void setClazzs(List<Clazz> clazzs) {
		this.clazzs = clazzs;
	}

	public Clazz addClazz(Clazz clazz) {
		getClazzs().add(clazz);
		clazz.setLearningPath(this);

		return clazz;
	}

	public Clazz removeClazz(Clazz clazz) {
		getClazzs().remove(clazz);
		clazz.setLearningPath(null);

		return clazz;
	}

}