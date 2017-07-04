package Filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entities.Usuario;

/**
 *
 * @author BryanV
 */

public class LoginFilter implements Filter {

	public LoginFilter() {
	}

	/**
	 *
	 * @param request
	 *            The servlet request we are processing
	 * @param response
	 *            The servlet response we are creating
	 * @param chain
	 *            The filter chain we are processing
	 *
	 * @exception IOException
	 *                if an input/output error occurs
	 * @exception ServletException
	 *                if a servlet error occurs
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		try {
			HttpSession session = httpServletRequest.getSession(false);

			if (session != null) {
				Usuario user = (Usuario) session.getAttribute("userInSession");
				if (user == null) {

					if (isAJAXRequest(httpServletRequest)) {
						processAJAXRequest(httpServletRequest, httpServletResponse);
					} else
						httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsf");
				} else {

					httpServletResponse.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
					httpServletResponse.setHeader("Pragma", "no-cache");
					httpServletResponse.setDateHeader("Expires", 0);

					@SuppressWarnings("unchecked")
					Set<String> pageList = (Set<String>) session.getAttribute("pagesInSession");

					String URL = httpServletRequest.getServletPath();

					if (this.checkURL(pageList, URL) || this.URLAccepted(URL))
						chain.doFilter(request, response);
					else
						httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/notAuthorized.jsf");

				}
			} else
				httpServletResponse
						.sendRedirect(httpServletRequest.getContextPath() + "/login.jsf?faces-redirect=true");

		} catch (Exception exception) {

			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsf?faces-redirect=true");
			System.out.println("Error en el filtro.");
			System.out.println(exception.getMessage());

		}

	}

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public boolean checkURL(Set<String> pageList, String page) {
		for (String string : pageList) {
			if (page.equals(string))
				return true;
		}

		return false;
	}

	public boolean URLAccepted(String page) {
		if (page.equals("/pages/inicio.jsf"))
			return true;
		else
			return false;
	}

	private boolean isAJAXRequest(HttpServletRequest request) {
		boolean check = false;
		String facesRequest = request.getHeader("Faces-Request");
		if (facesRequest != null && facesRequest.equals("partial/ajax")) {
			check = true;
		}
		return check;
	}

	private void processAJAXRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException {
		String redirectURL = httpServletResponse.encodeRedirectURL(httpServletRequest.getContextPath()
				+ "/login.jsf?faces-redirect=true");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><partial-response><redirect url=\"")
				.append(redirectURL).append("\"></redirect></partial-response>");
		httpServletResponse.setHeader("Cache-Control", "no-cache");
		httpServletResponse.setCharacterEncoding("UTF-8");
		httpServletResponse.setContentType("text/xml");
		PrintWriter printWriter = httpServletResponse.getWriter();
		printWriter.println(stringBuilder.toString());
		printWriter.flush();
		return;

	}

}
