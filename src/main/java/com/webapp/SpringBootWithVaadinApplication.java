package com.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;

@SpringBootApplication
@Theme(value = "todo")
@NpmPackage(value = "line-awesome", version = "1.3.0")
public class SpringBootWithVaadinApplication implements AppShellConfigurator{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithVaadinApplication.class, args);
	}

}
