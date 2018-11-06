package com.example.demo;

import java.io.File;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

public class GroovyScriptRunner {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		GroovyShell shell = new GroovyShell();
		// System.out.println(shell.evaluate("email{from 'prosenjit' to 'Nazeef' subject
		// 'Happy Diwali'}"));

		Binding binding = new Binding();

		GroovyScriptEngine engine = null;
		URL url = null;
		try {
			url = new File("./src/main/java/com/example/demo").toURI().toURL();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch blocks
			e1.printStackTrace();
		}
		System.out.println(url);

		try {
			engine = new GroovyScriptEngine(new URL[] { new File("src/main/java/com/example/demo").toURI().toURL() });
			System.out.println(engine.getConfig().getClasspath());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Class scriptClass = null;
		try {
			scriptClass = engine.loadScriptByName("EmailScript.groovy");
			Object scriptInstance = scriptClass.newInstance();
			scriptClass.getDeclaredMethod("doEmail", new Class[] {}).invoke(scriptInstance, new Object[] {});

		} catch (ResourceException | ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
