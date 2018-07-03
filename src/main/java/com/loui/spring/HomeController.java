package com.loui.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loui.spring.model.MapSize;
import com.loui.spring.model.MineSweeper;
import com.loui.spring.service.MineSweeperService;
import com.loui.spring.service.impl.MineSweeperServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private MineSweeperService mineSweeperService = new MineSweeperServiceImpl();

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public String game() {
		MineSweeper mineSweeper = mineSweeperService.createMineSweeper(MapSize.SMALL);
		mineSweeperService.printMineSweeper(mineSweeper);
		return "game";
	}
	
}
