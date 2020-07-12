package com.corejava.apachecomparator;

import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee implements Comparable<Employee> {

	static final Logger LOG = LoggerFactory.getLogger(Employee.class);

	private int id;
	private String name;

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int compareTo(Employee o) {
		int nameDiff = this.name.compareTo(o.name);
		if (nameDiff != 0) {
			return nameDiff;
		} else {
			int idDiff = this.id - o.id;
			return idDiff;
		}

		// other order
		/*
		 * int nameDiff = o.name.compareTo(this.name); if (nameDiff != 0) { return
		 * nameDiff; } else { int idDiff = o.id - this.id; return idDiff; }
		 */

	}

	public static Comparator<Employee> employeeNameComparator = new Comparator<Employee>() {

		public int compare(Employee e1, Employee e2) {
			String e1Up = e1.getName().toUpperCase();
			String e2Up = e2.getName().toUpperCase();

			// Employee - ascending order
			return e1Up.compareTo(e2Up);

			// Employee - descending order
			// return e2Up.compareTo(e1Up);
		}

	};

	public static Comparator<Employee> employeeIdComparator = new Comparator<Employee>() {

		public int compare(Employee e1, Employee e2) {
			int e1Up = e1.getId();
			int e2Up = e2.getId();

			// Employee - ascending order
			return e1Up - e2Up;

			// Employee - descending order
			// return e2Up - e1Up;
		}

	};

}
