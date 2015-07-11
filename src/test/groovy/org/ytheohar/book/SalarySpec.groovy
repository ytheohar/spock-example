package org.ytheohar.book


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.text.DateFormat;
import java.text.SimpleDateFormat
import java.util.List;

import org.ytheohar.salary.Employee
import org.ytheohar.salary.SalaryManager

import spock.lang.*

class SalarySpec extends Specification {

	def "Modify an employee's salary " () {
		given: "the salary management system is initialized with the following data"
			[
				[1, 'donald', 60000.0],
				[2, 'dewie', 62000.0],
				[3, 'goofy', 55000.0],
				[4, 'scrooge', 70000.0],
				[5, 'daisy', 56000.0],
				[6, 'minnie', 62000.0],
				[7, 'mickey', 51000.0],
				[8, 'fethry', 66500.0]
			]
		when: "the boss increases the salary for the employee with id '3' by 5%"
		then: "the payroll for the employee with id '3' should display a salary of 57750"
	}
	
	def "Modify an employee's salary" () {
		given: "the salary management system is initialized with the following data"
			def data = [
				[1, 'donald', 60000.0],
				[2, 'dewie', 62000.0],
				[3, 'goofy', 55000.0],
				[4, 'scrooge', 70000.0],
				[5, 'daisy', 56000.0],
				[6, 'minnie', 62000.0],
				[7, 'mickey', 51000.0],
				[8, 'fethry', 66500.0]
			]
			SalaryManager manager = new SalaryManager(employees(data));

		when: "the boss increases the salary for the employee with id '3' by 5%"
			manager.increaseSalary(3, 5);

		then: "the payroll for the employee with id '3' should display a salary of 57750"
			Employee nominee = manager.getPayroll(3);
			nominee.getSalary() == 57750.0;
	}

	@Unroll
	def "Modify the salary employee #id by #percent percent" () {
		given: "the salary management system is initialized with the following data"
			def data = [
				[1, 'donald', 60000.0],
				[2, 'dewie', 62000.0],
				[3, 'goofy', 55000.0],
				[4, 'scrooge', 70000.0],
				[5, 'daisy', 56000.0],
				[6, 'minnie', 62000.0],
				[7, 'mickey', 51000.0],
				[8, 'fethry', 66500.0]
			]
			SalaryManager manager = new SalaryManager(employees(data));

		when: "the boss increases the salary for the employee with 'id' by 'percent' % as per data table"
			manager.increaseSalary(id, percent);

		then: "the payroll for the employee with 'id' should display a salary of 'expected' as per data table"
			Employee nominee = manager.getPayroll(id);
			nominee.getSalary() == expected;

		where:
			id  | percent 	|| expected
			1   |   2		|| 61200.0
			2   |   7		|| 66340.0
			3   |   5		|| 57750.0
			4   |   12		|| 78400.0
			5   |   -2		|| 54880.0
			6   |   4		|| 64480.0
			7   |   -7		|| 47430.0
			8   |   0		|| 66500.0
	}
	
	def employees(data) {
		data.collect { new Employee(id: it[0], user: it[1], salary: it[2])}
	}
}
