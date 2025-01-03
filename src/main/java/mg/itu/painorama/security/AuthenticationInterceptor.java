package mg.itu.painorama.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
	HttpSession session = request.getSession(false); // Ne crée pas une nouvelle session
	Object currentUser = (session != null) ? session.getAttribute("utilisateur") : null;

	if (currentUser == null) {
	    response.sendRedirect("/");
	    return false;
	}

	return true;
    }
}
