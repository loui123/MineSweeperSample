package com.loui.spring;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loui.spring.model.MapSize;
import com.loui.spring.model.MineSweeper;
import com.loui.spring.service.MineSweeperService;
import com.loui.spring.service.impl.MineSweeperServiceImpl;
import com.loui.spring.response.GeneralResponse;;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private MineSweeperService mineSweeperService = new MineSweeperServiceImpl();
	private GeneralResponse generalResponse = new GeneralResponse();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public @ResponseBody String game() {
		MineSweeper mineSweeper = mineSweeperService.createMineSweeper(MapSize.SMALL);
		return generalResponse.toJsonString(mineSweeper.getMap());
	}	
}
