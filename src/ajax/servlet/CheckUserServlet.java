package ajax.servlet; /**
 * @author xinrong
 * @version 1.0
 */

import ajax.entity.User;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "CheckUserServlet", value = "/CheckUserServlet")
public class CheckUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String uname = request.getParameter("uname");
        System.out.println("uname=" + uname);
        //假定用户名为 king , 就不可用, 其它用户名可以
        if("king".equals(uname)) {//不能使用king用户名
            //后面这个信息，是从DB获取
            User king = new User(100, "king", "666", "king@sohu.com");
            //把 king 转成 json字符串
            String strKing = new Gson().toJson(king);
            //返回
//            String strKing = king.toString();
            response.getWriter().write(strKing);
        } else {
            //如果用户名可以用，返回""
            response.getWriter().write("");
        }

    }
}

