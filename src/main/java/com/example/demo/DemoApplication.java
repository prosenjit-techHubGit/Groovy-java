package com.example.demo;

import java.io.IOException;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.groovy.script.*;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceConnector;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		// SendEmail sendEmail = new SendEmail();
		// sendEmail.doEmail();

		GroovyShell shell = new GroovyShell();
		System.out.println(shell.evaluate("email{from 'prosenjit' to 'Nazeef' subject 'Happy Diwali'}"));

		Binding binding = new Binding();

		GroovyScriptEngine engine = null;
		try {
			engine = new GroovyScriptEngine(new URL[] { new URL("classpath:io/groovy/script") });
			System.out.println(engine.toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SendEmail sendEmail = null;
		try {
			sendEmail = (SendEmail) engine.run("SendEmail.groovy", binding);
		} catch (ResourceException | ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sendEmail.doEmail();

	}
}
