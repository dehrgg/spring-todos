package com.dehrg.todos.controller.ui;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value="gui/tasks")
public class TaskUIController {

	/**
	 * Shows a list of all upcoming tasks
	 * @return model and view for the page
	 */
	@RequestMapping(method = RequestMethod.GET)	
	public ModelAndView index() {
		return null;
	}
	
	/**
	 * Shows the details for a single task
	 * @param id of the task to view
	 * @return model and view for the page
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView show(@PathVariable long id) {
		return null;
	}
	
	/**
	 * Shows the details for a single task in edit mode
	 * @param id of the task to edit
	 * @return model and view for the page
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}/edit")
	public ModelAndView delete(@PathVariable long id) {
		return null;
	}
	
	/**
	 * Shows the form for creating a new task
	 * @return model and view for the page
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/create")
	public ModelAndView create() {
		return null;
	}
}
