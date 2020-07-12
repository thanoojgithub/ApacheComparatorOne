package com.corejava.apachecomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComparatorOne {

	static final Logger LOG = LoggerFactory.getLogger(ComparatorOne.class);

	List<Person> personList = new ArrayList<Person>();
	List<Employee> employeeList = new ArrayList<Employee>();

	/**
	 * Basic method which creates the list of person object's
	 * 
	 */

	void setUpEmplayeeData() {
		LOG.trace("Employee List");
		employeeList.add(new Employee(1, "SreeRama"));
		employeeList.add(new Employee(2, "Seetha"));
		employeeList.add(new Employee(4, "Lakshmana"));
		employeeList.add(new Employee(5, "Hanuma"));
		employeeList.add(new Employee(3, "Lakshmana"));
	}

	void setUpPersonData() {
		LOG.trace("Person List");
		personList.add(new Person(1, "SreeRama"));
		personList.add(new Person(2, "Seetha"));
		personList.add(new Person(4, "Lakshmana"));
		personList.add(new Person(5, "Hanuma"));
		personList.add(new Person(3, "Lakshmana"));
	}

	void sortEmployee() {
		// 1.
		LOG.trace("sorted Employee List by using Comparable's natual sorting logic");
		Collections.sort(employeeList);
		for (Employee employee : employeeList) {
			LOG.trace(employee.toString());
		}
		// 2.
		LOG.trace("sorted Employee List by using Comparator's employeeIdComparator");
		Collections.sort(employeeList, Employee.employeeIdComparator);
		for (Employee employee : employeeList) {
			LOG.trace(employee.toString());
		}
		// 3.
		LOG.trace("sorted Employee List by using Comparator's employeeNameComparator");
		Collections.sort(employeeList, Employee.employeeNameComparator);
		for (Employee employee : employeeList) {
			LOG.trace(employee.toString());
		}

	}

	void sortPersons(String propertyName) {

		Comparator<Person> comp = new BeanComparator<Person>(propertyName);
		LOG.trace("sorted Person List by using BeanComparator - property :: " + propertyName);
		Collections.sort(personList, comp);
		for (Person person : personList) {
			LOG.trace(person.toString());
		}
	}

	public static void main(String[] args) {
		// comparable and comparator

		ComparatorOne comparatorOne = new ComparatorOne();
		comparatorOne.setUpEmplayeeData();
		comparatorOne.sortEmployee();

		comparatorOne.setUpPersonData();
		comparatorOne.sortPersons("id");
		comparatorOne.sortPersons("name");
	}

}
