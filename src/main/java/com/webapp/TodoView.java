package com.webapp;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/")
public class TodoView extends VerticalLayout {
	
	private TodoRepo repo;
	
	public TodoView(TodoRepo repo) {
		this.repo = repo;
		
		var task = new TextField();
		var button = new Button("Add");
		var todos = new VerticalLayout();
		
		todos.setPadding(false);
		button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		button.addClickShortcut(Key.ENTER);
		
		repo.findAll().forEach(todo->todos.add(createCheckbox(todo))); //To persist the values on page reload
		
		add(
				new H1("Todo"),
				new HorizontalLayout(task, button),
				todos
		);
		
		button.addClickListener(click -> {
			var todo = repo.save(new Todo(task.getValue()));
			todos.add(createCheckbox(todo));
			task.clear();
		});
	}
	
	private Component createCheckbox(Todo todo) {
		return new Checkbox(todo.getTask(), todo.isDone(),
				e -> {
					todo.setDone(e.getValue());
					repo.save(todo);
				});
	}
}
