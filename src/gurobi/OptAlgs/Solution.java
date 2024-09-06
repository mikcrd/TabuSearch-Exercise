package gurobi.OptAlgs;

import java.util.ArrayList;
import java.util.Objects;

public class Solution {

	ArrayList<Job> solution = new ArrayList<>();

	public Solution(ArrayList<Job> solution) {

		this.solution = (ArrayList<Job>) solution.clone();
	}

	public Solution(int [] p, int [] d) {
		for(int i = 0; i < d.length; i++) {
			solution.add(new Job(p[i], d[i]));
		}
		setID(solution);
	}


	public void setID(ArrayList<Job> solution) {
		int i = 1;
		for(Job job : solution) {
			job.setID(i++);
		}
	}

	public ArrayList<Job> getSolution() {
		return solution;
	}

	public void setSolution(ArrayList<Job> solution) {
		this.solution = solution;
	}

	public int getObjectiveFunct() {
		int cost = 0;
		int processingTime = 0;
		for(Job job : solution) {
			processingTime = processingTime + job.getProcTime();
			if(processingTime > job.getDueDate()) {
				cost = cost + processingTime - job.getDueDate();
			}
		}
		return cost;
	}
	
	public void printSolution() {
		for(Job job : solution) {
			job.printJob();
		}
		System.out.printf(" | cost = %d\n", getObjectiveFunct());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Solution solution1 = (Solution) o;
		return Objects.equals(solution, solution1.solution);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(solution);
	}
}
