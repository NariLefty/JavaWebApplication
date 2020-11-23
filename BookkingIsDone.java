package freeasg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookkingIsDone
 */
@WebServlet("/freeasg/BookkingIsDone")
public class BookkingIsDone extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookkingIsDone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection con = null;
        PreparedStatement ps = null;
		try {
			PrintWriter out = response.getWriter();
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			String nowTime = sdf.format(date);

			String driverUrl = "jdbc:derby:C:\\JavaDB\\freeasgdb;create=false";

			con = DriverManager.getConnection(driverUrl, "db", "db");

			String sql = "insert into FREEASIGNMENT(name,cus_count,seat,cus_time)values(?,?,?,?)";

			ps = con.prepareStatement(sql);

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>BookkingIsDone</title>");
			out.println("</head>");
			out.println("<body>");

            HttpSession session = request.getSession(false);

            if (session == null) {
				out.println("タイムアウトしました");
				out.println("<a href=\"Customer\">戻る</a>");
			}
            else {
				out.println("<h4>予約しました</h4>");

				BookkingCusInfo bci = (BookkingCusInfo)session.getAttribute("bci");

				ps.setString(1, bci.getName());
				ps.setInt(2, bci.getCusCount());
				ps.setString(3, bci.getSeat());
				ps.setString(4, nowTime);
				int count = ps.executeUpdate();
				out.println("<table>");
				out.println("<tr><td>お名前：</td><td>"+ bci.getName() +"</td></tr>");
				out.println("<tr><td>人数：</td><td>"+ bci.getCusCount() + "人" + "</td></tr>");
				out.println("<tr><td>座席；</td><td>" + bci.getSeat() + "</td></tr>");
				out.println("<tr><td>予約時刻：</td><td>" + nowTime + "</td></tr>");
				out.println("</table>");
				out.println("<p><a href=\"Customer\">戻る</a></p>");

            }

			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			throw new ServletException(e);
        } finally {
            //例外が発生する・しないにかかわらず確実にデータベースから切断
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
            }
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
