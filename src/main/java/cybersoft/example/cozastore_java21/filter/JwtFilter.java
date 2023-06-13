package cybersoft.example.cozastore_java21.filter;

import cybersoft.example.cozastore_java21.utils.JWTHelper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    /**
     * Nhan duoc token truyen tren Headers
     * Giai ma token
     * Neu thanh cong --> thi hop le
     * Tao chung thuc va cho di vao link nguoi dung goi
     * */

    @Autowired
    JWTHelper jwtHelper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String header = request.getHeader("Authorization");

            if(header.startsWith("Brear ")){
                String token = header.substring(7);
                Claims claims = jwtHelper.decodeToken(token);

                if(claims != null){
                    SecurityContext context = SecurityContextHolder.getContext();
                    UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken("","");
                    context.setAuthentication(user);
                }
            }

            filterChain.doFilter(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
