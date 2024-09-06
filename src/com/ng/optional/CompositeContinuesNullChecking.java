package com.ng.optional;

import java.util.Optional;

public class CompositeContinuesNullChecking {

	public static void main(String[] args) {

		Student studentObj = new Student();

		Optional<Student> studentOpt = Optional.ofNullable(studentObj);

		String witOptional = studentOpt.map(Student::getAddress).map(Address::getCity).map(City::getState).map(State::getName).orElse("Easy task with optional");
		
		//how its working:
		//Optional<Studnt> being mapped >> optional<Address> >> optional<City> >> optional<State> 
		//then orElse method returning default as one/more optinals are empty
		
		System.out.println(witOptional);

		// now imagine same thing without optional

		String withoutOptional = null;

		if (studentObj != null) {
			
			Address street = studentObj.getAddress();
			
			if (street != null) {
				
				City city = street.getCity();
				
				if (city != null) {
					
					State state = city.getState();
					
					if (state != null) {
						
						String stateName = state.getName();
						
						if (stateName != null) {
							
							withoutOptional = stateName;
						}
						
						withoutOptional = "Painful task without optional";
					}
					
					withoutOptional = "Painful task without optional";
				}
				
				withoutOptional = "Painful task without optional";
			}
			
			withoutOptional = "Painful task without optional";
		}
		
		System.out.println(withoutOptional);
	}

	static class Student {

		private String name;
		private Integer age;
		private Address address;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		
	}

	static class Address {

		private String name;
		private City city;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public City getCity() {
			return city;
		}

		public void setCity(City city) {
			this.city = city;
		}
	}

	static class City {

		private String name;
		private State state;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}
	}

	static class State {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}
