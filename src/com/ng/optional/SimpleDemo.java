package com.ng.optional;

import java.util.Optional;
import java.util.function.Consumer;

public class SimpleDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// 1: way to create
		Optional<String> emptyOptional = Optional.empty();

		Consumer<String> stringConsumer = (s) -> System.out.println("The value stored in Optional object - " + s);
		Runnable runnable = () -> System.out.println("Checkig using ifPresentOrElse : No value stored in the Optional object");

		emptyOptional.ifPresentOrElse(stringConsumer, runnable); // runnable will run as not value present

		// 2: using of, this method wont take null value
		// if you assign null value this will throw java.lang.NullPointerException
		String val1 = "I am optional with of";
		Optional<String> ofOptional = Optional.of(val1);

		// if present method takes a consumer
		ofOptional.ifPresent(System.out::println);

		String val2 = "I am optional with of nullable";

		// 3: using ofNullable, this method can take null value
		Optional<String> ofNullableOptional = Optional.ofNullable(val2);

		ofNullableOptional.ifPresent(System.out::println);

		// 4: get, isEmpty,

		if (ofNullableOptional.isPresent()) {

			System.out.println(ofNullableOptional.get());
		}

		// 5. orElse to get default value
		String defualtValOptional = emptyOptional.orElse("Defualt Value");

		System.out.println(defualtValOptional);

		// 6. orElseGet to get default value
		String defualtValGetOptional = emptyOptional.orElseGet(() -> "Defualt Value using supplier");

		System.out.println(defualtValGetOptional);

		try {
			
			String throwNoSuchElementOptional = emptyOptional.orElseThrow();
		
		} catch (Exception e) {

			System.out.println("I am 'Element Not Found' exception thrown by optional orElseThrow method with message: "+ e.getMessage());
		}

		try {
			
			String throwException1ElementOptional = emptyOptional.orElseThrow(() -> new NullPointerException("Using consumer"));
		
		} catch (Exception e) {

			System.out.println("I am 'Null Pointer' exception thrown by optional orElseThrow method with message: " + e.getMessage());
		}

		try {
			
			String throwException2ElementOptional = emptyOptional.orElseThrow(NullPointerException::new);
		
		} catch (Exception e) {

			System.out.println("I am 'Null Pointer' exception thrown by optional orElseThrow method");
		}
		
		Optional<String> optioanAndMapping = Optional.ofNullable("Sample using Map function");
		
		Optional<String> mappingOutput = optioanAndMapping.map((s)-> s.toUpperCase().trim());
		
		mappingOutput.ifPresent(System.out::println);
		
		//checking with null value
        optioanAndMapping = Optional.ofNullable(null);
		
        //map wont run
		mappingOutput = optioanAndMapping.map((s)-> s.toUpperCase().trim());
		
		//wont execute
		mappingOutput.ifPresent(System.out::println);
		
        Optional<String> optioanAndFiltering = Optional.ofNullable("Sample using filter function");
		
		Optional<String> filteringOutput = optioanAndFiltering.filter((s)-> s.contains("filter")).map((s)-> s.toUpperCase().trim());
		
		filteringOutput.ifPresent(System.out::println);
		
		//checking with null value
		optioanAndFiltering = Optional.ofNullable("filtering this will return blank");
		
        //map wont run
		filteringOutput = optioanAndFiltering.filter((s)-> s.contains("checkme")).map((s)-> s.toUpperCase().trim());
		
		//wont execute
		filteringOutput.ifPresent(System.out::println);
	}

}
