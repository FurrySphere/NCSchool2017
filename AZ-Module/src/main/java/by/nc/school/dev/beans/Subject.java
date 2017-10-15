package by.nc.school.dev.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 * @version 1.0
 */
public class Subject {
	private boolean isCredit;
	private boolean isExam;
	private int optinalSubjectHours;
	private String subjectName;
	private Professor subjectProfessor;
	private List<Curriculum> subjectStudyPlanList;

	public Subject(){
	}

	public Subject(boolean isCredit, boolean isExam, int optinalSubjectHours, String subjectName,
				   Professor subjectProfessor, List<Curriculum> subjectStudyPlanList) {
		this.isCredit = isCredit;
		this.isExam = isExam;
		this.optinalSubjectHours = optinalSubjectHours;
		this.subjectName = subjectName;
		this.subjectProfessor = subjectProfessor;
		this.subjectStudyPlanList = new ArrayList<Curriculum>(subjectStudyPlanList);
	}

	public boolean isCredit() {
		return isCredit;
	}

	public void setCredit(boolean credit) {
		isCredit = credit;
	}

	public boolean isExam() {
		return isExam;
	}

	public void setExam(boolean exam) {
		isExam = exam;
	}

	public int getOptinalSubjectHours() {
		return optinalSubjectHours;
	}

	public void setOptinalSubjectHours(int optinalSubjectHours) {
		this.optinalSubjectHours = optinalSubjectHours;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Professor getSubjectProfessor() {
		return subjectProfessor;
	}

	public void setSubjectProfessor(Professor subjectProfessor) {
		this.subjectProfessor = subjectProfessor;
	}

	public List<Curriculum> getSubjectStudyPlanList() {
		return subjectStudyPlanList;
	}

	public void setSubjectStudyPlanList(List<Curriculum> subjectStudyPlanList) {
		this.subjectStudyPlanList = new ArrayList<Curriculum>(subjectStudyPlanList);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Subject subject = (Subject) o;

		if (isCredit() != subject.isCredit()) return false;
		if (isExam() != subject.isExam()) return false;
		if (getOptinalSubjectHours() != subject.getOptinalSubjectHours()) return false;
		if (!getSubjectName().equals(subject.getSubjectName())) return false;
		if (!getSubjectProfessor().equals(subject.getSubjectProfessor())) return false;
		return getSubjectStudyPlanList().equals(subject.getSubjectStudyPlanList());
	}

	@Override
	public int hashCode() {
		int result = (isCredit() ? 1 : 0);
		result = 31 * result + (isExam() ? 1 : 0);
		result = 31 * result + getOptinalSubjectHours();
		result = 31 * result + getSubjectName().hashCode();
		result = 31 * result + getSubjectProfessor().hashCode();
		result = 31 * result + getSubjectStudyPlanList().hashCode();
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < subjectStudyPlanList.size(); i++) {
			builder.append(subjectStudyPlanList.get(i)).append(" ");
		}
		return "Subject{" +
				"isCredit=" + isCredit + "\n" +
				"isExam=" + isExam + "\n" +
				"optinalSubjectHours=" + optinalSubjectHours + "\n" +
				"subjectName='" + subjectName + "\n" +
				"subjectProfessor=" + subjectProfessor + "\n" +
				"subjectStudyPlanList=" + builder.toString() + "\n" +
				'}';
	}
}