package com.gratex.docs.interceptors;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestCallTimerInterceptor implements HandlerInterceptor {

	private static final Logger logger = Logger.getAnonymousLogger();

	private long requestStartTime;

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		this.requestStartTime = System.currentTimeMillis();
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView mav) throws Exception {
		// this gets called after service completion but before the view generation
		long requestEndTime = System.currentTimeMillis();
		String url = String.valueOf(req.getRequestURL());

		logger.info(() -> "Calling of " + url + " took " + ((requestEndTime - requestStartTime)) + "ms");
	}

	public void afterCompletion() { 
		// this gets called after the view generation
	}

}
