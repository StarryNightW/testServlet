import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Refresh extends HttpServlet {
    //处理GET方法请求的方法
    public void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        response.setIntHeader("Refresh",5);
        response.setContentType("text/html;charset=UTF-8");

        Calendar cale = Calendar.getInstance();
        Date tasktime = cale.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = df.format(tasktime);
        PrintWriter out = response.getWriter();
        String title = "自动刷新 Header 设置 - 菜鸟教程实例";
        String docType =  "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n"+
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<p>当前时间是：" + nowTime + "</p>\n");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        doGet(request,response);
    }
}
